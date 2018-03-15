/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Lorenzo Castiglih
 */
public class Chatter {
    
    private String autore;
    private Boolean stato;
    private String echo;
    public Socket dataSocket;
    public String str;
    public String msg;
    public String buffer;
    private String name;
    
    public String digita(){
        
        BufferedReader tastiera = new BufferedReader( new InputStreamReader(System.in));
        
        System.out.println("Cosa vuoi inviare ?");
        
        try {
                    
            str=tastiera.readLine();
        }             
        catch (IOException e) {
                    
            e.printStackTrace();       
        }
        
        return str;
    }
    
    public void invia(){
       
        System.out.println("Connessione aperta");
        
        String richiesta = digita();
        
        PrintWriter out = null;
        
        try {
            
            out = new PrintWriter(dataSocket.getOutputStream(), true);
        }
        catch (IOException ex) {
            
            System.err.println("Errore di I/O!");
        }
        
        out.println(richiesta);
    }
    
    public void ricevi(){
  
        if(stato == true){
            
            Scanner in = null;

            try {

                in = new Scanner(dataSocket.getInputStream());       
            } 
            catch (IOException ex) {

                System.err.println("Errore di I/O!");
            }

            msg = null; 

            if ((msg = in.nextLine()) != null) {

                System.out.println("Server: " + msg);
            }
        } 
        
        else {
            
            buffer = msg+"\n";
        }
        
        echo = msg;
    }
    
    public void chiudi(){
        
        if (dataSocket != null){
            
            try {
                
                dataSocket.close();
            } 
            
            catch (IOException ex){
                
                System.err.println("IOException error!");
            }
        }
    }
    
    public void setStudente(){
        
        System.out.println("Scrivi il tuo nome");
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        name = "";
        
        boolean cont = false;
        
        do{
            
            try {
                
                name = tastiera.readLine();
            } 
            
            catch (IOException ex) {
                
                System.err.println("IOException error!");
            }
            
            if(!name.contains(":")){
                
                cont = true;
            } 
            
            else {
                
                System.out.println("Il tuo nome non può contenere il simbolo : inserisci un nome corretto");
            }
        }
        
        while(cont!=true);
        
        this.name = name;
        System.out.println("Nome cambiato correttamente");
    }
    
    public void setStato(boolean stato){
        
        if(stato == this.stato){
            
            System.out.println("Sei già in questo stato!");
        } 
        
        else if(stato == true) {
            
            System.out.println("Sei online");
            
            System.out.print(buffer);
            buffer="";
            
            this.stato=stato;
            
        } 
        
        else if(stato == false) {
            
            System.out.println("Sei offline");
            this.stato=stato;
        }
    }
    
    public void gestore(){
        
        
    }
    
}
