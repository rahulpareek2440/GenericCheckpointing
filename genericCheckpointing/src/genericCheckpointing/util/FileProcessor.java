/**
* Code for file operations is here.
* Fileprocessor constructor is getting the input file name from main Driver class. 
* Using scanner class for fetching instructions from file line by line. Here readlinefromfile method is taking each String line and returning it line-by-line.
*  
*/
package genericCheckpointing.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileProcessor{
	String line = null;
	Scanner sc = null;
	BufferedWriter bw=null;
	public FileProcessor(File input,File output,String mode) {
		
		try{
			if(mode.equals("serdeser")){
				bw=new BufferedWriter(new FileWriter(output, false));
				sc=new Scanner(input);
			}else if(mode.equals("deser")){
				sc=new Scanner(input);
			}
			
		 
		}catch(Exception e){
			System.err.println("End of File !!! \n I/O Exception");
		}
	}
	
	public String readLineFromFile(){
		if(sc.hasNextLine()){
			return (sc.nextLine().trim());
		}else{
			return null;
		}
		
	}
	
	public void writeToFile(String msg) throws IOException{
		bw.write(msg);
		bw.flush();
	}
	
	
}
	
