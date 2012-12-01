package com.dbrown.dev.hw;


public class Node{
	private static final int MAX = 50;
	int current;
	Connect[] connections;
	
	public Node(){
		
	}
	
	public Node(String name){
		current = 0;
		connections = new Connect[MAX];
		
		
	}
	
	
	public void makeConnection(Node n, String s){
		Connect c = new Connect(n, s);
		connections[current]=c;
		current++;
	}
	
	public void makeNewConnection(String n, Node ne, String s){
		Connect c = new Connect(n,ne,s);
		connections[current]=c;
		current++;
	}
	
	public void printNetwork(){
		System.out.println("PRINTING NETWORK ****DEBUG****");
		for(int i = 0; i<current; i++){
			
			System.out.println(connections[i].type);
			
			
		}
	}

}
