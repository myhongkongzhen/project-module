package z.z.w.test.vo;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.vo.MerchantSmsSend.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年8月25日 下午2:40:14 
 *   LastChange: 2015年8月25日 下午2:40:14 
 *      History:
 * </pre>
 **************************************************************************/
public class MerchantSmsSend
{
	private Long	id;
	private String	merchantAccount;
	private String	smsContent;
	private String	smsChannelCode;
	
	public MerchantSmsSend()
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
		return "MerchantSmsSend [id=" + id + ", merchantAccount=" + merchantAccount + ", smsContent=" + smsContent + ", smsChannelCode=" + smsChannelCode + "]";
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
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		result = prime * result + ( ( merchantAccount == null ) ? 0 : merchantAccount.hashCode() );
		result = prime * result + ( ( smsChannelCode == null ) ? 0 : smsChannelCode.hashCode() );
		result = prime * result + ( ( smsContent == null ) ? 0 : smsContent.hashCode() );
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
		MerchantSmsSend other = ( MerchantSmsSend ) obj;
		if ( id == null )
		{
			if ( other.id != null ) return false;
		}
		else if ( !id.equals( other.id ) ) return false;
		if ( merchantAccount == null )
		{
			if ( other.merchantAccount != null ) return false;
		}
		else if ( !merchantAccount.equals( other.merchantAccount ) ) return false;
		if ( smsChannelCode == null )
		{
			if ( other.smsChannelCode != null ) return false;
		}
		else if ( !smsChannelCode.equals( other.smsChannelCode ) ) return false;
		if ( smsContent == null )
		{
			if ( other.smsContent != null ) return false;
		}
		else if ( !smsContent.equals( other.smsContent ) ) return false;
		return true;
	}
	
	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId( Long id )
	{
		this.id = id;
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
	 * @return the smsContent
	 */
	public String getSmsContent()
	{
		return smsContent;
	}
	
	/**
	 * @param smsContent the smsContent to set
	 */
	public void setSmsContent( String smsContent )
	{
		this.smsContent = smsContent;
	}
	
	/**
	 * @return the smsChannelCode
	 */
	public String getSmsChannelCode()
	{
		return smsChannelCode;
	}
	
	/**
	 * @param smsChannelCode the smsChannelCode to set
	 */
	public void setSmsChannelCode( String smsChannelCode )
	{
		this.smsChannelCode = smsChannelCode;
	}
}
