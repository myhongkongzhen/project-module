package z.z.w.test.service.sms.sender;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.service.sms.sender.ISender.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年8月26日 下午2:26:10 
 *   LastChange: 2015年8月26日 下午2:26:10 
 *      History:
 * </pre>
 **************************************************************************/
public interface ISender
{
	static final Logger	logger	= LoggerFactory.getLogger( ISender.class );
	
	String sendSms();
	
	String httpUrl();
	
	Map< String, String > httpParam();
}
