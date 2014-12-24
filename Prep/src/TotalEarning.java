import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;


public class TotalEarning {

	
	public static void main(String []args)
	{
		Scanner scanner=new Scanner(System.in);
		int G=scanner.nextInt();
		Queue<Integer> queuegroup= new ArrayBlockingQueue<Integer>(G);
		for(int i=0;i<G;i++)
		{
			queuegroup.add(scanner.nextInt());
		}
		int busCapacity=scanner.nextInt();
		int noOfRounds=scanner.nextInt();
		Queue<Integer> queue=new ArrayBlockingQueue<Integer>(G);
		int totalSum=0;
		for(int i=0;i<noOfRounds;i++)
		{
			int sum=0;
			while(sum+queuegroup.peek()<=busCapacity)
			{
				sum+=queuegroup.peek();
				queue.add(queuegroup.peek());
				queuegroup.remove();
				if(queuegroup.isEmpty())
				{
					for (Iterator iterator = queue.iterator(); iterator
							.hasNext();) {
						queuegroup.add( (Integer) iterator.next());
						iterator.remove();
					}
					
				}
			}
			totalSum+=sum;
		}
		System.out.println(totalSum);
	}
}
