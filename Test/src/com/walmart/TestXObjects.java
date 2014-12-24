package com.walmart;

import java.util.ArrayList;
import java.util.List;

public class TestXObjects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XShipment xShipment = new XShipment();
		xShipment.setNumber(1);
		xShipment.setNumber2(2);
		List<XShipment> xShipments = new ArrayList<XShipment>();
		xShipments.add(xShipment);
		XOrderLine xOrderLine = new XOrderLine();
		xOrderLine.setShipments(xShipments);
		List<XOrderLine> xOrderLines = new ArrayList<XOrderLine>();
		xOrderLines.add(xOrderLine);
		XOrder xOrder = new XOrder();
		xOrder.setOrderLines(xOrderLines);

	}

}
