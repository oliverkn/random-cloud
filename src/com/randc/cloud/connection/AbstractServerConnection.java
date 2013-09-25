package com.randc.cloud.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.randc.cloud.config.ClientConfig;

public abstract class AbstractServerConnection
{
	protected ClientConfig config;

	public AbstractServerConnection(ClientConfig config)
	{
		this.config = config;
	}

	public abstract void connect() throws IOException;

	public abstract void disconnect() throws IOException;

	public abstract InputStream getInputStream();

	public abstract OutputStream getOutputStream();

	protected abstract void authenticate();
}
