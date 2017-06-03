package com.epam.jmp.streamLambda;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by Gleb88 on 03.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        books = generateBooks(books);

        //classic processing
        int i=0;
        Set<String> uniqueSurnameOfBooks = new HashSet<String>();
        for(Book book:books){
            if(book.getAuthorYears()>=50){
                int oldSize = uniqueSurnameOfBooks.size();
                uniqueSurnameOfBooks.add(book.getAuthorSurname().toUpperCase());
                if (uniqueSurnameOfBooks.size()>oldSize){
                    i++;
                }
            }
            if (i==15) break;
        }
        System.out.println("a) The authors that are 50 years old or older: " + uniqueSurnameOfBooks);

        int summ = 0;
        for(Book book:books){
            if(book.getAuthorYears()<=25 && book.getGenderAutor().equals("Female")){
                int oldSize = uniqueSurnameOfBooks.size();
                uniqueSurnameOfBooks.add(book.getAuthorSurname().toUpperCase());
                if (uniqueSurnameOfBooks.size()>oldSize){
                    summ = summ + book.getAuthorYears();
                }
            }
        }
        System.out.println("b) The sum of ages of all female authors younger than 25 is: " + summ);

        System.out.println("-------------");
        //stream and lambda java8
        final Set<String> uniqueSurnameOfBooksLambda = books.stream()
                .filter(distinctByKey(Book::getAuthorSurname))
                .filter(e -> e.getAuthorYears() >= 50)
                .map(e -> e.getAuthorSurname().toUpperCase())
                .collect(toList()).stream()
                .limit(15)
                .collect(toSet());

        System.out.println("a) The authors that are 50 years old or older: " + uniqueSurnameOfBooksLambda);

        int summLambda =  books.stream()
                .filter(e -> e.getAuthorYears() < 25)
                .filter(e -> e.getGenderAutor() == "Female")
                .filter(distinctByKey(Book::getAuthorSurname))
                .mapToInt(Book::getAuthorYears)
                .sum();

        System.out.println("b) The sum of ages of all female authors younger than 25 is: " + summLambda);
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static List<Book> generateBooks(List<Book> books) {

        return books = Arrays.asList(
                new Book("To Dream (A Broken Roads Romance)", "Carolyn", "Brown", 61, false),
                new Book("Dating and Dessert: Book Two", "Cassie", "Page", 20, false),
                new Book("Dating and Dessert: Book One", "Cassie", "Page", 20, false),
                new Book("Dating and Dessert: Book Three", "Cassie", "Page", 18, false),
                new Book("The Third Wish", "Carolyn", "Brown", 61, false),
                new Book("A Great Catch", "Rocklyn", "Ryder", 40, true),
                new Book("WOOD", "Rocklyn", "Ryder", 40, true),
                new Book("Watch over me: clean romance", "Jenny", "Dawson", 51, false),
                new Book("Redemption", "Jenny", "Dawson", 51, false),
                new Book("About a Dog", "Jenn", "McKinlay", 35, false),
                new Book("Caramel Crush", "Jenn", "McKinlay", 35, false),
                new Book("Hers For A While", "Danica", "Chandler", 28, false),
                new Book("A Brief History of Time", "Stephen", "Hawking", 75, true),
                new Book("The Bazaar of Bad Dreams: Stories", "Stephen", "Hawking", 75, true),
                new Book("Guns, Germs, and Steel", "Jared", "Diamond", 58, true),
                new Book("Collapse: How Societies Choose to Fail or Succeed", "Jared", "Diamond", 58, true),
                new Book("Life After Life", "Kate", "Atkinson", 35, false),
                new Book("The Road", "Cormac", "McCarthy", 80, true),
                new Book("The Crossing", "Cormac", "McCarthy", 80, true),
                new Book("To Kill a Mockingbird", "Harper", "Lee", 23, false),

                new Book("To Dream (A Broken Roads Romance)", "Carolyn", "Brown1", 61, false),
                new Book("Dating and Dessert: Book Two", "Cassie", "Page1", 20, false),
                new Book("Dating and Dessert: Book One", "Cassie", "Page1", 20, false),
                new Book("Dating and Dessert: Book Three", "Cassie", "Page1", 18, false),
                new Book("The Third Wish", "Carolyn", "Brown1", 61, false),
                new Book("A Great Catch", "Rocklyn", "Ryder1", 40, true),
                new Book("WOOD", "Rocklyn", "Ryder1", 40, true),
                new Book("Watch over me: clean romance", "Jenny", "Dawson1", 51, false),
                new Book("Redemption", "Jenny", "Dawson1", 51, false),
                new Book("About a Dog", "Jenn", "McKinlay1", 35, false),
                new Book("Caramel Crush", "Jenn", "McKinlay1", 35, false),
                new Book("Hers For A While", "Danica", "Chandler1", 28, false),
                new Book("A Brief History of Time", "Stephen", "Hawking1", 75, true),
                new Book("The Bazaar of Bad Dreams: Stories", "Stephen", "Hawking1", 75, true),
                new Book("Guns, Germs, and Steel", "Jared", "Diamond1", 58, true),
                new Book("Collapse: How Societies Choose to Fail or Succeed", "Jared1", "Diamond", 58, true),
                new Book("Life After Life", "Kate", "Atkinson1", 35, false),
                new Book("The Road", "Cormac", "McCarthy1", 80, true),
                new Book("The Crossing", "Cormac", "McCarthy1", 80, true),
                new Book("To Kill a Mockingbird", "Harper", "Lee1", 23, false),

                new Book("To Dream (A Broken Roads Romance)", "Carolyn", "Brown12", 61, false),
                new Book("Dating and Dessert: Book Two", "Cassie", "Page12", 20, false),
                new Book("Dating and Dessert: Book One", "Cassie", "Page12", 20, false),
                new Book("Dating and Dessert: Book Three", "Cassie", "Page12", 18, false),
                new Book("The Third Wish", "Carolyn", "Brown12", 61, false),
                new Book("A Great Catch", "Rocklyn", "Ryder12", 40, true),
                new Book("WOOD", "Rocklyn", "Ryder1", 40, true),
                new Book("Watch over me: clean romance", "Jenny", "Dawson12", 51, false),
                new Book("Redemption", "Jenny", "Dawson12", 51, false),
                new Book("About a Dog", "Jenn", "McKinlay12", 35, false),
                new Book("Caramel Crush", "Jenn", "McKinlay12", 35, false),
                new Book("Hers For A While", "Danica", "Chandler12", 28, false),
                new Book("A Brief History of Time", "Stephen", "Hawking12", 75, true),
                new Book("The Bazaar of Bad Dreams: Stories", "Stephen", "Hawking12", 75, true),
                new Book("Guns, Germs, and Steel", "Jared", "Diamond12", 58, true),
                new Book("Collapse: How Societies Choose to Fail or Succeed", "Jared21", "Diamond", 58, true),
                new Book("Life After Life", "Kate", "Atkinson12", 35, false),
                new Book("The Road", "Cormac", "McCarthy12", 80, true),
                new Book("The Crossing", "Cormac", "McCarthy12", 80, true),
                new Book("To Kill a Mockingbird", "Harper", "Lee12", 23, false),

                new Book("To Dream (A Broken Roads Romance)", "Carolyn", "Brown123", 61, false),
                new Book("Dating and Dessert: Book Two", "Cassie", "Page123", 20, false),
                new Book("Dating and Dessert: Book One", "Cassie", "Page123", 20, false),
                new Book("Dating and Dessert: Book Three", "Cassie", "Page132", 18, false),
                new Book("The Third Wish", "Carolyn", "Brown123", 61, false),
                new Book("A Great Catch", "Rocklyn", "Ryder132", 40, true),
                new Book("WOOD", "Rocklyn", "Ryder31", 40, true),
                new Book("Watch over me: clean romance", "Jenny", "Dawson132", 51, false),
                new Book("Redemption", "Jenny", "Dawson132", 51, false),
                new Book("About a Dog", "Jenn", "McKinlay132", 35, false),
                new Book("Caramel Crush", "Jenn", "McKinlay132", 35, false),
                new Book("Hers For A While", "Danica", "Chandler123", 28, false),
                new Book("A Brief History of Time", "Stephen", "Hawking123", 75, true),
                new Book("The Bazaar of Bad Dreams: Stories", "Stephen", "Hawking123", 75, true),
                new Book("Guns, Germs, and Steel", "Jared", "Diamond132", 58, true),
                new Book("Collapse: How Societies Choose to Fail or Succeed", "Jared213", "Diamond", 58, true),
                new Book("Life After Life", "Kate", "Atkinson132", 35, false),
                new Book("The Road", "Cormac", "McCarthy132", 80, true),
                new Book("The Crossing", "Cormac", "McCarthy123", 80, true),
                new Book("To Kill a Mockingbird", "Harper", "Lee132", 23, false),

                new Book("Qwerty", "qwer", "asdf", 61, true)

        );
    }

}
