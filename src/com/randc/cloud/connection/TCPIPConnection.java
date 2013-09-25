package com.randc.cloud.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPIPConnection extends AbstractConnection
{
	private Socket socket;

	public TCPIPConnection(InetAddress address, int port) throws IOException
	{
		socket = new Socket(address, port);
	}

	public TCPIPConnection(Socket socket)
	{
		this.socket = socket;
	}

	@Override
	public void connect() throws IOException
	{

	}

	@Override
	public void disconnect() throws IOException
	{
		socket.close();
	}

	@Override
	public InputStream getInputStream() throws IOException
	{
		return socket.getInputStream();
	}

	@Override
	public OutputStream getOutputStream() throws IOException
	{
		return socket.getOutputStream();
	}

}
