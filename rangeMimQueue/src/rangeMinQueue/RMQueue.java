package rangeMinQueue;

import java.math.*;
/*
 *@author nardi 
 */

public class RMQueue {
	private int[][] sparse;
	private int size;
	
	public RMQueue(int n){
		//constructor for the RMQueue
		size=n;
		sparse=new int[500][500];
		
	}
	
	public void STAlgorithm(int originArray[], int completeSize) {
		//does the preprocessing for the RMQ Algorithm using Sparse Tables
		
		//initialize the positions for the intervals with length 1
		for(int i=0;i<completeSize;i++) {
			sparse[i][0]=originArray[i];
		}
		//compute values from smaller to larger intervals
		for(int j=1; (1<<j)<=completeSize;j++) {
			for(int k=0;(k+(1<<j)-1)<completeSize;k++) {
				if(sparse[k][j-1]<sparse[(k+(1<<(j-1)))][j-1]) {
					sparse[k][j]=sparse[k][j-1];
				}
				else {
					sparse[k][j]=sparse[(k+(1<<(j-1)))][j-1];
				}
			}
		}
	}
	
	public double log2(int x) {
		//calculates the log of a number for base2
		return (Math.log(x))/Math.log(2);
	}
	
	public int query(int left, int right) {
		//returns minimum of arry[Left...right]
		int twoPower=(int)log2(right-left+1);
		//calculate the highest power of 2 that is smaller than or equal to the count of elements in a given range
		if(sparse[left][twoPower]<=sparse[right-(1<<twoPower)+1][twoPower]) {
			return sparse[left][twoPower];
		}
		else {
			return sparse[right-(1<<twoPower)+1][twoPower];
		}
	}
}
