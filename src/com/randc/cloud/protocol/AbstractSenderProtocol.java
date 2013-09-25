package com.randc.cloud.protocol;

import java.io.OutputStream;

public abstract class AbstractSenderProtocol
{
	protected OutputStream out;

	public AbstractSenderProtocol(OutputStream out)
	{
		this.out = out;
	}
	
	public abstract void sendCommand(String command);
	
	public abstract void sendData(byte[] data);
}
