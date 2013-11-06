package com.ibm.broker.connector.xmpp;

import java.util.Properties;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;

import com.ibm.broker.connector.OutputConnector;
import com.ibm.broker.connector.OutputInteraction;
import com.ibm.broker.connector.OutputRecord;
import com.ibm.broker.plugin.MbException;

public class XMPPOutputInteraction extends OutputInteraction {
	
	public XMPPOutputInteraction(OutputConnector connector) throws MbException {
		super(connector);
	}

	@Override
	public Properties send(Properties arg0, OutputRecord arg1)
			throws MbException {
		XMPPConnection connection = ((XMPPConnectorFactory)getConnector().getConnectorFactory()).getConnection();
		Message msg = new Message();
		msg.setTo(getConnector().getProperties().getProperty("to"));
		msg.setBody(arg1.getUTF8Data());
		connection.sendPacket(msg);
		return null;
	}

}
