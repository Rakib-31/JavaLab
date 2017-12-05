package com.caeser.java;

import java.util.*;

public class CaeserEncryption {
	 private char[] lower, upper;

	    public CaeserEncryption() {
	        lower = new char[26];
	        upper = new char[26];
	        int i=0;

	        for(char ch = 'a', CH = 'A'; ch<='z'; ch++, CH++){
	            lower[i] = ch;
	            upper[i++] = CH;
	        }
	    }

	    public int indexOf(char ch){
	        if(ch>='A' && ch<='Z')
	            return ch - 'A';
	        else
	            return ch - 'a';
	    }
	    
	    public boolean isUpperCase(char ch){
	        if(ch>='A' && ch<='Z')
	            return true;
	        return false;
	    }

	    public String encryptOneKey(String input, int key){
	        String code = "";

	        for(int i=0; i<input.length(); i++){
	            char ch = input.charAt(i);

	            if(Character.isLetter(ch)){
	                int index = indexOf(ch);
	                index = (index + key) % 26;

	                if(isUpperCase(ch))
	                    code += upper[index];
	                else
	                    code += lower[index];
	            }

	            else
	                code += ch;
	        }

	        return code;
	    }

	    public String halfOfString(String string, int start){
	        String msg = "";

	        for(int i = start; i<string.length(); i+=2)
	            msg += string.charAt(i);

	        return msg;
	    }

	    public String oddEven(String odd, String even){
	        String string = "";

	        for(int i=0; i<odd.length(); i++){
	            if(i<odd.length())
	                string += odd.charAt(i);
	            if(i<even.length())
	                string += even.charAt(i);
	        }

	        return string;
	    }

	    public String encryptTwoKeys(String input, int key1, int key2){
	        String encrypted;

	        String odd = halfOfString(input,0);
	        String even = halfOfString(input, 1);

	        odd = encryptOneKey(odd, key1);
	        even = encryptOneKey(even, key2);

	        encrypted = oddEven(odd, even);

	        return encrypted;
	    }

	    private void testCaeser(){
	        String ans;
	        Scanner sc = new Scanner(System.in);
	        int a,b;
	        
	        System.out.println("Encryption with one key:");
	        System.out.println("Enter the key:");
	        a = sc.nextInt();
	        ans = encryptOneKey("Just a test string with lots of eeeeeeeeeeeeeeeees", a);
	        System.out.println(ans);

	        System.out.println("Encryption with two key:");
	        System.out.println("Enter two keys:");
	        a = sc.nextInt();
	        b = sc.nextInt();
	        ans = encryptTwoKeys("Just a test string with lots of eeeeeeeeeeeeeeeees", a, b);
	        System.out.println(ans);
	    }

	    public static void main(String args[]){
	    	CaeserEncryption obj = new CaeserEncryption();
	        obj.testCaeser();
	    }
}
