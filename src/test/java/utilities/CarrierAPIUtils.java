package utilities;

import java.util.Random;
import java.util.UUID;

public class CarrierAPIUtils {

    public static String uuidGenerator(){
        UUID uuid = UUID.randomUUID();
        return uuid+"";
    }

    public static String uuidCarrierGenerator(){
        UUID uuid = UUID.randomUUID();
        return uuid + ", Co";
    }

    public static String randomAbbreviationGenerator(){
        Random random = new Random();
        String randomAbr = random.nextInt(999)+"";
        return randomAbr;
    }

    public static String randomNumberGenerator(){
        Random random = new Random();
        String randomNumber = random.nextInt(99999)+"";
        return randomNumber;
    }
}
