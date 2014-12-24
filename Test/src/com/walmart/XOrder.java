package com.walmart;

import java.util.List;

@SuppressWarnings("unchecked")
public class XOrder extends Order {
	private List<XOrderLine> orderLines;

	@Override
	public List<? extends OrderLine> getOrderLines() {
		return orderLines;
	}

	@Override
	public void setOrderLines(List<? extends OrderLine> orderLines) {
		this.orderLines = (List<XOrderLine>) orderLines;
	}
}
