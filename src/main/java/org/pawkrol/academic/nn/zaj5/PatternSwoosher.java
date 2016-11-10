package org.pawkrol.academic.nn.zaj5;

import java.util.Random;

public class PatternSwoosher {

    public static void swoosh(float[] pattern, int amount){
        Random random = new Random();
        float val;
        int pos;

        for (int a = 0; a < amount; a++){
            val = ( random.nextInt(2) == 0 ) ? -1.f : 1.f;
            pos = random.nextInt(pattern.length);

            pattern[pos] = val;
        }
    }

}
