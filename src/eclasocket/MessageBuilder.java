/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eclasocket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Milan
 */
public class MessageBuilder {
    
    /** Create json object from object. 
     @param object */
    public static String createMessage(Object object) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(object);
    }
    
    
    /** Parse Jsonobject. 
     @param message */
    public static Object parseMessage(String message) {
        return new Gson().fromJson(message, Object.class);
    }
    
}
