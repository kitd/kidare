package com.ibm.broker.connector.xmpp;

import java.util.Properties;

import com.ibm.broker.connector.ConnectorFactory;
import com.ibm.broker.connector.OutputConnector;
import com.ibm.broker.connector.OutputInteraction;
import com.ibm.broker.plugin.MbException;

public class XMPPOutputConnector extends OutputConnector {

	public XMPPOutputConnector(ConnectorFactory connectorFactory, String name,
			Properties properties) throws MbException {
		super(connectorFactory, name, properties);
	}

	@Override
	public OutputInteraction createOutputInteraction() throws MbException {
		return new XMPPOutputInteraction(this);
	}

}
