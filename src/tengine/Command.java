
package tengine;

import java.lang.reflect.Method;


class Command {
    
    
    String commandText; 
    Method commandMethod;


    protected Command(String cmndText, Method cmndMethod) {
        commandText = cmndText;
        commandMethod = cmndMethod;
        
    }
}
