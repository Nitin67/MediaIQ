package com.aconex;

import java.util.ArrayList;
import java.util.List;

public class XMLNode {

	private String id;
	private String value;
	private Integer slNo;
	private List<XMLNode> children = new ArrayList<XMLNode>();

	public XMLNode(String str){
		if(str!=null){
			String[] strArray = str.split(" ", 3);
			this.setSlNo(Integer.valueOf(strArray[0]));
			this.setId(strArray[1]);
			this.setValue(strArray[2]);
		}
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	public void setChildren(List<XMLNode> children) {
		this.children = children;
	}

	public List<XMLNode> getChildren() {
		return children;
	}
}
