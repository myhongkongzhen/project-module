package z.z.w.test.service.sms.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import z.z.w.test.cache.SmsQueueCatch;
import z.z.w.test.dao.sms.biz.mapper.MerchantChannelBandMapper;
import z.z.w.test.service.sms.sender.ISender;
import z.z.w.test.vo.ParamsVo;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.service.sms.biz.ParseSmsObjServer.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年8月25日 下午3:33:20 
 *   LastChange: 2015年8月25日 下午3:33:20 
 *      History:
 * </pre>
 **************************************************************************/
@Service
@Scope( value = "prototype" )
public class ParseSmsObjServer implements Runnable
{
	private static final Logger			logger	= LoggerFactory.getLogger( ParseSmsObjServer.class );
	private MerchantChannelBandMapper	merchantChannelBandMapper;
	private WebApplicationContext		webApplicationContext;
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		ParamsVo obj = null;
		while ( ( obj = SmsQueueCatch.take() ) != null )
		{
			logger.info( "Queue size : [{}].", SmsQueueCatch.getSize() );
			final ParamsVo pv = obj;
			
			List< String > channelCodes = pv.getChannelCodes();// Arrays.asList( StringUtils.splitByWholeSeparator(
																// pv.getMsgId(), "," ) );
			String channelCode = merchantChannelBandMapper.getChannelCodeByAccount( pv.getMerchantAccount(), channelCodes );
			logger.info( "{}=***[{}]", this, channelCode );
			
			try
			{
				ISender sender = ( ISender ) webApplicationContext.getBean( channelCode );
				String result = sender.sendSms();
				
				if ( !StringUtils.isBlank( result ) )
				{
					if ( StringUtils.contains( result, "success" ) )
					{
						logger.info( "Send sms result :{}.", result );
					}
					else
					{
						check( pv, channelCode );
						logger.warn( "Send sms result :{}.", result );
					}
				}
				else
				{
					check( pv, channelCode );
					logger.warn( "Send sms result :{}.", result );
				}
			}
			catch ( Exception e )
			{
				logger.error( "sms check error : [{}].", e.getMessage(), e );
				check( pv, channelCode );
			}
			
		}
		
	}
	
	/**
	 * Create by : 2015年8月26日 下午2:45:57
	 */
	private void check( ParamsVo pv, String channelCode )
	{
		if ( pv.getCount() < 3 )
		{
			pv.setCount( pv.getCount() + 1 );
			pv.getChannelCodes().add( channelCode );
//			logger.info( "################################[{}].", ArrayUtils.toArray( pv.getChannelCodes() ) );
			SmsQueueCatch.addData( pv );
		}
		logger.warn( "[SMS has been sent 3 times!!!!]" );
	}
	
	/**
	 * @return the merchantChannelBandMapper
	 */
	public MerchantChannelBandMapper getMerchantChannelBandMapper()
	{
		return merchantChannelBandMapper;
	}
	
	/**
	 * @param merchantChannelBandMapper the merchantChannelBandMapper to set
	 */
	@Resource
	public void setMerchantChannelBandMapper( MerchantChannelBandMapper merchantChannelBandMapper )
	{
		this.merchantChannelBandMapper = merchantChannelBandMapper;
	}
	
	/**
	 * @return the webApplicationContext
	 */
	public WebApplicationContext getWebApplicationContext()
	{
		return webApplicationContext;
	}
	
	/**
	 * @param webApplicationContext the webApplicationContext to set
	 */
	@Resource
	public void setWebApplicationContext( WebApplicationContext webApplicationContext )
	{
		this.webApplicationContext = webApplicationContext;
	}
	
}
