package com.client2.java;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.*;

public class Client2 {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket(InetAddress.getLocalHost(),7774);
        System.out.println("Client is connected:");
        boolean t = true;
        while(t){
            Scanner sc = new Scanner(s.getInputStream());
            System.out.print("Client recieved:");
            String str = sc.nextLine();
            System.out.println(str);

            Scanner scan = new Scanner(System.in);
            PrintStream p = new PrintStream(s.getOutputStream());
            System.out.print("Client send:");
            String string = scan.nextLine();
            if(string.equals("Nahid chor"))
                t = false;
            p.println(string);

        }
    }

}
