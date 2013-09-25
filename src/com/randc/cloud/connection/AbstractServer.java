package com.randc.cloud.connection;

public abstract class AbstractServer
{
	protected int port;

	public AbstractServer(int port)
	{
		this.port = port;
	}

	public abstract void start();

	public abstract void shutDown();

	public abstract AbstractConnection accept();
}
