package com.jmp.decorator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Created by Gleb88 on 12.03.2017.
 */
public class Main {

    public static void main(String agr[]){

        ArrayList<Person> list = new ArrayList<Person>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("file.txt"), StandardCharsets.UTF_8))){
            String line;

            while ((line = reader.readLine()) != null) {
                list.add(new PersonInputStream(new Reader()).readPerson(line));
            }
        } catch (IOException e) {
            // log error
        }

        for (Person person: list)
        {
            System.out.println(person);
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));
            String str;
            for (Person person: list)
            {
                bw.write(new PersonOutputStream(new Writer()).writePerson(person));
                bw.write("\r\n");
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
