package com.babyname.java;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class AnalyzingBabyNames {
	
	private String resource = "H:\\CSE2211 Object Oriented Programming and Design Methods\\Week4\\us_babynames_test\\yob";

    public void totalBirths(FileResource file){
    	
        int births = 0,boys = 0,girls = 0;
        
        for(CSVRecord record : file.getCSVParser(false)) {
        	
            int total = Integer.parseInt(record.get(2));
            
            births += total;
            
            String gender = record.get(1);

            if(gender.equals("M"))
                boys += total;

            else if(gender.equals("F"))
                girls += total;
        }

        System.out.println("Total Birth : " + births);
        System.out.println("Number of Boys : " + boys);
        System.out.println("Number of Girls : " + girls);
    }

    public int getRank(int year, String name, String gender){
    	
        FileResource file = new FileResource(resource + Integer.toString(year) + "short.csv");
        
        int pos = 0;

        for(CSVRecord record : file.getCSVParser(false)){

            if(record.get(1).equals(gender)){
            	
                pos++;
                
                if(record.get(0).equals(name))
                    return pos;
            }
        }

        return -1;
    }

    public int getRank(FileResource file, String name, String gender){
    	
        int pos = 0;

        for(CSVRecord record : file.getCSVParser(false)){

            if(record.get(1).equals(gender)){
            	
                pos++;
                
                if(record.get(0).equals(name))
                    return pos;
            }
        }

        return -1;
    }

    public String getName(int year, int pos, String gender){
    	
        FileResource file = new FileResource(resource + Integer.toString(year) + "short.csv");
        
        int serial = 0;

        for(CSVRecord record : file.getCSVParser(false)){
        	
            if(record.get(1).equals(gender)){
            	
                serial++;
                
                if(serial == pos)
                    return record.get(0);
            }
        }

        return "NO NAME";
    }

    public String whatIsNameInYear(String name, int year, int newYear, String gender) {
    	
        return getName(newYear, getRank(year, name, gender), gender);
    }

    public int yearOfHighestRank(String name, String gender){
    	
        DirectoryResource resource = new DirectoryResource();
        
        String year = "";
        int max = 10000000;

        for(File f : resource.selectedFiles()){
        	
            String fileName = f.getName();
            FileResource file = new FileResource(f);
            int pos = 0;

            for(CSVRecord record : file.getCSVParser(false)){
            	
                if(record.get(1).equals(gender)){
                    pos++;

                    if(record.get(0).equals(name))
                        break;
                }
            }

            if(pos < max){
            	
                max = pos;
                year = fileName.substring(3,7);
            }
        }

        return Integer.parseInt(year);
    }

    public double getAverageRank(String name, String gender){
    	
        DirectoryResource resource = new DirectoryResource();
        double total = 0;
        int count = 0;

        for(File f : resource.selectedFiles()){
        	
            FileResource file = new FileResource(f);
            count++;
            int pos = getRank(file, name, gender);
            
            if(pos == -1)
                return -1;
            
            total += pos;
        }

        return total/count;
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender){
    	
        FileResource file = new FileResource(resource + Integer.toString(year) + "short.csv");
        int total = 0;

        for(CSVRecord record : file.getCSVParser(false)){
        	
            if(record.get(1).equals(gender)){
            	
                if(record.get(0).equals(name))
                    break;
                
                total += Integer.parseInt(record.get(2));
            }
        }

        return total;
    }

    public void testYearOfHighestRank(){
        System.out.println(yearOfHighestRank("Mason", "M"));
    }

    public void testGetAverageRank(){
        System.out.println(getAverageRank("Jacob", "M"));
    }

    public void testGetTotalBirthsRankedHigher(){
        System.out.println(getTotalBirthsRankedHigher(2012, "Ethan", "M"));
    }

    public void tester(){
    	
        System.out.println(getRank(2012, "Mason", "M"));
        System.out.println(getName(2012, 3, "F"));
        System.out.print("Isabella born in 2012 would be ");
        System.out.println(whatIsNameInYear("Isabella", 2012, 2014, "F") + " if she was born in 2014");
    }

    public static void main(String args[]){
    	
        AnalyzingBabyNames obj = new AnalyzingBabyNames();
        obj.tester();
        obj.testYearOfHighestRank();
        obj.testGetAverageRank();
        obj.testGetTotalBirthsRankedHigher();
        
    }

}
