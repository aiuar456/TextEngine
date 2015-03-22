
package main;

import tengine.StandardTextInputSystem;


/**
 * Created by austinletson on 3/21/15.
 */
public class PlayerCommunicationHandler extends StandardTextInputSystem{

    public PlayerCommunicationHandler(){
        super(System.in, System.out);
    }

    @IsCommand
    public void test(String s){
        println(s);
    }


}
