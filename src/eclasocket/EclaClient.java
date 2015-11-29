/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eclasocket;

import java.util.Scanner;

/**
 *
 * @author Milan
 */
public class EclaClient {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Transfer client = new SocketTransfer();
        client.setPort(8888).setAddress("localhost").startClient();
        client.addListener(new EclaSocketListener() {

            @Override
            public void onRecive(String response) {
                System.out.println(response);
            }
        });
        client.sendMessage("Hello to server");
        
    }
            
    
}
