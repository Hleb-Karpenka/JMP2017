package com.jmp.ws;

import java.util.ArrayList;

/**
 * Created by Gleb88 on 18.03.2017.
 */
public class PriceList {

    ArrayList<Price> priceList = new ArrayList<Price>();

    public PriceList(ArrayList<Price> priceList) {
        this.priceList = priceList;
    }

    public ArrayList<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(ArrayList<Price> priceList) {
        this.priceList = priceList;
    }

    public PriceList() {
        priceList.add(new Price ("RAM_DDR3_2GB","20"));
        priceList.add(new Price ("RAM_DDR4_2GB","40"));
    }

    public String getPriceByName(String name) {
        for (Price price: priceList)
        {
            if(price.getName().equals(name))
            {   return price.getCost();
            }
        }
        return "no price with such name ".concat(name);
    }

    public String addPricebyName(String name, String cost) {
        try {
            priceList.add(new Price (name,cost));
            return "price is added";
        }catch (Exception excp){
            return "price is not added";
        }
    }

    public String editPricebyName(String name, String cost) {
        for (Price price: priceList)
        {
            if(price.getName().equals(name))
            {
                price.setCost(cost);
                return "price edited";
            }
        }
        return "false";
    }

    public String delitePricebyName(String name) {
        for (Price price: priceList)
        {
            if(price.getName().equals(name))
            {
                priceList.remove(price);
                return "price was deleted";
            }
        }
        return "price was not deleted";
    }
}
