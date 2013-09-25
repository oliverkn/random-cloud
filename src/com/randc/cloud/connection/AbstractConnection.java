package com.randc.cloud.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class AbstractConnection
{
	public abstract void connect() throws IOException;

	public abstract void disconnect() throws IOException;

	public abstract InputStream getInputStream() throws IOException;

	public abstract OutputStream getOutputStream() throws IOException;
}
