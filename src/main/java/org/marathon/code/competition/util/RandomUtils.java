package org.marathon.code.competition.util;

import java.util.Random;

public class RandomUtils {

    private static Random random = new Random();

    public static int nextInt(int i) {
        return random.nextInt(i);
    }

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }

    public static float nextFloat() {
        return random.nextFloat();
    }

}
