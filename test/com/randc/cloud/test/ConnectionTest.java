package com.randc.cloud.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.randc.cloud.config.ClientConfig;
import com.randc.cloud.config.ConfigLoader;
import com.randc.cloud.config.ServerConfig;
import com.randc.cloud.connection.AbstractConnection;
import com.randc.cloud.connection.AbstractServer;
import com.randc.cloud.connection.TCPIPConnection;
import com.randc.cloud.connection.TCPIPServer;

public class ConnectionTest
{
	public static void main(String[] args) throws Exception
	{
		ServerConfig serverConfig = ConfigLoader.loadServerConfig(new File("server_config.xml"));
		ClientConfig clientConfig = ConfigLoader.loadCientConfig(new File("client_config.xml"));

		AbstractServer server = new TCPIPServer(serverConfig.getPort());

		AbstractConnection clientToServer = new TCPIPConnection(clientConfig.getServerAddress(),
				clientConfig.getServerPort());
		AbstractConnection serverToClient = server.accept();
		
		System.out.println("Connection established");
		
		OutputStream clientToServerOut = clientToServer.getOutputStream();
		InputStream serverToClientIn = serverToClient.getInputStream();
		InputStreamReader inReader = new InputStreamReader(serverToClientIn);
		BufferedReader bufReader = new BufferedReader(inReader);
		
		System.out.println("Stream opened");
		
		clientToServerOut.write("Hallo Server hier ist der Client!".getBytes());
		clientToServerOut.close();
		
		System.out.println(bufReader.readLine());
		
		System.out.println("Finished");
	}
}
