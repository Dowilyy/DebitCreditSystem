package file;

import java.util.Scanner;

/**
 *Informacijos isvedimas i ekrana.
 */

class Dialog {
    private Scanner scanner = new Scanner(System.in);

    void println(String message) {

        System.out.println(message);
    }
    private void print(String message) {

        System.out.print(message);
    }
    private String input(){

        return scanner.nextLine();
    }

    /**
     * Pranesimo rodymas
     * @param message pranesimas
     * @return pranesimas
     */
    String input(String message) {
        print(message);
        return input();
    }
}
