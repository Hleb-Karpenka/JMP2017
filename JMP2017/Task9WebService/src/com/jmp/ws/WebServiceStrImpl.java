package com.jmp.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.jmp.ws.WebServiceStr")
public class WebServiceStrImpl implements WebServiceStr {

    private static final PriceList priceList = new PriceList();

    @Override
    public String getPricebyName(String name) {
        return priceList.getPriceByName(name);
    }

    @Override
    public String addPricebyName(String name, String cost) {
        return priceList.addPricebyName(name, cost );
    }

    @Override
    public String editPricebyName(String name, String cost) {
        return priceList.editPricebyName(name, cost );
    }

    @Override
    public String delitePricebyName(String name) {
        return priceList.delitePricebyName(name );
    }


}
