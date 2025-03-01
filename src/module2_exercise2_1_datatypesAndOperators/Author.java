package module2_exercise2_1_datatypesAndOperators;

public class Author {
    protected String bookAuthorLastName;
    protected String bookAuthorFirstName;

    Author(String firstName, String lastName) {
        this.bookAuthorFirstName = firstName;
        this.bookAuthorLastName = lastName;
    }

    String getBookAuthorFirstName() {
        return this.bookAuthorFirstName;
    }

    String getBookAuthorLastName() {
        return this.bookAuthorLastName;
    }

    boolean eq(Author author) {
        return this.bookAuthorFirstName.equals(author.bookAuthorFirstName) && this.bookAuthorLastName.equals(author.bookAuthorLastName);
    }
}
