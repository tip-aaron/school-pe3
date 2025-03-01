package module2_exercise2_1_datatypesAndOperators;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

/**
 * Ragudos, Aaron
 * BSCS CS12S2
 * 02/28/2025
 * Application of DataTypes and Operators
 */
public class BookAcquisitionRunner {
    private final Supplier[] suppliers;

    public byte bookQty;
    public boolean orderBook;
    public double totalPrice;

    public BookAcquisitionRunner() {
        this.suppliers = new Supplier[]{
            new Supplier(
                1, "Aaron Store", "123 A Mangga St.", 92234,
                new Book[]{
                        new Book((short) 1, "Harry Potter", 1000, 'f', new Author("Aaron", "Ragudos")),
                        new Book((short) 2, "Lord of the Rings", 2750, 'f', new Author("Angelo", "Hatdog")),
                        new Book((short) 3, "How to Win Friends and Influence People", 1597, 'r', new Author("Hanz", "Mapua"))
                }
            ),
            new Supplier(
                    2, "Best Books Store", "456 B Banana St.", 93345,
                    new Book[]{
                            new Book((short) 4, "The Hobbit", 1472, 'f', new Author("Aaron", "Ragudos")),
                            new Book((short) 5, "1984", 5318, 'd', new Author("Angelo", "Hatdog")),
                            new Book((short) 6, "The Art of War", 2785, 'r', new Author("Hanz", "Mapua"))
                    }
            )
        };

        this.orderBook = false;
    }

    public void orderBooks() {
        if (!this.orderBook) {
            return;
        }

        int currentlyOrderedQty = 0;

        System.out.println("--- ORDERING BOOKS ---\n");

        bookQty = (byte) Utils.getNumFromJOptionPane("How many books would you like to order?");

        Scanner scanner = new Scanner(System.in);
        ArrayList<BookAndQty> bookAndQties = new ArrayList<>();

        while (true) {
            if (currentlyOrderedQty >= bookQty) {
                break;
            }

            int qty;
            String title;

            System.out.print("Enter book title: ");
            title = scanner.nextLine().trim();

            boolean didFind = false;

            for (Supplier supplier : suppliers) {
                if (supplier.doesBookExistWithTitle(title)) {
                    didFind = true;
                    break;
                }
            }

            if (didFind) {
                qty = Utils.getNumFromJOptionPane("How many " + title + " books would you like to order?", bookQty - currentlyOrderedQty);
                currentlyOrderedQty += qty;

                Book book = getBookWithTitle(title).orElseThrow();
                bookAndQties.add(new BookAndQty(qty, book));
                System.out.println("\nBooks ordered: " + currentlyOrderedQty + " / " + bookQty);
            } else {
                System.out.println("\nBook does not exist!\n");
            }
        }

        for (int i = 0, l = bookAndQties.size(); i < l; ++i) {
            BookAndQty bookAndQty = bookAndQties.get(i);
            Book book = bookAndQty.book;
            double discountedPrice = bookAndQty.qty < 4 ? book.bookPrice : bookAndQty.qty < 6 ? book.bookPrice * 0.25 : book.bookPrice * 0.5;

            for (int j = 0, l2 = bookAndQties.size(); j < l2; ++j) {
                if (j == i) {
                    continue;
                }

                BookAndQty bookAndQty2 = bookAndQties.get(i);
                Book book2 = bookAndQty2.book;
                boolean didApplyDiscount = false;

                if (book.bookTitle.equals(book2.bookTitle) && book.author.eq(book2.author)) {
                    didApplyDiscount = true;
                    discountedPrice *= 0.1;
                }

                if (book.bookCategory == book2.bookCategory && book.author.eq(book2.author)) {
                    didApplyDiscount = true;
                    discountedPrice *= 0.2;
                }

                if (didApplyDiscount) {
                    break;
                }
            }

            if (discountedPrice == book.bookPrice) {
                totalPrice += bookAndQty.qty * book.bookPrice;
            } else {
                totalPrice += bookAndQty.qty * (book.bookPrice - discountedPrice);
            }
        }

        scanner.close();

        System.out.println("=== YOU ORDERED ===\n");

        for (BookAndQty bookAndQty : bookAndQties) {
            bookAndQty.book.displayInfo();
            System.out.println("Quantity: " + bookAndQty.qty);
            System.out.println("Price: " + bookAndQty.book.bookPrice + "\n");
        }

        System.out.println("\nTOTAL: " + this.totalPrice);
    }

    private Optional<Book> getBookWithTitle(String title) {
        for (Supplier supplier : suppliers) {
            if (supplier.doesBookExistWithTitle(title)) {
                return supplier.getBookWithTitle(title);
            }
        }

        return Optional.empty();
    }
}

class BookAndQty {
    public int qty;
    public Book book;

    public BookAndQty(int qty, Book book) {
        this.qty = qty;
        this.book = book;
    }
}
