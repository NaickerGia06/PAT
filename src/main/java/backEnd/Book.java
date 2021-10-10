/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;

/**
 *
 * @author Gia Naicker
 */
public class Book {

    private String bookTitle;
    private String bookAuthor;
    private String isbn;
    private String genre;
    private boolean takenOut;
    private boolean overdue;
    private String rating;

    public Book(String t, String a, String isbn, String g, boolean tO, boolean over, String rating) {
        this.bookTitle = t;
        this.bookAuthor = a;
        this.isbn = isbn;
        this.genre = g;
        this.takenOut = tO;
        this.overdue = over;
        this.rating = rating;
    }

    //Returns the title of a book as a String
    public String getBookTitle() {
        return bookTitle;
    }

    //Sets the title of a book to bookTitle
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    //Returns the author of a book as a String
    public String getBookAuthor() {
        return bookAuthor;
    }

    //Sets the author of the book to bookAuthor
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    //Returns the isbn of the book as a String
    public String getIsbn() {
        return isbn;
    }

    //Sets the isbn to isbn
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //Returns the book's genre as a String
    public String getGenre() {
        return genre;
    }

    //Sets the book's genre to genre
    public void setGenre(String genre) {
        this.genre = genre;
    }

    //Returns boolean value of takenOut (true/false)
    public boolean isTakenOut() {
        return takenOut;
    }

    //Sets takenOut to takenOut
    public void setTakenOut(boolean takenOut) {
        this.takenOut = takenOut;
    }

    //Returns boolean value of overdue (true/false)
    public boolean isOverdue() {
        return overdue;
    }

    //Sets overdue to overdue
    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    //Returns the book's rating as a String
    public String getRating() {
        return rating;
    }

    //Sets the book's rating to rating
    public void setRating(String rating) {
        this.rating = rating;
    }

    //Returns all fields of the object as a String
    public String toString() {
        String takenOutStr = "";
        String overdueStr = "";

        if (takenOut) {
            takenOutStr += "This book has been taken out of the library.";
        }
        if (overdue) {
            overdueStr += "This book is overdue.";
        }
        return "Title:\n" + this.bookTitle + "\n\nAuthor:\n" + this.bookAuthor + "\n\nISBN:\n" + this.isbn + "\n\nGenre:\n" + this.genre + "\n\nRating out of 5:\n" + this.rating + "\n\n" + takenOutStr + "\n" + overdueStr;
    }

    //Returns delimitered String
    public String toFileString() {
        return this.bookTitle + "#" + this.bookAuthor + "#" + this.isbn + "#" + this.genre + "#" + this.takenOut + "#" + this.overdue + "#" + this.rating;
    }

}
