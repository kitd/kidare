package com.ibm.broker.connector.xmpp.nodes;

import com.ibm.broker.config.appdev.InputTerminal;
import com.ibm.broker.config.appdev.Node;
import com.ibm.broker.config.appdev.NodeProperty;
import com.ibm.broker.config.appdev.OutputTerminal;

/*** 
 * <p>  <I>XMPPSendNodeUDN</I> instance</p>
 * <p></p>
 */
public class XMPPSendNodeUDN extends Node {

	private static final long serialVersionUID = 1L;

	// Node constants
	protected final static String NODE_TYPE_NAME = "com/ibm/broker/connector/xmpp/nodes/XMPPSendNode";
	protected final static String NODE_GRAPHIC_16 = "platform:/plugin/XMPPNodes/icons/full/obj16/com/ibm/broker/connector/xmpp/nodes/XMPPSend.gif";
	protected final static String NODE_GRAPHIC_32 = "platform:/plugin/XMPPNodes/icons/full/obj30/com/ibm/broker/connector/xmpp/nodes/XMPPSend.gif";

	protected final static String PROPERTY_TO = "To";
	protected final static String PROPERTY_CONNECTORNAME = "connectorName";

	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(XMPPSendNodeUDN.PROPERTY_TO,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"com/ibm/broker/connector/xmpp/nodes/XMPPSend",	"XMPPNodes"),
			new NodeProperty(XMPPSendNodeUDN.PROPERTY_CONNECTORNAME,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.STRING, "XMPP","","",	"com/ibm/broker/connector/xmpp/nodes/XMPPSend",	"XMPPNodes")
		};
	}

	public XMPPSendNodeUDN() {
	}

	public final InputTerminal INPUT_TERMINAL_IN = new InputTerminal(this,"InTerminal.in");
	@Override
	public InputTerminal[] getInputTerminals() {
		return new InputTerminal[] {
			INPUT_TERMINAL_IN
	};
	}

	public final OutputTerminal OUTPUT_TERMINAL_OUT = new OutputTerminal(this,"OutTerminal.out");
	@Override
	public OutputTerminal[] getOutputTerminals() {
		return new OutputTerminal[] {
			OUTPUT_TERMINAL_OUT
		};
	}

	@Override
	public String getTypeName() {
		return NODE_TYPE_NAME;
	}

	protected String getGraphic16() {
		return NODE_GRAPHIC_16;
	}

	protected String getGraphic32() {
		return NODE_GRAPHIC_32;
	}

	/**
	 * Set the <I>XMPPSendNodeUDN</I> "<I>To</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>To</I>"
	 */
	public XMPPSendNodeUDN setTo(String value) {
		setProperty(XMPPSendNodeUDN.PROPERTY_TO, value);
		return this;
	}

	/**
	 * Get the <I>XMPPSendNodeUDN</I> "<I>To</I>" property
	 * 
	 * @return String; the value of the property "<I>To</I>"
	 */
	public String getTo() {
		return (String)getPropertyValue(XMPPSendNodeUDN.PROPERTY_TO);
	}

	/**
	 * Set the <I>XMPPSendNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>connectorName</I>"
	 */
	public XMPPSendNodeUDN setConnectorName(String value) {
		setProperty(XMPPSendNodeUDN.PROPERTY_CONNECTORNAME, value);
		return this;
	}

	/**
	 * Get the <I>XMPPSendNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @return String; the value of the property "<I>connectorName</I>"
	 */
	public String getConnectorName() {
		return (String)getPropertyValue(XMPPSendNodeUDN.PROPERTY_CONNECTORNAME);
	}

	public String getNodeName() {
		String retVal = super.getNodeName();
		if ((retVal==null) || retVal.equals(""))
			retVal = "XMPPSend";
		return retVal;
	};
}
