package com.fb;

import java.util.ArrayList;
import java.util.List;



public interface CompositeNode {

	boolean isCompositeNode();
	List<CompositeNode> getChildren();
	Object getData();
	
	public class CompositeNodeImpl implements CompositeNode{

		int data;
		List<CompositeNodeImpl> chidren =new ArrayList<CompositeNode.CompositeNodeImpl>();
		
		
		
		
		
		@Override
		public boolean isCompositeNode() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public List<CompositeNode> getChildren() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getData() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	
}
