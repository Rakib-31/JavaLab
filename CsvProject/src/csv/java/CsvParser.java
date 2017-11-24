package csv.java;

import edu.duke.*;

import java.util.Scanner;

import org.apache.commons.csv.*;

public class CsvParser {
	
	private static Scanner scan;

	public static String info(CSVParser parser, String country){
		for(CSVRecord r : parser){
			String info = r.get("Country");
			if(info.contains(country)){
				info = info + ": " + r.get("Exports");
				return info;
			}
		}
		
		return "NOT FOUND";
	}
	
	public static void tester(){
		FileResource file = new FileResource();
		CSVParser parser = file.getCSVParser();
		String country;
		scan = new Scanner(System.in);
		country = scan.nextLine();
		
		String info = info(parser, country);
		
		System.out.println(info);
		
		return;
	}
	
	public static void main(String args[]){
		tester();
	}

}
