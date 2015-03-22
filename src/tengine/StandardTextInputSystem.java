
package tengine;

import java.io.InputStream;
import java.io.PrintStream;
import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Input system using simple commands followed by a series of strings
 *
 * @author austinletson
 */
public class StandardTextInputSystem{


    Scanner stdInput;
    PrintStream stdOutput;
    String defaultPrompt = ">_";
    List<Command> commands = new ArrayList();



    //Use this annotation to create Standard Text Input System Commands
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Documented
    protected @interface IsCommand{};

    /**
     * Constructor for using a simple Scanner for input
     *
     * @param stdIn InputStream
     * @param stdOut PrintStream
     */
    public StandardTextInputSystem(InputStream stdIn, PrintStream stdOut){
        stdInput = new Scanner(stdIn);
        stdOutput = stdOut;
        Method[] allMethods = this.getClass().getMethods();
        for(Method method: allMethods){
            Annotation[] methodDeclaredAnnotations = method.getDeclaredAnnotations();
            for(Annotation annotation: methodDeclaredAnnotations){
                if (annotation instanceof IsCommand){
                    commands.add(new Command(method.getName(), method));
                }
            }
        }


    }

    /**Calls upon the InputSystem to prompt the user. (Will not return until user has entered a valid command)
     *
     */
    public void prompt(){
        stdOutput.print(defaultPrompt);
        searchForCommand();
    }

    /**
     * Same as prompt() but uses a custom prompt text
     *
     * @param promptText String
     */
    public void prompt(String promptText){
        stdOutput.print(promptText);
        searchForCommand();
    }

    /**
     * Searches the Standard Input for a valid command and then executes that command method
     *
     */
    protected void searchForCommand(){

        List<String> words = new ArrayList(Arrays.asList(stdInput.nextLine().split(" ")));
        for(Command cmd : commands) {
            if (cmd.commandText.equals(words.get(0))) {
                words.remove(0);
                try {
                    cmd.commandMethod.invoke(this, words.toArray());
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    stdOutput.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Prints to standard output
     *
     * @param output String
     */
    public void println(String output){
        stdOutput.println(output);
    }

    /**
     * Sets defaults prompt text
     *
     * @param defaultPromptTxt String
     */
    public void setDefaultPromptText(String defaultPromptTxt){
        defaultPrompt = defaultPromptTxt;
    }



}


