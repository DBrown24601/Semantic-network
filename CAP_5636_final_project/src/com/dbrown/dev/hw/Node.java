package com.dbrown.dev.hw;

import java.util.ArrayList;


public class Node{
	int current;
	ArrayList<Connect> connections=new ArrayList<Connect>();
	String name;
	public Node(){
		
	}
	
	public Node(String n){
		current = 0;
		name = n;
		//REPLACE WITH ARRAY LIST
		//connections = new Connect[MAX];
		
		
	}
	
	
	public void makeConnection(Node n, String s){
		Connect c = new Connect(n, s);
		connections.add(c);
		current++;
	}
	
	public void makeNewConnection(String n, Node ne, String s){
		Connect c = new Connect(n,ne,s);
		connections.add(c);
		current++;
	}
	
	public void printConnections(){
		System.out.println("PRINTING NETWORK ****DEBUG****");
		for(int i = 0; i<current; i++){
			
			System.out.println(name +" "+ connections.get(i).type +" "+ connections.get(i).result.name);
			
			
		}
	}

}
