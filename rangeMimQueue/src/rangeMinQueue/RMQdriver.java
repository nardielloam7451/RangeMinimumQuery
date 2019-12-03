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
		
		int[] test= {7,2,3,0,5,10,3,12,18};
	
		testQueue.STAlgorithm(test, test.length);
		
		System.out.println(testQueue.query(0, 4));
		System.out.println(testQueue.query(4, 7));
		System.out.println(testQueue.query(7,8));
		
	}

}
