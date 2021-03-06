package z.z.w.test.vo;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.vo.ParamsVo.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年8月25日 下午2:39:56 
 *   LastChange: 2015年8月25日 下午2:39:56 
 *      History:
 * </pre>
 **************************************************************************/
public class ParamsVo
{
	private String			merchantAccount;
	private String			msgId;
	
	private MerchantSmsSend	merchantSmsSend;
	
	public ParamsVo()
	{
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ParamsVo [merchantAccount=" + merchantAccount + ", msgId=" + msgId + ", merchantSmsSend=" + merchantSmsSend + "]";
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( merchantAccount == null ) ? 0 : merchantAccount.hashCode() );
		result = prime * result + ( ( merchantSmsSend == null ) ? 0 : merchantSmsSend.hashCode() );
		result = prime * result + ( ( msgId == null ) ? 0 : msgId.hashCode() );
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( Object obj )
	{
		if ( this == obj ) return true;
		if ( obj == null ) return false;
		if ( getClass() != obj.getClass() ) return false;
		ParamsVo other = ( ParamsVo ) obj;
		if ( merchantAccount == null )
		{
			if ( other.merchantAccount != null ) return false;
		}
		else if ( !merchantAccount.equals( other.merchantAccount ) ) return false;
		if ( merchantSmsSend == null )
		{
			if ( other.merchantSmsSend != null ) return false;
		}
		else if ( !merchantSmsSend.equals( other.merchantSmsSend ) ) return false;
		if ( msgId == null )
		{
			if ( other.msgId != null ) return false;
		}
		else if ( !msgId.equals( other.msgId ) ) return false;
		return true;
	}
	
	/**
	 * @return the merchantAccount
	 */
	public String getMerchantAccount()
	{
		return merchantAccount;
	}
	
	/**
	 * @param merchantAccount the merchantAccount to set
	 */
	public void setMerchantAccount( String merchantAccount )
	{
		this.merchantAccount = merchantAccount;
	}
	
	/**
	 * @return the msgId
	 */
	public String getMsgId()
	{
		return msgId;
	}
	
	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId( String msgId )
	{
		this.msgId = msgId;
	}
	
	/**
	 * @return the merchantSmsSend
	 */
	public MerchantSmsSend getMerchantSmsSend()
	{
		return merchantSmsSend;
	}
	
	/**
	 * @param merchantSmsSend the merchantSmsSend to set
	 */
	public void setMerchantSmsSend( MerchantSmsSend merchantSmsSend )
	{
		this.merchantSmsSend = merchantSmsSend;
	}
}
