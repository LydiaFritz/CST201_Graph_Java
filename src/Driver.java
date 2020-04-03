//Lydia's graph code
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		Graph g = new Graph();
		g.printGraph();
		System.out.println("\n\nThe distance between \'Graham\' and \'Navajo\' is " +
				g.getDistance("Graham", "Navajo"));
	}
}

class Graph{
	private String[] counties = {"Mohave", "Coconino", "Navajo",
			"Apache", "Greenlee", "Cochise", "Santa Cruz", "Pima",
			"Pinal", "Graham", "Gila", "Yavapai", "La Paz", "Yuma",
			"Maricopa"};
	
	private int [][] matrix = new int[15][15];
	
	private int getVertex(String s){
		for(int i = 0; i < counties.length; i++){
			if(counties[i].equals(s))
				return i;
		}
		return -1;
	}
	
	public Graph() throws FileNotFoundException{
		//load graph
		Scanner fin = new Scanner(new File("input.in"));
		int dist;
		for(int i = 0; i < 15; i++){
			for(int j = 0; j < 15; j++){
				dist = fin.nextInt();
				if(dist == 0 && i!=j)
					dist = Integer.MAX_VALUE;
				matrix[i][j] = dist;			
			}
		}
		fin.close();
		
	}
	
	//get distance between connected pairs of vertices
	public int getDistance(String countyA, String countyB){
		//find the two vertices
		int county1 = getVertex(countyA);
		int county2 = getVertex(countyB);
		
		int dist = matrix[county1][county2];
		
		return dist;
		
	}
	
	public void printGraph(){
		for(int row = 0; row < 15; row++){
			for(int col = 0; col < 15; col++){
				if(matrix[row][col] == Integer.MAX_VALUE)
					System.out.printf("%5s", "X");
				else
					System.out.printf("%5d", matrix[row][col]);
			}
			System.out.println();
		}
	}
}
