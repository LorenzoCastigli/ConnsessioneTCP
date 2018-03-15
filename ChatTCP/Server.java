/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lorenzo Castigli
 */
public class Server extends Chatter{
    
    private ServerSocket connection;
    private int port;
    
    public Server(ServerSocket connection, int port){
        
        this.connection=connection;
        this.port=port;
    }
    
    public void avvia(){
        
        // porta del server maggiore di 1024 
        port=2000;
        //oggetto ServerSocket necessario per accettare richieste dal client
        connection = null;
        
        try{
            
            // il server si mette in ascolto sulla porta voluta
            connection = new ServerSocket(port);
            System.out.println("In attesa di connessioni!");
            //si è stabilita la connessione
            dataSocket = connection.accept();
   
            System.out.println("Connessione stabilita!");                
        }
        
        catch(IOException e){

            System.err.println("Errore di I/O!");
        }
        
        ricevi();
    }
}
