package com.server2.java;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server2 {

    public static void main(String[] args) throws UnknownHostException,IOException {
        ServerSocket ss = new ServerSocket(7774);
        System.out.println("Server Started");
        Socket s = ss.accept();
        System.out.println("Server is connected:");
        boolean t = true;
        while(t){
            Scanner scan = new Scanner(System.in);
            System.out.print("Server send: ");
            PrintStream p = new PrintStream(s.getOutputStream());
            String string = scan.nextLine();
            p.println(string);

            System.out.print("Server recieved: ");
            Scanner sc = new Scanner(s.getInputStream());
            String str = sc.nextLine();
            System.out.println(str);
            if(str.equals("Nahid chor"))
                t = false;
        }
    }
}
