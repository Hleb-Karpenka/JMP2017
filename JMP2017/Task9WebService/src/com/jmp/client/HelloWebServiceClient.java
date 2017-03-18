package com.jmp.client;


import com.jmp.ws.WebServiceStr;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:1986/wss/str?wsdl");
        QName qname = new QName("http://ws.jmp.com/", "WebServiceStrImplService");

        Service service = Service.create(url, qname);
        WebServiceStr hello = service.getPort(WebServiceStr.class);
        System.out.println(hello.getPricebyName("RAM_DDR4_2GB"));

    }
}
