package com.dbrown.dev.hw;

public class Sentence {
	//sNumber is sentence number in the file
	//sID is the sentences unique identifier
	
	int sNumber, sID, x, numOfLines;
	
	boolean compount;
	String sent;
	public Sentence(String[] sent, int ln){
		sID = 0;
		x = 0;
		//System.out.println("Woo");
		numOfLines=ln;
		while(sID==0&&x<49){
			sID = getID(sent[x]);
			x++;
			//System.out.println("Woo" + x);
			
		}
		//sID = getID(sent);
		//System.out.println("Test");
		System.out.println("Sentence ID is G"+sID);
		//run();
		//readStrings(sent);
	}
	
	public void run(){
		
		
	}
	
	
	
	public int getID(String check){
		int id = 0;
		int len;
		//System.out.println(check.charAt(1));
		if(check.charAt(1)=='G'){
			//System.out.println(check);
			len = check.length();
			//len;
			id = Integer.parseInt(check.substring(2,len));
		}
		return id;
	}
	
	public void readStrings(String[] read){
		for(int i = 0; i < read.length; i++){
			if(read[1]!=""){
				//System.out.println(read[i]);
			}
		}
		
		
	}
	
		
	public int getParenth(String line, int begin){
		int p=0;
		p = line.indexOf("(");
		
		return p;
	}

}
