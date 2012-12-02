package com.dbrown.dev.hw;

import java.io.*;
import java.util.ArrayList;

//remove line 56 DEBUG-END


public class Read {
	
	ArrayList<Node> sNetwork=new ArrayList<Node>();
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
	
	public void parse(){
		Node famine = new Node("Famine");
		Node test2 = new Node("Death");
		famine.makeConnection(test2, "causes");
		
		famine.printConnections();
		
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
