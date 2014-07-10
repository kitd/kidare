package com.ibm.broker.connector.xmpp;

import java.util.Properties;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;

import com.ibm.broker.connector.ConnectorFactory;
import com.ibm.broker.connector.EventInputConnector;
import com.ibm.broker.connector.OutputConnector;
import com.ibm.broker.plugin.MbException;

public class XMPPConnectorFactory extends ConnectorFactory {

	private XMPPConnection connection = null;
	private String hostName = "kidare.hursley.ibm.com";
	private int port = 5222;
	private String userName = "iib";
	private String password = "m86gpdOF";
	
	@Override
	public String getInfo() throws MbException {
		return "XMPP Connector v0.1";
	}
	
	public XMPPConnectorFactory() {
		super();
		System.out.println("XMPP ctor");
		System.out.println("broker.jarpath="+System.getProperty("broker.jarpath"));
		System.out.println("broker.envclasspath="+System.getProperty("broker.envclasspath"));
		System.out.println("broker.externalResourcesJarsURLS="+System.getProperty("broker.externalResourcesJarsURLS"));
		System.out.println("java.class.path="+System.getProperty("java.class.path"));
	}

	XMPPConnection getConnection() {
		return connection;
	}

	@Override
	public EventInputConnector createEventInputConnector(String name,
			Properties sessionProps) throws MbException {
		// TODO Auto-generated method stub
		return new XMPPInputConnector(this, name, sessionProps);
	}

	@Override
	public OutputConnector createOutputConnector(String name,
			Properties properties) throws MbException {
		// TODO Auto-generated method stub
		return new XMPPOutputConnector(this, name, properties);
	}

	@Override
	public void initialize(String name, Properties properties)
			throws MbException {
		super.initialize(name, properties);
		System.out.println("XMPP init");
	}

	@Override
	public void start() throws MbException {
		ConnectionConfiguration config = new ConnectionConfiguration(hostName, port);
		config.setSendPresence(true);
		connection = new XMPPConnection(config);
		try {
			connection.connect();
			connection.login(userName, password);
			System.out.println("XMPP start");
		} catch (XMPPException e) {
			e.printStackTrace();
			getContainerServices().throwMbRecoverableException(e);
		}
	}

	@Override
	public void stop() throws MbException {
		Presence absence = new Presence(Presence.Type.unavailable);
		connection.disconnect(absence);
		super.stop();
		System.out.println("XMPP stop");
	}

	String getHostName() {
		return hostName;
	}

	int getPort() {
		return port;
	}

	@Override
	public void terminate() throws MbException {
		super.terminate();
	}

	
}
