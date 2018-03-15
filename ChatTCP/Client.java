/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatTCP;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Client extends Chatter{
    
    private int porta;
    private String indirizzo;
    
    public Client(int porta, String indirizzo){
        
        this.indirizzo=indirizzo;
        this.porta=porta;
    }
    
    public void avvia(){
        
        try {
            dataSocket = new Socket(indirizzo, porta);
            invia();
        } catch (IOException ex) {
            //
        }
        
    }
}
