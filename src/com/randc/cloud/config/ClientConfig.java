package com.randc.cloud.config;

import java.net.InetAddress;

public class ClientConfig
{
	private InetAddress serverAddress;
	private int serverPort;

	private String user, password;

	public InetAddress getServerAddress()
	{
		return serverAddress;
	}

	protected void setServerAddress(InetAddress serverAddress)
	{
		this.serverAddress = serverAddress;
	}

	public int getServerPort()
	{
		return serverPort;
	}

	protected void setServerPort(int port)
	{
		this.serverPort = port;
	}

	public String getUser()
	{
		return user;
	}

	protected void setUser(String user)
	{
		this.user = user;
	}

	public String getPassword()
	{
		return password;
	}

	protected void setPassword(String password)
	{
		this.password = password;
	}
}
