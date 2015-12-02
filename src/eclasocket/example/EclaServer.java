/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eclasocket.example;

import eclasocket.listener.EclaSocketListener;
import eclasocket.SocketTransfer;
import eclasocket.Transfer;

/**
 *
 * @author Milan
 */
public class EclaServer{
    public static void main(String[] args) {
        Transfer server = new SocketTransfer();
        server.setPort(8888).startServer();
        server.sendMessage("THX for connection!");
        server.addListener(new EclaSocketListener() {

            @Override
            public void onRecive(String response) {
                System.out.println(response);
            }

            @Override
            public void onConnected(boolean connect) {
                System.out.println(String.valueOf(connect));
            }
        });
    }

}
