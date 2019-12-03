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
		RMQueue testQueue= new RMQueue();
		Random rand= new Random();
		
		/*int[] sorted= {0,1,2,3,4,5,6,7,8,9};
	
		testQueue.STAlgorithm(sorted, sorted.length);
		
		System.out.println(testQueue.query(0, 4));
		System.out.println(testQueue.query(4, 7));
		System.out.println(testQueue.query(7,9));
		*/
		/*int[] random= new int[1000];
		for(int i=0;i<random.length;i++) {
			random[i]=rand.nextInt(1000000);
		}
		
		testQueue.STAlgorithm(random, random.length);
		System.out.println(testQueue.query(0, 10));
		System.out.println(testQueue.query(25, 50));
		System.out.println(testQueue.query(75, 100));*/
		
		int[] testArray= {1,2,3,4,5,6,7,8};
		
		testQueue.STAlgorithm(testArray, testArray.length);
		testQueue.addEdge(1, 2);
		testQueue.addEdge(1, 3);
		testQueue.addEdge(2, 4);
		testQueue.addEdge(2, 5);
		testQueue.addEdge(2, 6);
		testQueue.addEdge(3, 7);
		testQueue.addEdge(3, 8);
		
		testQueue.dfs(1, 0);
		
		System.out.println("The LCA for the points 4,3 are: "+testQueue.lca(4, 3));
		System.out.println("The LCA for the points 4,6 are: "+testQueue.lca(4, 6));
	}

}
