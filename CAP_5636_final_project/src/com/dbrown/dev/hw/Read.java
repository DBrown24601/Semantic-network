package com.dbrown.dev.hw;

import java.io.*;

//remove line 56 DEBUG-END
public class Read {
	
	public Read(){
		run();
	}
	
	public void cleanArray(String[] b){
		System.out.println("WOO");
		for(int i=0; i<50; i++){
			b[i]="";
		}
		if(b[0].isEmpty()){
			System.out.println("WOO");
			
		}
	}
	
	public void run(){
		try{
			// Open the file that is the first 
			// command line parameter
			//FileInputStream fstream = new FileInputStream("C:\\Users\\Dan\\Documents\\Class\\Advanced Artificial Intelligence\\Final Project\\famine.int");
			FileInputStream fstream = new FileInputStream("C:\\Users\\Dan\\Documents\\Class\\Fall 2012\\Advanced Artificial Intelligence\\famine.int");
			int sentences=0;
			int line = 0;
			String[] buff;

	        // allocates memory for 50 integers as a read buffer to pass entire chunks of text to the object
			buff = new String[50];
			for(int x=0; x<50; x++){
				buff[x]="";
			}
			if(buff[49].isEmpty()){
				System.out.println("WOdO");
				
			}
			
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine, sentence;
			
			//Read File Line By Line
			  
			while ((strLine = br.readLine()) != null)   {
				// Print the content on the console
				
				
				//remove all spaces
				if(!strLine.isEmpty()){
					//System.out.println (strLine);
					if(strLine.contains("NEXT-SENTENCE")){
						Sentence s = new Sentence(strLine);
						sentences++;
						br.readLine();
						sentence = br.readLine();
						System.out.println("Sentence: "+sentence);
						br.readLine();
						sentence = br.readLine();
						//System.out.println("To be parsed: "+sentence);
						//int yay = getParenth(strLine, 0);
						
					}
					
					
					
					
					if(strLine.contains("INTERPRETATION STARTS")){
						System.out.println("Number of sentences in this file: "+sentences);
						//parse();
						return;
						
					}
					if(strLine.contains("DEBUG-END")){
						System.out.println("Number of sentences in this file: "+sentences);
						return;
					}
					
					
				}
			}
			
			System.out.println("Number of sentences in this file: "+sentences);
			//Close the input stream
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
	}
	
	
	public static void main(String args[])
	  {
		Read read = new Read();
	  }
}
