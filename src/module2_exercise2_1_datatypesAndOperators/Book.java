package module2_exercise2_1_datatypesAndOperators;

public class Book {
    public short bookId;
    public String bookTitle;
    public double bookPrice;
    public char bookCategory;
    public Author author;

    public Book(short bookId, String bookTitle, double bookPrice, char bookCategory, Author author) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
        this.bookCategory = bookCategory;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("Book Id: " + this.bookId);
        System.out.println("Book Title: " + this.bookTitle);
        System.out.println("Book Price: " + this.bookPrice);
        System.out.println("Book Category: " + this.bookCategory);
        System.out.println("Book Author: " + this.author.bookAuthorFirstName + " " + this.author.bookAuthorLastName);
    }
}
