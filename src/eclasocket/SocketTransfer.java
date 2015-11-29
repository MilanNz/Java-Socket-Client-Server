/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eclasocket;

import eclasocket.listener.EclaSocketListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milan
 * @version 1.0
 */
public class SocketTransfer implements Transfer, Runnable{
    private static final String TAG = "Transfer ";
    private int mPort;
    private String mAddress;
    private Socket mSocket;
    private ServerSocket mServerSocket;
    private DataOutputStream mDataOutputStream;
    private DataInputStream mDataInputStream;
    private Thread mThread;
    private EclaSocketListener mListener;
    
    
    
    @Override
    public Transfer setPort(int port) {
        this.mPort = port;
        return this;
    }

    
    @Override
    public Transfer setAddress(String address) {
        this.mAddress = address;
        return this;
    }

    
    @Override
    public void startServer() {
        try {
            // create server 
            mServerSocket = new ServerSocket(mPort);
            
            // waiting for client
            System.out.println("Waiting for client on port " +
            mServerSocket.getLocalPort() + "...");
            
            // create client
            mSocket = mServerSocket.accept();
            
             // create client for out and in
            mDataOutputStream = new DataOutputStream(mSocket.getOutputStream());
            mDataInputStream = new DataInputStream(mSocket.getInputStream());
           
            // start new thread for message listening...
            mThread = new Thread(this, "my thread");
            mThread.start();
                    
        } catch(IOException e) {
            System.out.println(TAG + e.getMessage());
        }
    }

    
    @Override
    public void startClient() {
       try {
            // create client
            System.out.println("Connectiong to port: " + mPort + ", address: " 
                    + mAddress);
            
            // connect to server
            mSocket = new Socket(mAddress, mPort);
            
            // is connected?
            if(mSocket.isConnected()) {
                System.out.println("Client connected: " 
                        + mSocket.getRemoteSocketAddress());
            }
                 
             // create client for dataout and datain
            mDataOutputStream = new DataOutputStream(mSocket.getOutputStream());
            mDataInputStream = new DataInputStream(mSocket.getInputStream());
            
            // start new thread for message listening...
            mThread = new Thread(this, "my thread");
            mThread.start();
        } catch(IOException e) {
            System.out.println(TAG + e.getMessage());
        }
    }

    
    @Override
    public void closeConnection() {
        try {
            mSocket.close();
            mServerSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketTransfer.class.getName()).log(Level.SEVERE
                    , null, ex);
        }
    }

    
    @Override
    public void sendMessage(String message) {
        try {
            // encode to base64 and send it
            mDataOutputStream.writeUTF(base64encode(message));
            mDataOutputStream.flush();
        } catch (IOException | NullPointerException ex) {
            System.out.println(TAG + ex.getMessage());
        }
    }

    
    @Override
    public void run() {
        try {
            // reciver
            while(mSocket.isConnected()){
                //System.out.println("Message: " + base64decode(mDataInputStream.readUTF()));
                if(mListener != null) {
                    mListener.onRecive(base64decode(mDataInputStream.readUTF()));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketTransfer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    /** Encode message with Base64.
     @param message */
    private String base64encode(String message){
        try {
            return Base64.getEncoder().encodeToString(message.getBytes("utf-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SocketTransfer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    /** Decode message using Base64.
     @param message */
    private String base64decode(String message){
        try {
            byte[] base64decodedBytes = Base64.getDecoder().decode(message);
            return new String(base64decodedBytes, "utf-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SocketTransfer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    @Override
    public void addListener(EclaSocketListener listener) {
        this.mListener = listener;
    }
    

    
}
