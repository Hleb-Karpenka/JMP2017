package com.jmp.client;

import com.jmp.ws.*;

public class WebServiceStrClient {
    public static void main(String[] args) {
        WebServiceStrImplService  helloService = new WebServiceStrImplService();
        WebServiceStr wsStr = helloService.getWebServiceStrImplPort();

        System.out.println( wsStr.getPricebyName( "phone"));
        System.out.println( wsStr.addPricebyName( "phone","500") );
        System.out.println( wsStr.getPricebyName( "phone"));

        System.out.println( wsStr.editPricebyName( "phone","333") );
        System.out.println( wsStr.getPricebyName( "phone"));

        System.out.println( wsStr.delitePricebyName( "phone") );
        System.out.println( wsStr.getPricebyName( "phone"));
    }
}
