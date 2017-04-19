package com.lss;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Distance {
	private static int[][] distace;
	private static int cityNumber;
	public static void main(String[] args) throws Exception {
		initDistance();
	}
	

	public static int[][] initDistance() throws Exception {
		int[] x;
		int[] y;
		String strbuff;
		String path="E:\\JuMei\\MyStudy\\data.txt";
		String dir = System.getProperty("user.dir");
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(path)));
		distace =  new int[cityNumber][cityNumber];
		 x = new int[cityNumber];
		 y = new int[cityNumber];
		 for (int i = 0; i < cityNumber; i++) {
			strbuff = bufferedReader.readLine();
			String[] str= strbuff.split(" ");
			x[i] = Integer.parseInt(str[1]);
			y[i] = Integer.parseInt(str[2]);
		}
		 
		 for (int i = 0; i < cityNumber-1; i++) {
			distace[i][i] = 0;
			for (int j = i+1; j < cityNumber; j++) {
				 double rij = Math  
	                        .sqrt(((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j])  
	                                * (y[i] - y[j])) / 10.0);  
	                // 四舍五入，取整  
	                int tij = (int) Math.round(rij);  
	                if (tij < rij) {  
	                	distace[i][j] = tij + 1;  
	                	distace[j][i] = distace[i][j];  
	                } else {  
	                	distace[i][j] = tij;  
	                	distace[j][i] = distace[i][j];  
	                }  
			}
		}
		 distace[cityNumber-1][cityNumber-1] = 0;
		return distace;

	}
}
