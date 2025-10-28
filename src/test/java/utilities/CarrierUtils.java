package utilities;

import java.util.UUID;

public class CarrierUtils {

    public static String uuidGenerator() {
        UUID uuid = UUID.randomUUID();
        return uuid + "";
    }

    public static String uuidCarrierGenerator() {
        UUID uuid = UUID.randomUUID();
        return uuid + ", Co";
    }

    public static String randomThreeDigitGenerator() {
        return uuidGenerator().substring(0, 3);
    }

    public static String randomFourDigitGenerator() {
        return uuidGenerator().substring(0, 4);
    }

    public static String randomFiveDigitGenerator() {
        return uuidGenerator().substring(0, 5);
    }
}
