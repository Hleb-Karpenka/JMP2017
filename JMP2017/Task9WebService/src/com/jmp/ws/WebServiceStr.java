package com.jmp.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WebServiceStr {

    @WebMethod
    public String getPricebyName(String name);

    @WebMethod
    public String addPricebyName(String name1, String name2);

    @WebMethod
    public String editPricebyName(String name1, String name2);

    @WebMethod
    public String delitePricebyName(String name1);
}
