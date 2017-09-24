import java.io.*;
import java.lang.*;
import edu.duke.*;

public class Part1{
    
    String findSimpleGene(String DNA){
        
        int start = DNA.indexOf("ATG");
        int end = DNA.indexOf("TAA", start + 3);
        if(start != -1)
            System.out.println("Start Codon: " + start);
        else
            System.out.println("Start Codon: Empty");
        if(end != -1)
            System.out.println("Stop Codon: " + end);
        else
            System.out.println("Stop Codon: Empty");
        while(start != -1 && end != -1)
        {
            if((end - start)%3 != 0)
                end = DNA.indexOf("TAA", end + 3);
            if(end == -1){
                start = DNA.indexOf("ATG",start + 3);
                end = DNA.indexOf("TAA", start + 3);
            }
            else if((end - start)%3 == 0)
                return DNA.substring(start, end + 3);
        }
        if(end == -1 || start == -1)
            return "";
        return DNA.substring(start, end + 3);
    }
}
