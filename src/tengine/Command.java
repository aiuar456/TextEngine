
package tengine;

import java.lang.reflect.Method;


class Command {


    String commandText;
    Method commandMethod;

    /**
     * Standard Constructor for Command
     *
     * @param cmndText   String
     * @param cmndMethod Method
     */
    protected Command(String cmndText, Method cmndMethod) {
        commandText = cmndText;
        commandMethod = cmndMethod;

    }
}
