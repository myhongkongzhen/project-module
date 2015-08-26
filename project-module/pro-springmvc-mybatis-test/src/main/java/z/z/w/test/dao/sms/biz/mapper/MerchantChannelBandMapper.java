package z.z.w.test.dao.sms.biz.mapper;

import org.apache.ibatis.annotations.Param;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.dao.sms.biz.mapper.MerchantChannelBandMapper.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年8月26日 上午9:21:26 
 *   LastChange: 2015年8月26日 上午9:21:26 
 *      History:
 * </pre>
 **************************************************************************/
public interface MerchantChannelBandMapper
{
	String getChannelCodeByAccount( @Param( value = "merchantAccount" ) String merchantAccount );
}
