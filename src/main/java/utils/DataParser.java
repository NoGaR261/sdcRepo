package utils;

import java.math.BigInteger;
import java.util.Optional;

public interface DataParser {
    Optional<BigInteger> parse(String value);
}
