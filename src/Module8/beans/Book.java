package beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;


public class Book implements Serializable, Comparable {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int pages;

    /**
     * Default constructor
     */
    public Book() {
        this.isbn = "";
        this.title = "";
        this.author = "";
        this.publisher = "";
        this.pages = 0;
    }

    /**
     * Non-default constructor
     *
     * @param isbn
     * @param title
     * @param author
     * @param publisher
     * @param pages
     */
    public Book(final String isbn, final String title, final String author, final String publisher, final int pages) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pages=" + pages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, publisher, pages);
    }

    public int compareTo(Book book) {
        return this.title.compareTo(book.title);
    }

    @Override
    public int compareTo(Object o) {
        Book book =  (Book) o;
        return this.title.compareTo(book.title);
    }

}


class BookPageComparator implements Comparator<Book>{

    @Override
    public int compare(Book book1, Book book2) {
        return book1.getPages() - book2.getPages();
    }
}
//final String isbn, final String title, final String author, final String publisher, final int pages
class Main{
    public static void main(String[] args) {
        Book[] bookList = {
                new Book("123456","First one", "Unknown1", "Texas", 400),
                new Book("123467","Second one", "Unknown2", "US-One", 300),
                new Book("123467","Second one", "Unknown2", "Japan-One", 500)
        };

        // Using Comparator to sort the Book Array
        BookPageComparator bookPageComparator = new BookPageComparator();
        Arrays.sort(bookList);
        Arrays.sort(bookList, bookPageComparator);
        System.out.println(Arrays.toString(bookList));

        // Using Lambda ad compareTo to sort the array
        Arrays.sort(bookList,(s1,s2) -> {
            return s1.getPublisher().compareTo(s2.getPublisher());
        });

        System.out.println(Arrays.toString(bookList));
    }
}