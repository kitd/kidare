package com.ibm.broker.connector.xmpp;

import java.util.Properties;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;

import com.ibm.broker.connector.ConnectorFactory;
import com.ibm.broker.connector.Event;
import com.ibm.broker.connector.EventInputConnector;
import com.ibm.broker.plugin.MbException;

public class XMPPInputConnector extends EventInputConnector implements PacketListener {
	private final String jid;
	private final String pwd;
	private XMPPConnection connection = null;

	public XMPPInputConnector(ConnectorFactory arg0, String arg1,
			Properties arg2) throws MbException {
		super(arg0, arg1, arg2);
		jid = arg2.getProperty("JabberID");
		pwd = arg2.getProperty("Password");
	}

	@Override
	public void logNoEvent() throws MbException {
		// TODO Auto-generated method stub
		super.logNoEvent();
	}

	@Override
	public void start() throws MbException {
		String host = ((XMPPConnectorFactory)getConnectorFactory()).getHostName();
		int port = ((XMPPConnectorFactory)getConnectorFactory()).getPort();
		ConnectionConfiguration config = new ConnectionConfiguration(host, port);
		config.setSendPresence(true);
		connection = new XMPPConnection(config);
		try {
			connection.connect();
			connection.login(jid, pwd);
			connection.addPacketListener(this, new PacketFilter(){
				@Override
				public boolean accept(Packet arg0) {
					return true;
				}
			});
		} catch (XMPPException e) {
			e.printStackTrace();
			getConnectorFactory().getContainerServices().throwMbRecoverableException(e);
		}
	}

	@Override
	public void stop() throws MbException {
		Presence absence = new Presence(Presence.Type.unavailable);
		connection.disconnect(absence);
		super.stop();
	}

	@Override
	public void processPacket(Packet arg0) {
		Event[] events = new Event[1];
		try {
			events[0] = new XMPPEvent(arg0);
			deliverEvents(events);
		} catch (MbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
