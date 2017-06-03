package com.epam.jmp.streamLambda;

/**
 * Created by Gleb88 on 03.06.2017.
 */
public class Book {
    private String Name;
    private String AuthorName;
    private String AuthorSurname;
    private int AuthorYears;
    private Boolean isAuthorMen;

    public Book(String name, String authorName, String authorSurname, int authorYears, Boolean isAuthorMen) {
        Name = name;
        AuthorName = authorName;
        AuthorSurname = authorSurname;
        AuthorYears = authorYears;
        this.isAuthorMen = isAuthorMen;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public String getAuthorSurname() {
        return AuthorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        AuthorSurname = authorSurname;
    }

    public int getAuthorYears() {
        return AuthorYears;
    }

    public void setAuthorYears(int authorYears) {
        AuthorYears = authorYears;
    }

    public Boolean getAuthorMen() {
        return isAuthorMen;
    }

    public void setAuthorMen(Boolean authorMen) {
        isAuthorMen = authorMen;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Name='" + Name + '\'' +
                ", AuthorName='" + AuthorName + '\'' +
                ", AuthorSurname='" + AuthorSurname + '\'' +
                ", AuthorYears=" + AuthorYears +
                ", isAuthorMen=" + isAuthorMen +
                '}';
    }

    public String getGenderAutor(){
        if (this.isAuthorMen) {
            return "Male";
        }
        return "Female";
    }
}


