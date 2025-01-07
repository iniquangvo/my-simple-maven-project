package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testGreet()
    {
        App app = new App();
        String res = app.greet("World");
        assertEquals("Hello World!", res);
    }
}
