/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionCastigliTCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Server {
    
    //oggetto da usare per realizzare la connessione TCP
    Socket connection;

    public Server(Socket connection){

        this.connection=connection;
    }

    public void ricevi(){

        try {
            Scanner in = new Scanner(connection.getInputStream());
            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
            String fromClient = null;
            
            if ((fromClient = in.nextLine()) != null) {
                
                System.out.println(fromClient);
                
                if(fromClient.equals("orario")){
                    
                    out.println(tempo());
                }
                else {
                    
                    out.println("Funzione non supportata al momento!");
                }
            }
        } catch (IOException ex) {
            
            System.err.println();
        }
    }
    
    public String tempo(){
        
        DateFormat dateFormat = new SimpleDateFormat(" HH:mm:ss - dd/MM/yyyy");
        Date date = new Date();
        return (dateFormat.format(date));
    }
}
