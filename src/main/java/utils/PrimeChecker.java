package utils;

import java.math.BigInteger;

public class PrimeChecker implements DataChecker {

    private static final BigInteger LIMIT = BigInteger.valueOf(1_000_000_000_000L);

    @Override
    public boolean isPrime(BigInteger number) {
        if (number == null) {
            return false;
        }

        if (number.compareTo(LIMIT) > 0)
            return number.isProbablePrime(100);

        return isPrimeLong(number.longValue());
    }

    @Override
    public boolean isPrimeLong(long number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;

        for (long i = 5; i <= number / i; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
