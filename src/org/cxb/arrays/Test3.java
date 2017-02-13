package org.cxb.arrays;

import java.util.Locale;

public class Test3 {
	public static double[][] getDoubArray(int x , int y , double minValue , double maxValue){
		double[][] result = new double[x][y];
		double add = (maxValue - minValue) / (x * y);
		double var = minValue;
		for (int i = 0 ; i <  x ; i++)
			for (int j = 0 ; j < y ; j++){
				result[i][j] = var;
				var += add;
			}
		return result;
	}
	
	public static double[][][] get3DDoubleArray(int x , int y , int z , double minValue , double maxValue){
		double[][][] result = new double[x][y][z];
		double add = (maxValue - minValue) / (x * y * z);
		double var = minValue;
		for (int i = 0 ; i < result.length ; i++)
			for (int j = 0 ; j < result[i].length ; j++)
				for (int k = 0 ; k < result[i][j].length ; k++){
					result[i][j][k] = var;
					var += add;
				}
		return result;
	}
	
	public static void printArrays(double[][] array){
		for (int i = 0 ; i < array.length ; i++){
			for (int j = 0 ; j < array[i].length ; j++)
				System.out.printf(Locale.US , "%.2f  " , array[i][j]);
			System.out.println("");
		}
	}
	
	public static void print3DArrays(double[][][] array){
		for (int i = 0 ; i < array.length ; i++){
			for (int j = 0 ; j < array[i].length ; j++){
				for (int k = 0 ; k < array[i][j].length ; k++)
					System.out.printf(Locale.US, "%.2f  ", array[i][j][k]);
				System.out.println("");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
//		printArrays(getDoubArray(5 , 6 , 24 , 66));
		print3DArrays(get3DDoubleArray(3, 4, 5, 10, 99));
	}
}
