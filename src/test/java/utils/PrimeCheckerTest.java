package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimeCheckerTest {

    private DataChecker dataChecker;

    @BeforeEach
    void setUp() {
        dataChecker = new PrimeChecker();
    }

    @Test
    public void testIsPrimeValidNumber() {
        boolean result = dataChecker.isPrime(BigInteger.valueOf(7));
        assertTrue(result);

        assertTrue(dataChecker.isPrime(BigInteger.valueOf(54881)));
    }

    @Test
    public void testIsPrimeValidLongNumber() {
        boolean result = dataChecker.isPrime(BigInteger.valueOf(9223372036854775783L));
        assertTrue(result);
    }

    @Test
    public void testIsPrimeValidAfterLimitNumber() {
        boolean result = dataChecker.isPrime(new BigInteger("12345678901234567890123456869"));
        assertTrue(result);
    }

    @Test
    public void testIsPrimeInvalidNumber() {
        boolean result = dataChecker.isPrime(BigInteger.valueOf(9));
        assertFalse(result);
        assertFalse(dataChecker.isPrime(BigInteger.valueOf(50000)));
    }

    @Test
    public void testIsPrimeInvalidLongNumber() {
        boolean result = dataChecker.isPrime(BigInteger.valueOf(9223372036854775781L));
        assertFalse(result);
    }

    @Test
    public void testIsPrimeInvalidAfterLimitNumber() {
        boolean result = dataChecker.isPrime(new BigInteger("12345678901234567890123456790"));
        assertFalse(result);
    }
}
