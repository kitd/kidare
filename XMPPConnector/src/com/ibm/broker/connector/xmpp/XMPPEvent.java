package com.ibm.broker.connector.xmpp;

import org.jivesoftware.smack.packet.Packet;

import com.ibm.broker.connector.ByteArrayInputRecord;
import com.ibm.broker.connector.Event;
import com.ibm.broker.connector.InputRecord;
import com.ibm.broker.plugin.MbException;

public class XMPPEvent extends Event {
	private final Packet msg;
	
	public XMPPEvent(Packet arg0) throws MbException {
		super();
		this.msg = arg0;
	}

	@Override
	public InputRecord buildInputRecord() throws MbException {
		InputRecord inputRecord = new ByteArrayInputRecord();
		((ByteArrayInputRecord) inputRecord)
					.appendByteArray(msg.toXML().getBytes());
		return inputRecord;
	}

}
