package westpacUtilities;

import java.util.Random;

public class numberUtilities {

    //Method to generate account numbers
    public static String generateRandomAccountNumbers() {
        long m = (long) Math.pow(7, 6);
        long j = m + new Random().nextLong();

        //convert to String
        String Acc = String.valueOf(j);
        Acc = Acc.substring(2,17); // substring to attain
        return Acc;
    }

    //Method to generate account names
    public static String generateRandomAccountNames() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

}

