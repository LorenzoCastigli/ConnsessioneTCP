/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionCastigliTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Client {
    
    String str;
    //oggetto da usare per realizzare la connessione TCP
    Socket connection = null;
    
    public Client(Socket connection){
        
        this.connection=connection;
    }
    
    public String digita(){
        
        BufferedReader tastiera = new BufferedReader( new InputStreamReader(System.in));
        
        System.out.println("Cosa vuoi inviare al server ?");
        
        try {
                    
            str=tastiera.readLine();
        }             
        catch (IOException e) {
                    
            e.printStackTrace();       
        }
        
        return str;
    }
    
    public void invia(String str){
        
        PrintWriter out = null;
        
        try {
            
            out = new PrintWriter(connection.getOutputStream(), true);
        }
        catch (IOException ex) {
            
            System.err.println("Errore di I/O!");
        }
        
        out.println(str);
    }
    
    
    public void ricevi(){
        
        Scanner in = null;
        
        try {
            
            in = new Scanner(connection.getInputStream());
        } 
        catch (IOException ex) {
            
            System.err.println("Errore di I/O!");
        }
        
        String fromServer = null;
        
        if ((fromServer = in.nextLine()) != null) {
            
            System.out.println("Server: " + fromServer);
        }
    }
    
    public void chiudi(){
        
        if (connection!=null) {
            
            try {
                
                connection.close();
                System.out.println("Connessione chiusa!");     
            } 
            catch (IOException ex) {
                
                System.err.println("Errore nella chiusura della connessione!");
            }
        }
    }
}
