package com.ibm.broker.connector.xmpp;

import java.util.Properties;

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
	
	@Override
    public Properties buildProperties() throws MbException {
        
        //super's version of this method causes a null pointer exception
		//workaround by returning an empty Properties object.
		//eventually, we should populate this with some of the extra information about the packet
		//Arguably, most of the packet [meta]data would go into these properties and we would just grab the body in buildInputRecord
        Properties leValues = new Properties();
        return leValues;
		
    }

    @Override
    public void confirm() throws MbException {
        
        super.confirm();
        
    }

}
