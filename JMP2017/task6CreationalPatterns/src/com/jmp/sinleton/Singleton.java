package com.jmp.sinleton;

/**
 * Created by Gleb88 on 04.03.2017.
 */
public class Singleton {
    private static Singleton instance;
    private Singleton () {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
