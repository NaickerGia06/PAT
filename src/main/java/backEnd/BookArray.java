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
import java.io.*;
import java.util.*;

public class BookArray {

    private Book[] booksArr = new Book[150];
    private String[] usernamesArr = new String[50];
    private int booksArrsize = 0;
    private int usernamesArrSize = 0;
    private String booksFilePath = "C:\\Users\\Gia Naicker\\OneDrive\\Documents\\NetBeansProjects\\PAT\\data\\books.txt";
    private String usernamesFilePath = "C:\\Users\\Gia Naicker\\OneDrive\\Documents\\NetBeansProjects\\PAT\\data\\usernames.txt";

    //Scans data from text file and appends to the array
    public BookArray() {
        //Scans through books.txt
        try {
            Scanner booksFs = new Scanner(new File(booksFilePath)); //Scans file
            String line;
            String title;
            String author;
            String isbn;
            String genre;
            boolean takenOut;
            boolean overdue;
            String rating;

            while (booksFs.hasNext()) {
                line = booksFs.nextLine();

                Scanner booksLs = new Scanner(line).useDelimiter("#"); //Scans each line
                title = booksLs.next();
                author = booksLs.next();
                isbn = booksLs.next();
                genre = booksLs.next();
                takenOut = booksLs.nextBoolean();
                overdue = booksLs.nextBoolean();
                rating = booksLs.next();
                booksLs.close();

                booksArr[booksArrsize] = new Book(title, author, isbn, genre, takenOut, overdue, rating);
                booksArrsize++;
            }
            booksFs.close();
        } catch (FileNotFoundException ex) {
            System.out.println("The file was not found :(");
        }

        //Scans through usernames.txt
        try {
            Scanner usernamesFs = new Scanner(new File(usernamesFilePath)); //Scans file

            while (usernamesFs.hasNext()) {
                String username = usernamesFs.nextLine();

                usernamesArr[usernamesArrSize] = username;
                usernamesArrSize++;
            }
            usernamesFs.close();
        } catch (FileNotFoundException ex) {
            System.out.println("The file was not found :(");
        }
    }

    //Returns a String of all fields of the book
    public String toString() {
        String output = "";
        for (int i = 0; i < booksArrsize; i++) {
            output += booksArr[i].toString();
        }
        return output;
    }

    //Sorts books by title (alphabetically)
    public void sort() {
        for (int currentPos = booksArrsize - 1; currentPos >= 0; currentPos--) {
            boolean sortedFlag = true;

            for (int j = 0; j < currentPos; j++) {
                if (booksArr[j].getBookTitle().compareToIgnoreCase(booksArr[j + 1].getBookTitle()) > 0) {
                    Book temp = booksArr[j];
                    booksArr[j] = booksArr[j + 1];
                    booksArr[j + 1] = temp;
                    sortedFlag = false;
                }
            }//End first for loop
            if (sortedFlag) {
                break;
            }
        }//End second for loop
    }

    //Search by title - returns int index at where book is found
    public int search(String title) {
        int start = 0;
        int end = booksArrsize - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (booksArr[middle].getBookTitle().equalsIgnoreCase(title)) {
                return middle;
            } else if (booksArr[middle].getBookTitle().compareToIgnoreCase(title) > 0) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    //Checks if a username is valid, returns true or false
    public boolean checkLogin(String username, String password) {
        boolean flag = false;
        for (int i = 0; i < usernamesArrSize; i++) {
            if (username.equalsIgnoreCase(usernamesArr[i]) && password.equalsIgnoreCase("Reddam2021")) {
                flag = true;
            }
        }
        return flag;
    }

    //Helper method for insert (creates space in array by shifting everything right)
    private void shiftRight(int index) {
        booksArrsize++;
        for (int i = booksArrsize - 1; i > index; i--) {
            booksArr[i] = booksArr[i - 1];
        }
    }

    //Adds a book to the array(information received from addBook screen in UI)
    public int addBook(String title, String author, String isbn, String genre, boolean takenOut, boolean overdue, String rating) {
        this.sort();
        int index = -1;
        for (int i = 0; i < booksArrsize; i++) {
            if (booksArr[i].getBookTitle().compareToIgnoreCase(title) > 0) {
                index = i;
                break;
            }
        }
        this.shiftRight(index);
        booksArr[index] = new Book(title, author, isbn, genre, takenOut, overdue, rating);
        this.saveToFile();
        return index;
    }

    //Helper method for delete (removes book in array by shifting everything left)
    private void shiftLeft(int index) {
        for (int i = index; i < booksArrsize - 1; i++) {
            booksArr[i] = booksArr[i + 1];
        }
        booksArrsize--;
    }

    //Searches for index of book then deletes it from array
    public void delete(String title) {
        int index = this.search(title);
        if (index >= 0) {
            this.shiftLeft(index);
        }
        this.saveToFile();
    }

    //Returns a String of all information for each book
    public String viewBook(String title) {
        int index = this.search(title);
        return booksArr[index].toString();
    }

    //Calls every book's toFileString into one big string
    private String toFileString() {
        String output = "";
        for (int i = 0; i < booksArrsize; i++) {
            output += booksArr[i].toFileString() + "\n";
        }
        return output;
    }

    //Calls the array's toFileString and saves it to the file
    private void saveToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(booksFilePath), false);
            pw.print(toFileString());
            pw.close();
        } catch (IOException ex) {
            System.out.println("Could Not Write To File :(");
        }
    }

    //Returns a String array of all books' titles (in array)
    public String[] getBookTitlesAsArray() {
        String[] titles = new String[booksArrsize];

        for (int i = 0; i < booksArrsize; i++) {
            titles[i] = booksArr[i].getBookTitle();
        }
        return titles;
    }

    //Sets a book's rating to the input it receives from UI (rating)
    public void rateBooks(int index, String rating) {
        booksArr[index].setRating(rating);
        saveToFile();
    }

    //Returns a String list of books based off book[index]'s genre
    public String recBooksByName(int index) {

        String recBooksOutput = "";

        for (int i = 0; i < booksArrsize; i++) {
            if (booksArr[i].getGenre().equalsIgnoreCase(booksArr[index].getGenre())) {
                recBooksOutput += booksArr[i].getBookTitle() + "\n";
            }
        }
        return recBooksOutput;
    }

    //Gets String input (genre) from UI & returns every book of same genre in library.
    public String recBooksByGenre(String genre) {
        String recBooksOutput = "";

        for (int i = 0; i < booksArrsize; i++) {
            if (booksArr[i].getGenre().equalsIgnoreCase(genre)) {
                recBooksOutput += booksArr[i].getBookTitle() + "\n";
            }
        }
        return recBooksOutput;
    }

    //Checks if all fields have been entered, returns true or false
    public boolean checkValues(String isbn, String title, String author) {
        boolean flag = true; //Does not contain letters
        char c = 'a';

        for (int i = 0; i < isbn.length(); i++) {
            c = isbn.charAt(i);

            if (!Character.isDigit(c) || isbn.length() != 4) {
                flag = false;
            }
        }
        boolean check = flag && !title.isBlank() && !author.isBlank() && !isbn.isBlank();
        return check;
    }

    //Every first letter of the word is returned as a capital letter
    public String convertToUpper(String name) {
        String converted = "";
        Scanner nameSc = new Scanner(name);

        while (nameSc.hasNext()) {
            String eachName = nameSc.next();
            char firstLet = Character.toUpperCase(eachName.charAt(0));
            String restOfName = eachName.substring(1);
            converted += firstLet + restOfName + " ";
        }
        return converted;
    }

    //Returns a String list of all books taken out
    public String booksTakenOut() {
        String booksTakenOut = "";

        for (int i = 0; i < booksArrsize; i++) {
            if (booksArr[i].isTakenOut()) {
                booksTakenOut += booksArr[i].getBookTitle() + "\n";
            }
        }
        return booksTakenOut;
    }

    //Returns a String list of all books that are overdue
    public String booksOverdue() {
        String booksOverdue = "";

        for (int i = 0; i < booksArrsize; i++) {
            if (booksArr[i].isOverdue()) {
                booksOverdue += booksArr[i].getBookTitle() + "\n";
            }
        }
        return booksOverdue;
    }

    //Returns a String list of books with highest rating(5)
    public String highestRatings() {
        String highestRated = "";
        for (int i = 0; i < booksArrsize; i++) {
            if (booksArr[i].getRating().equalsIgnoreCase("5")) {
                highestRated += booksArr[i].getBookTitle() + "\n";
            }
        }
        return highestRated;
    }
}
/*
Sir if you actually went through all of these methods and got to the end...
Hi :)
 */
