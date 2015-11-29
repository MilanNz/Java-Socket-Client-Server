/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eclasocket;

import eclasocket.listener.EclaSocketListener;

/**
 *
 * @author Milan
 */
public interface Transfer {
    /** Set server port. 
     @param port */
    Transfer setPort(int port);
    /** Set server address.
     @port address */
    Transfer setAddress(String address);
    /** Start server. */
    void startServer();
    /** Start client. */
    void startClient();
    /** Close connection. */
    void closeConnection();
    /** Send message. 
     @param message */
    void sendMessage(String message);
    /** add listener
     @param listener */
    void addListener(EclaSocketListener listener);
}
