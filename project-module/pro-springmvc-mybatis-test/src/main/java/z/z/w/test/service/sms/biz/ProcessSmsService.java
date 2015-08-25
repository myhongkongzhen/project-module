package z.z.w.test.service.sms.biz;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.service.sms.biz.ProcessSmsService.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年8月25日 下午3:30:41 
 *   LastChange: 2015年8月25日 下午3:30:41 
 *      History:
 * </pre>
 **************************************************************************/
@Service
public class ProcessSmsService
{
	private ThreadPoolTaskExecutor	threadPoolTaskExecutor;
	private WebApplicationContext	webApplicationContext;
	
	@PostConstruct
	public void dispather()
	{
		int corePoolSize = threadPoolTaskExecutor.getCorePoolSize();
		for ( int i = 0; i < corePoolSize; i++ )
		{
			threadPoolTaskExecutor.execute( webApplicationContext.getBean( ParseSmsObjServer.class ) );
		}
		
	}
	
	/**
	 * @return the threadPoolTaskExecutor
	 */
	public ThreadPoolTaskExecutor getThreadPoolTaskExecutor()
	{
		return threadPoolTaskExecutor;
	}
	
	/**
	 * @param threadPoolTaskExecutor the threadPoolTaskExecutor to set
	 */
	@Resource
	public void setThreadPoolTaskExecutor( ThreadPoolTaskExecutor threadPoolTaskExecutor )
	{
		this.threadPoolTaskExecutor = threadPoolTaskExecutor;
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
