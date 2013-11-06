package com.ibm.broker.connector.xmpp.nodes;

import com.ibm.broker.config.appdev.InputTerminal;
import com.ibm.broker.config.appdev.Node;
import com.ibm.broker.config.appdev.NodeProperty;
import com.ibm.broker.config.appdev.OutputTerminal;

/*** 
 * <p>  <I>XMPPReceiveNodeUDN</I> instance</p>
 * <p></p>
 */
public class XMPPReceiveNodeUDN extends Node {

	private static final long serialVersionUID = 1L;

	// Node constants
	protected final static String NODE_TYPE_NAME = "com/ibm/broker/connector/xmpp/nodes/XMPPReceiveNode";
	protected final static String NODE_GRAPHIC_16 = "platform:/plugin/XMPPNodes/icons/full/obj16/com/ibm/broker/connector/xmpp/nodes/XMPPReceive.gif";
	protected final static String NODE_GRAPHIC_32 = "platform:/plugin/XMPPNodes/icons/full/obj30/com/ibm/broker/connector/xmpp/nodes/XMPPReceive.gif";

	protected final static String PROPERTY_CONNECTORNAME = "connectorName";
	protected final static String PROPERTY_JABBERID = "JabberID";
	protected final static String PROPERTY_PASSWORD = "Password";

	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(XMPPReceiveNodeUDN.PROPERTY_CONNECTORNAME,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.STRING, "XMPP","","",	"com/ibm/broker/connector/xmpp/nodes/XMPPReceive",	"XMPPNodes"),
			new NodeProperty(XMPPReceiveNodeUDN.PROPERTY_JABBERID,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"com/ibm/broker/connector/xmpp/nodes/XMPPReceive",	"XMPPNodes"),
			new NodeProperty(XMPPReceiveNodeUDN.PROPERTY_PASSWORD,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"com/ibm/broker/connector/xmpp/nodes/XMPPReceive",	"XMPPNodes")
		};
	}

	public XMPPReceiveNodeUDN() {
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
	 * Set the <I>XMPPReceiveNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>connectorName</I>"
	 */
	public XMPPReceiveNodeUDN setConnectorName(String value) {
		setProperty(XMPPReceiveNodeUDN.PROPERTY_CONNECTORNAME, value);
		return this;
	}

	/**
	 * Get the <I>XMPPReceiveNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @return String; the value of the property "<I>connectorName</I>"
	 */
	public String getConnectorName() {
		return (String)getPropertyValue(XMPPReceiveNodeUDN.PROPERTY_CONNECTORNAME);
	}

	/**
	 * Set the <I>XMPPReceiveNodeUDN</I> "<I>JabberID</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>JabberID</I>"
	 */
	public XMPPReceiveNodeUDN setJabberID(String value) {
		setProperty(XMPPReceiveNodeUDN.PROPERTY_JABBERID, value);
		return this;
	}

	/**
	 * Get the <I>XMPPReceiveNodeUDN</I> "<I>JabberID</I>" property
	 * 
	 * @return String; the value of the property "<I>JabberID</I>"
	 */
	public String getJabberID() {
		return (String)getPropertyValue(XMPPReceiveNodeUDN.PROPERTY_JABBERID);
	}

	/**
	 * Set the <I>XMPPReceiveNodeUDN</I> "<I>Password</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Password</I>"
	 */
	public XMPPReceiveNodeUDN setPassword(String value) {
		setProperty(XMPPReceiveNodeUDN.PROPERTY_PASSWORD, value);
		return this;
	}

	/**
	 * Get the <I>XMPPReceiveNodeUDN</I> "<I>Password</I>" property
	 * 
	 * @return String; the value of the property "<I>Password</I>"
	 */
	public String getPassword() {
		return (String)getPropertyValue(XMPPReceiveNodeUDN.PROPERTY_PASSWORD);
	}

	public String getNodeName() {
		String retVal = super.getNodeName();
		if ((retVal==null) || retVal.equals(""))
			retVal = "XMPPReceive";
		return retVal;
	};
}
