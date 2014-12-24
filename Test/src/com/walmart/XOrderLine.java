package com.walmart;

import java.util.List;

@SuppressWarnings("unchecked")
public class XOrderLine extends OrderLine {
	private List<XShipment> xshipments;

	@Override
	public List<? extends Shipment> getShipments() {
		return xshipments;
	}

	@Override
	public void setShipments(List<? extends Shipment> xshipments) {
		this.xshipments = (List<XShipment>) xshipments;
	}
}
