package com.jmp.adapterpattern;

import java.util.ArrayList;

/**
 * Created by Gleb88 on 12.03.2017.
 */
public class Main {

    public static void main(String agr[]){
        ArrayList l = new ArrayList();
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        ArrayListAdapter adapter = new ArrayListAdapter(l);

        adapter.push(obj1);
        adapter.push(obj2);
        adapter.push(obj3);

        System.out.println(adapter.pop().equals(obj3));

    }
}
