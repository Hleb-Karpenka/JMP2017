package com.epam.jmp.mongo;

/**
 * Created by Gleb88 on 23.06.2017.
 */

import com.mongodb.*;

import java.util.Date;
import java.util.LinkedList;

/**
 * Java + MongoDB Simple Example
 *
 */
public class Main {


    static String array_names[] = {"John","Tim","Brit","Robin","Smith","Lora","Jennifer","Lyla","Victor","Adam"};

    static String array_address[][] ={
            {"US", "FL", " Miami"},
            {"US", "FL", " Orlando"},
            {"US", "CA", "San Diego"},
            {"US", "FL", " Orlando"},
            {"US", "FL", " Orlando"},
            {"US", "NY", "New York"},
            {"US", "NY", "Buffalo"},
            {"US", "TX", " Houston"},
            {"US", "CA", "San Diego"},
            {"US", "TX", " Houston"}
    };

    public static void main(String[] args) {

        try {

            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("test");
            DBCollection collection = db.getCollection("person");
            BasicDBObject document ;
            String address[];
            for(int i = 0 ; i < 1000000 ; i++){
                System.out.println(i);
                document = new BasicDBObject();
                document.append("name", array_names[i%10]);
                document.append("age", (int)(Math.random()*60));
                document.append("messagesPerMonth", (int)(Math.random()*999));
                document.append("FilmsWatched", (int)(Math.random()*999));
                document.append("join", new Date());
                document.append("friends", pickFriends());

                address = pickAddress();
                document.append("address", new BasicDBObject("country",address[0])
                        .append("state", address[1])
                        .append("city", address[2]));

                collection.insert(document);

            }

            System.out.println("All Persons: "+collection.getCount());
            DBCursor cursor = collection.find();

            BasicDBObject query = new BasicDBObject("age", new BasicDBObject("$gt", 40));
            cursor = collection.find(query);
            System.out.println("Person with age > 40 --> "+cursor.count());

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("age", 20);
            BasicDBObject updateObj = new BasicDBObject();
            updateObj.put("$set", newDocument);
            collection.update(query, updateObj,false,true);
            cursor = collection.find(query);
            System.out.println("Person with age > 40 after update --> "+cursor.count());

            BasicDBObject averageMessages = new BasicDBObject("$group", new BasicDBObject("_id", "$messagesPart")
                    .append("avrage", new BasicDBObject("$avg", "$messagesPerMonth")));
            AggregationOutput output = collection.aggregate(averageMessages);
            System.out.println("average messages --> "+output.results());
            DBCursor min = cursor.min(new BasicDBObject("friends", new BasicDBObject("$gt", 100)));
            System.out.println("Min number of watched movies by users with more than 100 friends --> " + min.toString());

        } catch (MongoException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String[] pickFriends(){
        int numberOfFriends = (int) (Math.random()* 10);
        LinkedList<String> friends = new LinkedList<String>();
        int random = 0;
        while(friends.size() < numberOfFriends){
            random = (int) (Math.random()*10);
            if(!friends.contains(array_names[random]))
                friends.add(array_names[random]);

        }
        String a[] = {};
        return  friends.toArray(a);
    }
    private static String[] pickAddress(){
        int random = (int) (Math.random()*10);
        return array_address[random];
    }
}
