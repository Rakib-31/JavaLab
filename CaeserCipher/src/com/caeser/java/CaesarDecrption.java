package com.caeser.java;

public class CaesarDecrption {
	
	public String decryptOneKey(String encrypt){
        CaeserEncryption ob = new CaeserEncryption();
        int key = getKey(encrypt);
        System.out.println(key);
        return ob.encryptOneKey(encrypt, 26 - key);
    }
	
	public String decryptTwoKeys(String encrypt){
        CaeserEncryption ob = new CaeserEncryption();

        String odd = ob.halfOfString(encrypt, 0);
        String even = ob.halfOfString(encrypt, 1);

        int key1 = getKey(odd);
        int key2 = getKey(even);

        System.out.println(key1 + " " + key2);

        return ob.encryptTwoKeys(encrypt, 26 - key1, 26 - key2);
    }

    public int getKey(String encript){
        int[] count = numberOfLetter(encript);
        int max = maxIndex(count);
        int key = max - 4;

        if(key < 0)
            key += 26;
        return key;
    }


    public int[] numberOfLetter(String s){
        int[] number = new int[26];
        s = s.toLowerCase();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                number[ch - 'a']++;
            }
        }

        return number;
    }
    
    public int maxIndex(int[] number){
        int max = -1, index = -1;
        for(int i=0; i<number.length; i++){
            if(number[i] > max){
                max = number[i];
                index = i;
            }
        }

        return index;
    }
    
    private void testDecrypt(){
        String result;
        
        result = decryptOneKey("Grpq x qbpq pqofkd tfqe ilqp lc bbbbbbbbbbbbbbbbbp");
        System.out.println(result);
        
        result = decryptOneKey("Aljk r kvjk jkizex nzky cfkj fw vvvvvvvvvvvvvvvvvj");
        System.out.println(result);
        
        result = decryptTwoKeys("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu");
        System.out.println(result);
    }

    public static void main(String args[]){
        CaesarDecrption obj = new CaesarDecrption();
        obj.testDecrypt();
    }
}
