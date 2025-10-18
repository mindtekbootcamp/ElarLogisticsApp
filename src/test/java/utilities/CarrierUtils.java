package utilities;

import java.util.Random;
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
        Random random = new Random();
        int randomThreeNum = random.nextInt(100, 999);
        return String.valueOf(randomThreeNum);
    }
    public static String randomFourDigitGenerator() {
        Random random = new Random();
        int randomFourNum = random.nextInt(1000, 9999);
        return String.valueOf(randomFourNum);
    }

    public static String randomFiveDigitGenerator() {
        Random random = new Random();
        int randomFiveNum = random.nextInt(10000, 99999);
        return String.valueOf(randomFiveNum);

    }
}
