package com.epam.jmp.jvm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gleb88 on 17.06.2017.
 */
public class OOM {
    private static final List<String> objects = new LinkedList<String>();

    public static void main(String[] a) throws InterruptedException {
        int iter = 0;
        while (true){
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 1000; j++) {
                    objects.add(new String("String" + j));
                }
            }
            iter++;
            System.out.println("iter: " + iter);
            Thread.sleep(100);
        }
    }
}
