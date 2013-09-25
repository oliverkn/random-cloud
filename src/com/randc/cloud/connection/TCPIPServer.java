package com.randc.cloud.connection;

import java.io.IOException;
import java.net.ServerSocket;

public class TCPIPServer extends AbstractServer
{
	private ServerSocket server;

	public TCPIPServer(int port) throws IOException
	{
		super(port);
		server = new ServerSocket(port);
	}

	@Override
	public void start() throws IOException
	{
		
	}

	@Override
	public void shutDown() throws IOException
	{
		server.close();
	}

	@Override
	public AbstractConnection accept() throws IOException
	{
		return new TCPIPConnection(server.accept());
	}
}
