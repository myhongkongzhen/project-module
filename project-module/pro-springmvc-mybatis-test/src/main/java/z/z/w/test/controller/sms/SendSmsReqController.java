package z.z.w.test.controller.sms;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import z.z.w.test.service.sms.SendSmsReqService;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.controller.sms.SendSmsReqController.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年8月25日 上午11:57:19 
 *   LastChange: 2015年8月25日 上午11:57:19 
 *      History:
 * </pre>
 **************************************************************************/
@Controller
@Scope( value = "prototype" )
@RequestMapping( value = "/smscc" )
public class SendSmsReqController
{
	private static final Logger	logger	= LoggerFactory.getLogger( SendSmsReqController.class );
	
	private SendSmsReqService	sendSmsReqService;
	
	/**
	 * http://localhost:8888/smscc/single/jflsdjfkldsjflkdsj.zzw?data=errjwelr
	 * 
	 * Create by : 2015年8月25日 下午12:01:28
	 */
	@RequestMapping( value = "/single/{appKey}", produces = "text/plain;charset=UTF-8" )
	@ResponseBody
	public String smsCheck( @PathVariable String appKey, String data, HttpServletRequest request )
	{
		try
		{
//			data = StringUtils.substring( UUID.randomUUID().toString(), 20 );
			logger.debug( "[{}][{}]--Request :[{}]-[{}].", new Object[ ] { this, sendSmsReqService, appKey, data } );
			sendSmsReqService.updateSmsInfos( appKey, data );
		}
		catch ( Exception e )
		{
			logger.error( "sms check error : [{}].", e.getMessage(), e );
			return "ERROR";
		}
		return "SUCCESS";
	}
	
	/**
	 * @return the sendSmsReqService
	 */
	public SendSmsReqService getSendSmsReqService()
	{
		return sendSmsReqService;
	}
	
	/**
	 * @param sendSmsReqService the sendSmsReqService to set
	 */
	@Resource
	public void setSendSmsReqService( SendSmsReqService sendSmsReqService )
	{
		this.sendSmsReqService = sendSmsReqService;
	}
}
