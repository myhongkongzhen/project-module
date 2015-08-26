package z.z.w.test.service.sms;

import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import z.z.w.test.cache.SmsQueueCatch;
import z.z.w.test.dao.sms.biz.mapper.MerchantChannelBandMapper;
import z.z.w.test.vo.MerchantSmsSend;
import z.z.w.test.vo.ParamsVo;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.service.sms.SendSmsReqService.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年8月25日 下午12:05:57 
 *   LastChange: 2015年8月25日 下午12:05:57 
 *      History:
 * </pre>
 **************************************************************************/
@Service
@Scope( value = "prototype" )
public class SendSmsReqService
{
	private static final Logger			logger	= LoggerFactory.getLogger( SendSmsReqService.class );
	private MerchantChannelBandMapper	merchantChannelBandMapper;
	
	/**
	 * Create by : 2015年8月25日 下午12:07:02
	 */
	public void updateSmsInfos( String appKey, String data )
	{
		ParamsVo pv = new ParamsVo();
		
		String uid = UUID.randomUUID().toString().replaceAll( "-", "" );
		pv.setMerchantAccount( uid );
		pv.setMsgId( String.valueOf( ( long ) ( Math.random() * 10000 ) ) );
		
		MerchantSmsSend merchantSmsSend = new MerchantSmsSend();
		merchantSmsSend.setId( ( long ) ( Math.random() * 10000 ) );
		merchantSmsSend.setMerchantAccount( pv.getMerchantAccount() );
		merchantSmsSend.setSmsChannelCode( appKey );
		
		String content = "您的验证码为：" + ( ( long ) ( Math.random() * 10000 ) ) + "。" + data;
		merchantSmsSend.setSmsContent( content );
		
		pv.setMerchantSmsSend( merchantSmsSend );
		
		String merchantAccount = "";
		merchantChannelBandMapper.getChannelCodeByAccount( merchantAccount );
		
		logger.debug( "[{}].", pv.toString() );
		
		SmsQueueCatch.addData( pv );
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
}
