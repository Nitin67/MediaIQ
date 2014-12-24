package com.maloo;

class Heap{
	int data;
	int row;
	int col;
	Heap(int data,int r,int c)
	{
		this.data=data;
		this.row=r;
		this.col=c;
	}
}

public class KthminIn2DSortedArray {
	
	public static int kthMin(int [][]ar,int k)
	{
		if(k<=0 || k> ar.length*ar[0].length)
			return Integer.MAX_VALUE;
			
		Heap []heap=new Heap[ar[0].length];
		for(int i=0;i<ar[0].length;i++)
		{
			heap[i]=new Heap(ar[0][i], 0, i);
		}
		buildHeap(heap, ar[0].length);
		
		for(int i=0;i<k;i++)
		{
			Heap hr=heap[0];
			int newVal=(hr.row<ar[0].length-1)?ar[hr.row+1][hr.col]:Integer.MAX_VALUE;
			if(hr.row<ar[0].length-1){
			heap[0].data=newVal;
			heap[0].col=hr.col;
			heap[0].row++;
			}
			minHeapify(heap, 0, ar.length);
		}
		return heap[0].data;
	}
	
	public static void buildHeap(Heap []heap,int n)
	{
		int i=(n-1)/2;
		while(i>=0)
		{
			minHeapify(heap, i, n);
			i--;
		}
	}
	
	
	public static void minHeapify(Heap []heap,int index,int heapSize)
	{
		int left=2*index+1;
		int right=2*index+2;
		int smallest=index;
		if(left<heapSize && heap[left].data<heap[smallest].data)
			smallest=left;
		if(right<heapSize && heap[right].data<heap[smallest].data)
			smallest=right;
		
		if(index!=smallest)
		{
			swap(heap,index,smallest);
			minHeapify(heap, smallest, heapSize);
		}
		
	}
	
	
	
	private static void swap(Heap[] heap, int index, int smallest) {
		int temp=heap[index].data;
		heap[index].data=heap[smallest].data;
		heap[smallest].data=temp;
		temp=heap[index].row;
		heap[index].row=heap[smallest].row;
		heap[smallest].row=temp;
		temp=heap[index].col;
		heap[index].col=heap[smallest].col;
		heap[smallest].col=temp;
		
	}
	public static void main(String []args)
	{
		int ar[][]={{10,20,30,40},
				{15,25,35,45},
				{18,29,37,48},
				{19,33,39,50}
		};
		System.out.println(kthMin(ar,7)); 
	}

}
