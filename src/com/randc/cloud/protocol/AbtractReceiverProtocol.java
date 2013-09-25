package com.randc.cloud.protocol;

import java.io.InputStream;

public abstract class AbtractReceiverProtocol
{
	protected InputStream in;

	public AbtractReceiverProtocol(InputStream in)
	{
		this.in = in;
	}
	
	public abstract String receiveCommand();
	
	public abstract byte[] receiveData();
}
