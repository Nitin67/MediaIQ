package com.walmart;

import java.util.List;

public class OrderLine {
private List<? extends Shipment> shipments;

public    List<? extends Shipment> getShipments() {
	return shipments;
}

public void setShipments(List<? extends Shipment> shipments) {
	this.shipments = shipments;
}
}
