package z.z.w.test.cache;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import z.z.w.test.vo.ParamsVo;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.cache.SmsQueueCatch.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年8月25日 下午2:38:40 
 *   LastChange: 2015年8月25日 下午2:38:40 
 *      History:
 * </pre>
 **************************************************************************/
public class SmsQueueCatch
{
	private static Logger						logger	= LoggerFactory.getLogger( SmsQueueCatch.class );
	private static BlockingQueue< ParamsVo >	queue	= new LinkedBlockingQueue< ParamsVo >( 100000 );
	
	private SmsQueueCatch()
	{
		super();
	}
	
	/**
	 * 向消息发送队列中增加一条待发送的短信
	 * 
	 * @param data
	 * @return
	 */
	public static boolean addData( ParamsVo data )
	{
		try
		{
			return queue.add( data );
		}
		catch ( IllegalStateException e )
		{
			logger.warn( "存放待发送短消息的队列已经满了" );
			return Boolean.FALSE;
		}
	}
	
	/**
	 * 从队列中取一条记录
	 * 
	 * @return
	 */
	public static ParamsVo take()
	{
		try
		{
			return queue.take();
		}
		catch ( InterruptedException e )
		{
			logger.warn( "Take queue error." );
			return null;
		}
	}
	
	/**
	 * @return
	 */
	public static BlockingQueue< ParamsVo > getChinaChannelQueue()
	{
		return queue;
	}
	
	public static int getSize()
	{
		return queue.size();
	}
}
