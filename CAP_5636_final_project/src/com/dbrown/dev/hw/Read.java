package com.dbrown.dev.hw;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//remove line 56 DEBUG-END


public class Read {
	HashMap<String, Node> sNetwork = new HashMap<String, Node>();
	ArrayList<Node> seNetwork=new ArrayList<Node>();
	public Read(){
		run();
	}
	
	public void cleanArray(String[] b){
		//System.out.println("WOO");
		for(int i=0; i<50; i++){
			b[i]="";
		}
	}
	public void readArray(String[] b){
		for(int i=0; i<50; i++){
			System.out.println(b[i]);
		}
	}
	
	public void inquire(){
		Scanner sc = new Scanner(System.in);
	    String i;
	    String[] j;
	    Node handler;
	    boolean end = false;
		System.out.println("What would you like to know?");
		int brk; //handles lack of information errors
		
		do{
			brk=0;
			System.out.printf(":> ");
			i=sc.nextLine();
			i = i.toLowerCase();
			j = i.split(" ");
			for(int x = 0; x<j.length; x++){
				if(sNetwork.containsKey(j[x])){
					//j[x] = famine
					//System.out.println(j[x]);
					handler = sNetwork.get(j[x]);
					if(handler.connectsOut.size()!=0){
						for(int y = 0; y<j.length; y++){
							//System.out.println(j[x]);
							System.out.println(y);
							//ATTEMPTING TO REREAD ALL WORDS IN SENTENCE TO FIND 
							
							if(handler.connectsOut.get(y).type.contains(j[x])){
								System.out.println("CHECK");
							}
							
								
								
							
						}
						brk = 1;
					} else {
						brk = 1;
						//System.out.println("Unknown, more information is needed");
					}
					
					//****************TO DO: MAKE LOOP STOP WHEN BRK IS REACHED*************** LOW PRIORITY
				}else{
					brk = 2;
					//System.out.println("No information is present");
				}
				// 0  All clear
				// 1  if node is found but no connections are present "Unknown, more information is needed"
				// 2  If no node is found, "No information on that topic is present"
				
			}
			
			if(i.equals("nothing")||i.equals("quit")){
				end=true;
			} else {
				if(brk==1){
					System.out.println("Unknown, more information is needed.");
					
				}else if(brk==2){
					System.out.println("No information on that topic is present.");
					
				}
			}
			
			
			
			
		} while(end == false);
		
		
	}
	
	public Node queryNetwork(String q){
		
		
		Node t = new Node(q);
		
		
		
		return t;
	}
	
	public void parse(){
		String n = "famine";
		String n2 = "dEath";
		n2 = n2.toLowerCase();
		Node temp;
		
		Node f = new Node("famine");
		Node d = new Node("death");
		Node q = new Node("quail");
		sNetwork.put(n, f);
		sNetwork.put(n2, d);
		sNetwork.put("quail", q);
		
		Node bad = new Node("bad");
		//boolean sentenceEnd = false;
		sNetwork.put("bad", bad);
		//while(!sentenceEnd){
			
			
			
		//}
		String nTest = "death";
		if(sNetwork.containsKey(nTest)){
			temp = sNetwork.get(nTest);
			temp.makeConnectOut(bad, "is");
		} else {
			temp = new Node("death");
			temp.makeConnectOut(bad, "is");
		}
		//temp.makeConnection(bad, "is");
		temp.printConnections();
		
		
		
		f.makeConnectOut(d, "causes");
		temp = sNetwork.get(n);
		
		f.makeConnectOut(bad, "is");
		
		
		
		
		
		
		
		
		temp.printConnections();
		System.out.println("enable data retrieval for WHAT IS BAD?");
	}
	
	
	public void run(){
		try{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream("C:\\Users\\Dan\\Documents\\Class\\Advanced Artificial Intelligence\\Final Project\\famine.int");
			//FileInputStream fstream = new FileInputStream("C:\\Users\\Dan\\Documents\\Class\\Fall 2012\\Advanced Artificial Intelligence\\famine.int");
			int sentences=0;
			int line = 0;
			boolean debug_LEAVE = false;
			String[] buff;

	        // allocates memory for 50 integers as a read buffer to pass entire chunks of text to the object
			buff = new String[50];
			for(int x=0; x<50; x++){
				buff[x]="";
			}
			
			
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine, sentence;
			strLine = br.readLine();
			
			//Read File Line By Line
			while (strLine!= null&&debug_LEAVE==false)   {
				// Print the content on the console
				
				
				//remove all spaces
				if(!strLine.isEmpty()){
					//System.out.println (strLine);
					if(strLine.contains("NEXT-SENTENCE")){
						line=0;
						
						sentences++;
						//sentence = br.readLine();
						//System.out.println("Sentence: "+sentence);
						sentence = br.readLine();
						
						while(!sentence.contains("INTERPRETATION STARTS")){
							if(!sentence.isEmpty()){
								buff[line]=sentence;
								line++;
								//System.out.println(line);
							} //errors? wtf
							sentence = br.readLine();
							
							
						}
						//readArray(buff);
						Sentence s = new Sentence(buff,line);
						
						
					}
					
					
					
					
					if(strLine.contains("INTERPRETATION STARTS")){
						//System.out.println("Number of sentences in this file: "+sentences);
						//parse();
						
						
					}
					//FOR REMOVAL***************************************************************************
					if(strLine.contains("DEBUG-END")){
						//System.out.println("Number of sentences in this file: "+sentences);
						debug_LEAVE = true;
					}
					//System.out.println("TEST");
					
				}
				strLine = br.readLine();
			}
			
			System.out.println("Number of sentences in this file: "+sentences);
			
			System.out.println("Generating network...");
			
			
			
			parse();
			System.out.println("Done!");
			
			inquire();
			System.out.println("Goodbye!");
			//Close the input stream
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e);
		}
		
	}
	
	
	public static void main(String args[])
	  {
		Read read = new Read();
	  }
}
