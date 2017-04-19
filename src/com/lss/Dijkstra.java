package com.lss;

import java.awt.peer.SystemTrayPeer;

public class Dijkstra {
   private static int IMAX = 10000;
   private static int[][] adjMat={  //存放相邻顶点权值
	   {0,10,3,IMAX},
	   {IMAX,0,4,5},
	   {IMAX,4,0,10},
	   {IMAX,IMAX,IMAX,0}
   };
   
    public static void main(String[] args) {
		Dijkstra dijkstra =new Dijkstra();
		int start = 2;
		int end = 3;
		System.out.print("adjMat长度为"+adjMat.length);
		System.out.println("\n从"+start + "到" + end + "的距离是："+dijkstra.resolve(adjMat, start, end));
		
	}
    /*
     *  在用邻接矩阵表示的图中，求解从点s到点t的最短路径
    
     */
    
    public int resolve(int[][] adj, int start,int end){
        if(start < 0 || end <0 || start >adj.length || end >adj.length){
        	System.out.println("错误，顶点不在图中！");
        	return IMAX;
        }
    	
        
        boolean[] isVisited = new boolean[adj.length]; //记录某个顶点是否完成遍历
        int[] d = new int[adj.length]; //用于存储从s到各个点之间的最短路径长度
        
        for (int i = 0; i < adj.length; i++) {
			isVisited[i] = false;  //标记所有顶点都为未访问过
			d[i] = IMAX; //初始化起点到所有顶点的距离为IMAX;
		}
        
        d[start] = 0; //起点到起点的距离初始化为0
        isVisited[start] = true; //标记起点为为以访问过的节点
        int unVisited = adj.length;//初始化尚未访问的节点数目
        int index=start;// 表示权重最小的顶点的索引     默认是起点
        while (unVisited > 0 && index!=end ) {
		    int min = IMAX;
		    for (int i = 0; i < adj.length; i++) {
				if(min > d[i] && !isVisited[i]) { //最小值大于起点到顶点的距离且该定点未被访问过
					min = d[i];
					index = i; 
					
				}
			}
			
		    if(index == end || unVisited == 0){
		    	System.out.print(index);  //打印最短路径的节点
		    }else {
				System.out.print(index+"=>"); //打印最短路径的接节点
			}
		    for (int i = 0; i < adj.length; i++) {
				if(d[index] + adj[index][i]<d[i]){
					d[i] = d[index]+adj[index][i]; //adj[index][i]意思:前一个权重最小的点到顶点i的距离，例如：假设B为权重最小，则A->C的距离可以为A->B->C
					
				}
			}
		    unVisited--;
		    isVisited[index] = true;
		}
		return d[end];
    	
    }

	
}
