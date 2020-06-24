package com.rachna;

import java.util.Random;

public class GeneralUtils {
       public enum Constants
        {
            BOWLING,BATTING;
        }

        private GeneralUtils(){ }

        private final static Random random = new Random();
        public static Random getRandomFunction(){
            return random;
        }

        public static int getWinner()
        {
        Random r=getRandomFunction();
        if(r.nextInt(2)==0)
            return 0;
        else
            return 1;
        }
    }
