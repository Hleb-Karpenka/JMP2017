package com.jmp.adapterpattern;

import java.util.ArrayList;

/**
 * Created by Gleb88 on 12.03.2017.
 */
public class ArrayListAdapter implements ListAdapter {

    private ArrayList list = new ArrayList();

    ArrayListAdapter(ArrayList list) {
        this.list = list;
    }

    @Override
    public void push(Object obj) {
        this.list.add(obj);
    }

    @Override
    public Object pop() {
        return this.list.get(this.list.size()-1);
    }
}
