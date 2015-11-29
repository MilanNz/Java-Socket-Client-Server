/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eclasocket;

/**
 *
 * @author Milan
 */
public interface Transfer {
    Transfer setPort(int port);
    Transfer setAddress(String address);
    void startServer();
    void startClient();
    void closeConnection();
    void sendMessage(String message);
    void addListener(EclaSocketListener listener);
}
