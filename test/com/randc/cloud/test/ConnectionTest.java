package com.randc.cloud.test;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;

import com.randc.cloud.config.ClientConfig;
import com.randc.cloud.config.ConfigFactory;
import com.randc.cloud.config.ServerConfig;
import com.randc.cloud.connection.TCPIPClientConnection;
import com.randc.cloud.connection.TCPIPServerConnection;

public class ConnectionTest
{
	public static void main(String[] args) throws Exception
	{
		ServerConfig serverConfig = ConfigFactory.loadServerConfig(new File("server_config.xml"));
		ClientConfig clientConfig = ConfigFactory.loadCientConfig(new File("client_config.xml"));

		ServerSocket server = new ServerSocket(serverConfig.getPort());

		TCPIPClientConnection clientConnection = new TCPIPClientConnection(server);
		TCPIPServerConnection serverConnection = new TCPIPServerConnection(clientConfig);

		clientConnection.accept();
		serverConnection.connect();

		System.out.println("Connected");

		InputStream clientToServerDownload = clientConnection.getInputStream();
		OutputStream clientToServerUpload = serverConnection.getOutputStream();

		clientToServerUpload.write("Hallo Server".getBytes());
		serverConnection.disconnect();

		int read;
		while ((read = clientToServerDownload.read()) != -1)
		{
			System.out.print(new Character((char) read));
		}
		clientConnection.disconnect();

		System.out.println();
		System.out.println("Finish");
	}
}
