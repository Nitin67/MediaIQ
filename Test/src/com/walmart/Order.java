package com.walmart;

import java.util.List;

public class Order {
	private List<? extends OrderLine> orderLines;

	public List<? extends OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<? extends OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

}
