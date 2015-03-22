
package main;

import tengine.StandardTextInputSystem;


public class PlayerCommunicationHandler extends StandardTextInputSystem {

    public PlayerCommunicationHandler() {
        super(System.in, System.out);
    }

    @IsCommand
    public void test(String s) {
        println(s);
    }


}
