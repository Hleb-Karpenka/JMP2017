package com.jmp.main;

import com.jmp.abstractfactory.*;
import com.jmp.factorymethod.*;
import com.jmp.builder.*;
import com.jmp.objectpool.JDBCConnectionPool;
import com.jmp.prototype.CoconutCookie;
import com.jmp.prototype.Cookie;
import com.jmp.prototype.CookieMachine;
import com.jmp.sinleton.Singleton;

import java.sql.Connection;

/**
 * Created by Gleb88 on 04.03.2017.
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        // Abstract factory:
        AbstractFactory factory1 = new ConcreteFactory1();
        Client client1 = new Client(factory1);
        client1.execute();

        AbstractFactory factory2 = new ConcreteFactory2();
        Client client2 = new Client(factory2);
        client2.execute();

        //Factory Method
        // an array of creators
        Creator[] creators = {new ConcreteCreatorA(), new ConcreteCreatorB()};
        // iterate over creators and create products
        for (Creator creator: creators) {
            Product product = creator.factoryMethod();
            System.out.printf("Created {%s}\n", product.getClass());
        }

        //builder
        NutritionFacts cocaCola = new NutritionFacts
                .Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

        //Prototype
        Cookie tempCookie = null;
        Cookie prot = new CoconutCookie();
        CookieMachine cm = new CookieMachine(prot);
        for (int i = 0; i < 100; i++)
            tempCookie = cm.makeCookie();

        //Singleton
        Singleton st = Singleton.getInstance();

        //Object Pool
        JDBCConnectionPool pool = new JDBCConnectionPool(
                "org.hsqldb.jdbcDriver", "jdbc:hsqldb://localhost/mydb",
                "sa", "secret");
            // Get a connection:
        Connection con = pool.checkOut();
            // Use the connection
            // Return the connection:
        pool.checkIn(con);
    }
}
