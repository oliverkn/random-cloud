package com.randc.cloud.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class AbstractClientConnection
{
	public abstract void accept() throws IOException;

	public abstract void disconnect() throws IOException;

	public abstract InputStream getInputStream();

	public abstract OutputStream getOutputStream();
}
