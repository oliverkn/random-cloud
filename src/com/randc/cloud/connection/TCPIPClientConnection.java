package com.randc.cloud.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPIPClientConnection extends AbstractClientConnection
{
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private InputStream inStream;
	private OutputStream outStream;

	public TCPIPClientConnection(ServerSocket serverSocket)
	{
		this.serverSocket = serverSocket;
	}

	@Override
	public void accept() throws IOException
	{
		clientSocket = serverSocket.accept();
		
		inStream = clientSocket.getInputStream();
		outStream = clientSocket.getOutputStream();
	}

	@Override
	public void disconnect() throws IOException
	{
		inStream.close();
		outStream.close();
		clientSocket.close();
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
}
