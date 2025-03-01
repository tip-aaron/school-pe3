package module2_exercise2_1_datatypesAndOperators;

import java.util.Optional;

public class Supplier {
    private final Book[] books;

    private final int supplierId;
    private final String supplierName;
    private final String supplierAddress;
    private final long supplierTelNum;

    public Supplier(int supplierId, String supplierName, String supplierAddress, long supplierTelNum, Book[] books) {
        this.books = books;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierTelNum = supplierTelNum;
    }

    public int getSupplierId() {
        return this.supplierId;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public String getSupplierAddress() {
        return this.supplierAddress;
    }

    public long getSupplierTelNum() {
        return this.supplierTelNum;
    }

    public Optional<Book> getBookWithTitle(String bookTitle) {
        for (Book book : this.books) {
            if (book.bookTitle.equals(bookTitle)) {
                return Optional.of(book);
            }
        }

        return Optional.empty();
    }

    public boolean doesBookExistWithTitle(String bookTitle) {
        for (Book book : this.books) {
            if (book.bookTitle.equals(bookTitle)) {
                return true;
            }
        }

        return false;
    }
}
