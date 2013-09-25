package com.randc.cloud.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.randc.cloud.config.ClientConfig;

public class TCPIPServerConnection extends AbstractServerConnection
{
	private Socket socket;
	private InputStream inStream;
	private OutputStream outStream;

	public TCPIPServerConnection(ClientConfig config) throws IOException
	{
		super(config);
		socket = new Socket(config.getServerAddress(), config.getPort());
	}

	@Override
	public void connect() throws IOException
	{
		inStream = socket.getInputStream();
		outStream = socket.getOutputStream();
	}

	@Override
	public void disconnect() throws IOException
	{
		inStream.close();
		outStream.close();
		socket.close();
	}

	@Override
	public InputStream getInputStream()
	{
		return inStream;
	}

	@Override
	public OutputStream getOutputStream()
	{
		return outStream;
	}

	@Override
	protected void authenticate()
	{
		// TODO Auto-generated method stub
	}
}
