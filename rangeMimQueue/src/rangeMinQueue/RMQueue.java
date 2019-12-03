package rangeMinQueue;

import java.math.*;
import java.util.*;
/*
 *@author nardi 
 */


public class RMQueue {
	private int[][] sparse;
	private LinkedList<Integer> tree[];
	private int[] depth;
	private int currentDepth;
	
	public RMQueue(){
		//constructor for the RMQueue
		sparse=new int[1000][1000];
		depth=new int[1001];
		tree= new LinkedList[1001];
		for(int i=0;i<1000;++i) {
			tree[i] = new LinkedList<Integer>();
		}
		currentDepth=18;
	}
	
	public void STAlgorithm(int originArray[], int completeSize) {
		//does the preprocessing for the RMQ Algorithm using Sparse Tables
		
		//initialize the positions for the intervals with length 1
		for(int i=0;i<completeSize;i++) {
			sparse[i][0]=originArray[i];
			System.out.println(originArray[i]);
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
	
	public void dfs(int cur, int prev) {
		//implements a depth first search to calculate the depths of each node.
		depth[cur]=depth[prev]+1;
		sparse[cur][0]=prev;
		for(int i=0;i<tree[cur].size();i++) {
			if(tree[cur].get(i)!=prev) {
				dfs(tree[cur].get(i),cur);
			}
		}
	}
	
	public void addEdge(int u, int v) {
		//adding a new edge to the tree. 
		tree[u].add(v);
	}
	
	public int lca(int value1, int value2) {
		//Returns the LCA of two value
		if(depth[value2]<depth[value1]) {
			int temp=value1;
			value1=value2;
			value2=temp;
		}
		int diff= depth[value2]-depth[value1];
		while(diff>0) {
				int raise_by = (int)log2(diff);
				value1=sparse[value1][raise_by];
				diff-=(1<<raise_by);
		}
		if(value1==value2) {
			return value1;
		}
		for(int i=currentDepth;i>=0;--i) {
			if((sparse[value1][i] != sparse[value2][i])&& (sparse[value1][i]!=-1)) {
				value1=sparse[value1][i];
				value2=sparse[value2][i];
			}
		}
		return sparse[value1][0];
	}
	
	
}
