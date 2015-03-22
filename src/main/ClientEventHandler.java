

package main;

import tengine.StandardTextInputSystem;


/**
 * Static class for handling client events
 */
public class ClientEventHandler{

    static StandardTextInputSystem STIS;
    public static void main(String[] args) throws Exception{
        PlayerCommunicationHandler PCH = new PlayerCommunicationHandler();
        PCH.prompt();
    }



    public static void test(){
        STIS.println("hello world!");
    }
    
}
