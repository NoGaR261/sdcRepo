package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataParserTest {

    private DataParser numberParser;

    @BeforeEach
    void setUp() {
        numberParser= new NumberParser();
    }

    @Test
    public void testParseValidPositiveNumber() {
        String input = "123";
        Optional<BigInteger> result = numberParser.parse(input);

        assertTrue(result.isPresent());
        assertEquals(new BigInteger("123"), result.get());
    }

    @Test
    public void testParseValidPositiveNumberWithTrim() {
        String input = "   123   ";
        Optional<BigInteger> result = numberParser.parse(input);

        assertTrue(result.isPresent());
        assertEquals(new BigInteger("123"), result.get());
    }

    @Test
    public void testParseValidNegativeNumber() {
        String input = "-123";
        Optional<BigInteger> result = numberParser.parse(input);

        assertTrue(result.isPresent());
        assertEquals(new BigInteger("-123"), result.get());
    }

    @Test
    public void testParseInvalidString() {
        String invalidInput = "abc";
        Optional<BigInteger> result = numberParser.parse(invalidInput);

        assertFalse(result.isPresent());
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void testParseInvalidNUmber() {
        String invalidInput = "--123";
        Optional<BigInteger> result = numberParser.parse(invalidInput);

        assertFalse(result.isPresent());
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void testParseInvalidNull() {
        assertEquals(Optional.empty(), numberParser.parse(null));
    }
}
