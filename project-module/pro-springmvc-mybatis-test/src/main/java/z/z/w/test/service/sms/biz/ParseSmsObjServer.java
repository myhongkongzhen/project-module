package z.z.w.test.service.sms.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import z.z.w.test.cache.SmsQueueCatch;
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
	private static final Logger	logger	= LoggerFactory.getLogger( ParseSmsObjServer.class );
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		ParamsVo obj = null;
		while ( ( obj = SmsQueueCatch.take() ) != null )
		{
			final ParamsVo pv = obj;
			logger.info( "{}=[{}]", this, pv.toString() );
		}
		
	}
	
}
