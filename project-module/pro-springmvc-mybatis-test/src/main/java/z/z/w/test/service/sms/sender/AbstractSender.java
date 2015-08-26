package z.z.w.test.service.sms.sender;

import java.util.Map;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.service.sms.sender.AbstractSender.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年8月26日 下午2:27:23 
 *   LastChange: 2015年8月26日 下午2:27:23 
 *      History:
 * </pre>
 **************************************************************************/
public abstract class AbstractSender implements ISender
{
	
	/*
	 * (non-Javadoc)
	 * @see z.z.w.test.service.sms.sender.ISender#sendSms()
	 */
	public String sendSms()
	{
		try
		{
			long ll = ( long ) ( Math.random() * 1000 );
			logger.info( "sendSms=[{}]-[{}]", this, ll );
			Thread.sleep( ll * 10 );
			return "result:success,fail:";
		}
		catch ( InterruptedException e )
		{
			logger.error( "sms check error : [{}].", e.getMessage(), e );
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see z.z.w.test.service.sms.sender.ISender#httpUrl()
	 */
	public String httpUrl()
	{
		logger.info( "httpUrl=======" );
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see z.z.w.test.service.sms.sender.ISender#httpParam()
	 */
	public Map< String, String > httpParam()
	{
		logger.info( "httpParam=======" );
		return null;
	}
	
}
