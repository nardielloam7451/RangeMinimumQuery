/**
 * 
 */
package rangeMinQueue;

import java.util.Random;
/**
 * @author nardi
 *
 */
public class RMQdriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RMQueue testQueue= new RMQueue(10);
		Random rand= new Random();
		
		int[] sorted= {0,1,2,3,4,5,6,7,8,9};
	
		testQueue.STAlgorithm(sorted, sorted.length);
		
		System.out.println(testQueue.query(0, 4));
		System.out.println(testQueue.query(4, 7));
		System.out.println(testQueue.query(7,9));
		
		int[] random= new int[1000];
		for(int i=0;i<random.length;i++) {
			random[i]=rand.nextInt(1000);
		}
		
		testQueue.STAlgorithm(random, random.length);
		System.out.println(testQueue.query(0, 10));
		System.out.println(testQueue.query(25, 50));
		System.out.println(testQueue.query(75, 100));
	}

}
