package danyliuk.mykola.view;

import java.util.Scanner;

/**
 * @author Mykola Danyliuk
 */
public class ConsoleView implements View{

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String s){
        System.out.print(s);
    }

    @Override
    public void printError(String s) {
        System.err.print(s + "\n");
    }

    @Override
    public String read(){
        return scanner.next();
    }

}
