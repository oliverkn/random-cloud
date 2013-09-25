package com.randc.cloud.connection;

import java.io.IOException;

public abstract class AbstractServer
{
	protected int port;

	public AbstractServer(int port)
	{
		this.port = port;
	}

	public abstract void start() throws IOException;

	public abstract void shutDown() throws IOException;

	public abstract AbstractConnection accept() throws IOException;
}
