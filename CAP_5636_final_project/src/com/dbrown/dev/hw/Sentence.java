package com.dbrown.dev.hw;

public class Sentence {
	//sNumber is sentence number in the file
	//sID is the sentences unique identifier
	int sNumber, sID;
	boolean compount;
	String sent;
	public Sentence(String sent){
		
		//System.out.println("Woo");
		sID = getID(sent);
		System.out.println("G"+sID);
		//run();
		//parse();
	}
	
	public void run(){
		
		
	}
	
	public void parse(){
		
		
		
	}
	
	
	public int getID(String check){
		int id = 0;
		int len;
		System.out.println(check);
		if(check.charAt(1)=='G'){
			System.out.println(check);
			len = check.length();
			len--;
			id = Integer.parseInt(check.substring(2,len));
		}
		return id;
	}
	
		
	public int getParenth(String line, int begin){
		int p=0;
		line.indexOf("(");
		
		return p;
	}

}
