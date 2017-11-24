package com.java.code;
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

void testSimpleGene(){
    //DNA with no ATG and TAA
    
    String DNA = "ATACGATATTATACCCGAGAT";
    System.out.println("DNA String: " + DNA);
    String gene = findSimpleGene(DNA);
    System.out.println("Gene: " + gene);
    
    //DNA with ATG but no TAA
    
    DNA = "ATGACGATATTATACCCGAGAT";
    System.out.println("DNA String: " + DNA);
    gene = findSimpleGene(DNA);
    System.out.println("Gene: " + gene);
    
    //DNA with TAA but no ATG
    
    DNA = "ATCGGATATCATAACCCGAGAT";
    System.out.println("DNA String: " + DNA);
    gene = findSimpleGene(DNA);
    System.out.println("Gene: " + gene);
    
    //DNA with ATG and TAA
    
    DNA = "ATGACGATATAATATAACTGCGAGAT";
    System.out.println("DNA String: " + DNA);
    gene = findSimpleGene(DNA);
    System.out.println("Gene: " + gene);
    
    //substring between ATG and TAA is a multiple of 3
    
    DNA = "ATGACGATAGTAATATAACCCGAGAT";
    System.out.println("DNA String: " + DNA);
    gene = findSimpleGene(DNA);
    System.out.println("Gene: " + gene);
    
    //substring between ATG and TAA is a multiple of 3
    
    DNA = "ACGACATGBGAGTAAATGATAACCTAAGAT";
    System.out.println("DNA String: " + DNA);
    gene = findSimpleGene(DNA);
    System.out.println("Gene: " + gene);
}
//////////////////
	public static void main(String[] args)
	{
		Part1 ob = new Part1();
		ob.testSimpleGene();
	}
}


