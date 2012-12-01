package com.dbrown.dev.hw;

public class Connect extends Node{
	Node result;
	String type;
	public Connect(Node r, String t){
		//type defines the way the object connects
		//the word you're looking for is 'causes'
		//IE Node is a Node
		//for debug purposes the default is "implies"
		type = "implies";
		result = r;
		
	}
	public Connect(String start, Node r, String t){
		//type defines the way the object connects
		//the word you're looking for is 'causes'
		//IE Node is a Node
		//for debug purposes the default is "implies"
		super(start);
		type = "implies";
		result = r;
		
	}
	

}
