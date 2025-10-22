package org.example;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 * Entry point class demonstrating basic console output and a simple for-loop. Prints a greeting,
 * then iterates from 1 to 5, outputting the current index on each line. Uses IO.println for
 * printing and String.format for the greeting.
 */
public final class Main {

    private Main() {}

    static void main() {

        IO.println(String.format("Hello, welcome!"));

        for (int i = 1; i <= 5; i++) {
            IO.println("i = " + i);
        }
    }
}
