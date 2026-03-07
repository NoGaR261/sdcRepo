package utils;

import java.math.BigInteger;
import java.util.Optional;

public class NumberParser implements DataParser {

    @Override
    public Optional<BigInteger> parse(String value) {
        if (value == null) {
            return Optional.empty();
        }

        try {
            return Optional.of(new BigInteger(value.trim()));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
