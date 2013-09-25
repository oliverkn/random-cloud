package com.randc.cloud.config;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ConfigFactory
{
	private static final SAXBuilder SAX_BUILDER = new SAXBuilder();

	public static ClientConfig loadCientConfig(File xmlFile) throws JDOMException, IOException
	{
		Document document = SAX_BUILDER.build(xmlFile);
		Element root = document.getRootElement();

		ClientConfig config = new ClientConfig();
		config.setServerAddress(InetAddress.getByName(root.getChildText("ServerAddress")));
		config.setServerPort(Integer.parseInt(root.getChildText("ServerPort")));
		config.setUser(root.getChildText("User"));
		config.setPassword(root.getChildText("Password"));

		return config;
	}

	public static ServerConfig loadServerConfig(File xmlFile) throws JDOMException, IOException
	{
		Document document = SAX_BUILDER.build(xmlFile);
		Element root = document.getRootElement();

		ServerConfig config = new ServerConfig();
		config.setPort(Integer.parseInt(root.getChildText("Port")));

		return config;
	}
}
