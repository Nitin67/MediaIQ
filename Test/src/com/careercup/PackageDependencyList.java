package com.careercup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Vertice {
	int parents = 0;
	int value;
	List<Vertice> adjacent = new ArrayList<Vertice>();

	public void addChild(Vertice v) {
		v.parents += 1;
		adjacent.add(v);
	}

	public List<Vertice> getChildren() {
		return this.adjacent;
	}
}

public class PackageDependencyList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vertice v1 = new Vertice();
		v1.value = 1;
		Vertice v2 = new Vertice();
		v2.value = 2;
		Vertice v3 = new Vertice();
		v3.value = 3;
		Vertice v4 = new Vertice();
		v4.value = 4;
		Vertice v5 = new Vertice();
		v5.value = 5;
		v4.addChild(v2);
		v3.addChild(v1);
		v3.addChild(v2);
		v5.addChild(v2);
		List<Vertice> list = new ArrayList<Vertice>();
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		list.add(v5);
		List<Vertice> orderList = getOrderList(list);
		Iterator<Vertice> itr = orderList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().value);
		}
	}

	public static Set<Vertice> getParentVerticesSet(List<Vertice> list) {
		Set<Vertice> parentEdge = new HashSet<Vertice>();
		Iterator<Vertice> itr = list.iterator();
		while (itr.hasNext()) {
			Vertice v = itr.next();
			if (v.parents == 0)
				parentEdge.add(v);
		}
		return parentEdge;
	}

	public static List<Vertice> getOrderList(List<Vertice> list) {
		List<Vertice> orderList = new ArrayList<Vertice>();
		if (list != null && list.size() > 0) {
			Set<Vertice> parents = getParentVerticesSet(list);
			Iterator<Vertice> itr = parents.iterator();
			while (itr.hasNext()) {
				orderList.addAll(getBFS(itr.next()));
			}
		}
		return orderList;
	}

	private static Collection<? extends Vertice> getBFS(Vertice v) {
		List<Vertice> bfsOuput = new ArrayList<Vertice>();
		Queue<Vertice> vQueue = new LinkedList<Vertice>();
		if (v != null) {
			vQueue.offer(v);
			while (!vQueue.isEmpty()) {
				Vertice outVertice = vQueue.poll();
				List<Vertice> children = outVertice.getChildren();
				Iterator<Vertice> itr = children.iterator();
				while (itr.hasNext()) {
					Vertice child = itr.next();
					child.parents = child.parents - 1;
					if (child.parents == 0)
						vQueue.offer(child);
				}
				bfsOuput.add(outVertice);
			}
		}
		return bfsOuput;
	}
}
