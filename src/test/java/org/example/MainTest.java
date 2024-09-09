package org.example;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void whenArgsEmptyThenPrintCorrectSyntax() throws Exception { //TODO: Sure we add exception in signature for tests? or just catch?
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; // Save the original System.out

        // Redirect System.out to the ByteArrayOutputStream
        System.setOut(new PrintStream(outputStream));

        try {
            String[] args = {};
            Main.main(args);
            String output = outputStream.toString().trim();

            assertEquals("Please enter command !", output);

        } finally {
            System.setOut(originalOut);
        }
    }
}
