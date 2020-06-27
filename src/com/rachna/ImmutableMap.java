package com.rachna;

import java.util.LinkedHashMap;
import java.util.Map;

class ImmutableMap {

    public static final Map<Integer, String> teamCSK = new LinkedHashMap<Integer, String>() {
        {
            put(1,"dhoni");
            put(2,"virat");
            put(3,"monu");
            put(6,"jadeja");
            put(10,"parthiv");
        }
    };

    public static final Map<Integer, String> teamKKR = new LinkedHashMap<Integer, String>()
    {
        {
            put(1,"saurabh");
            put(2,"sachin");
            put(6,"saurabh");
            put(7,"haribhajan");
            put(13,"John");
        }
    };
    public static final Map<Integer, String> teamMI = new LinkedHashMap<Integer, String>()
    {
        {
            put(1,"dhoni");
            put(2,"virat");
            put(5,"Lynn");
            put(210,"Aman");
            put(22,"virat");
        }
    };
    public static final Map<Integer, String> teamRBC = new LinkedHashMap<Integer, String>()
    {
        {
            put(1,"dhoni");
            put(3,"virat");
            put(10,"dhoni");
            put(111,"virat");
            put(16,"virat");
        }
    };
}
