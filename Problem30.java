
/**
 * Problem3 [30 pts]
 * Let's design a class "Book", it has title, author, publishing date and price.
 * - You should provide constructors, setters and getters, equals() and
 * toString().
 * Then, design a Bookstore class. Bookstore has name, address, and a list of
 * books.
 * For simplicity, assume 1000 as the maximum number of books a bookstore can
 * store.
 * Design following methods:
 * > The bookstore tries to get more number of copies of one book, this method
 * takes in two parameters: the book and the amount of copies to import
 * > The bookstore can search with title to find the book in store or not,
 * return type: boolean
 * > Removing all the copies of one specific book from list
 * > Get the amount of copies of specific book title, return type: int
 * > Get and print all the books in the book list
 */
class Bookstore {
    private String name;
    private String address;
    private Book[] books;

    public Bookstore(String name, String address, Book[] books) {
        this.name = name;
        this.address = address;
        if (books.length > 1000) {
            System.err.println("the maximum number of books is 1000！");
            System.exit(0);
        }
        this.books = books;
    }

    public Bookstore makeCopyOfBook(Book A, int k) {
        int n = this.books.length;
        int num = Math.min(1000 - n, k);
        Book[] newbooks = new Book[n + num];
        for (int i = 0; i < n; i++) {
            newbooks[i] = this.books[i];
        }

        for (int j = n; j < n + num; j++) {
            newbooks[j] = A;
        }

        Bookstore newstore = new Bookstore(this.name, this.address, newbooks);
        return newstore;

    }

    public boolean searchBookByTitle(String title) {
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i].getTitle().equals(title) == true) {
                return true;
            }
        }
        return false;
    }

    public int getNumOfCopyBook(String title) {
        int count = -1;
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i].getTitle().equals(title)) {
                count++;
            }
        }
        if (count < 0) {
            return 0;
        }
        return count;
    }

    public void printAllbooks() {
        for (int i = 0; i < this.books.length; i++) {
            System.out.println(this.books[i].toString());
        }
    }

    public String toString() {
        StringBuilder bookstring = new StringBuilder();
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] != null) {
                bookstring.append(i + " " + this.books[i].toString() + "; ");
            }
        }
        return "***" + this.name + "-" + this.address + "***: " + bookstring.toString();
    }

    public static void main(String[] args) {
        Book a = new Book("Gone with wind", "L .T", "01/02/2010", 22.58);
        Book b = new Book("Came with me", "J .L", "11/12/2020", 32.58);
        Book c = new Book("Gone with you", "L .T", "05/02/2010", 23.58);
        Book[] aabBooks = new Book[3];
        aabBooks[0] = a;
        aabBooks[1] = b;
        aabBooks[2] = c;
        Bookstore jingstore = new Bookstore("Jingstore", "121 San Jose Ave", aabBooks);
        jingstore.printAllbooks();
        System.out.println(jingstore.searchBookByTitle("Gone with wind"));
        System.out.println(jingstore.searchBookByTitle("Gone with me"));

        Bookstore jingstorecopy = jingstore.makeCopyOfBook(a, 5);
        System.out.println("copy a:");
        jingstorecopy.printAllbooks();

        System.out.println("To string: " + jingstore);

        System.out.println("get Num Of CopyBook:" + jingstorecopy.getNumOfCopyBook(a.getTitle()));
    }

}

class Book {
    private String title;
    private String author;
    private String publishing_date;
    private double price;

    public Book(String title, String author, String publishing_date, double price) {
        this.title = title;
        this.author = author;
        this.publishing_date = publishing_date;
        this.price = price;
    }

    public Book() {
        this.title = null;
        this.author = null;
        this.publishing_date = null;
        this.price = 0;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing_date() {
        return this.publishing_date;
    }

    public void setPublishing_date(String publishing_date) {
        this.publishing_date = publishing_date;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean equals(Book another) {
        return this.title.equals(another.title) && this.author.equals(another.author)
                && this.publishing_date.equals(another.publishing_date) && this.price == another.price;
    }

    public String toString() {
        return "<<" + this.title + ">> " + this.author + "  " + this.publishing_date + "  $" + this.price;
    }

    public static void main(String[] args) {
        Book a = new Book("Gone with wind", "L .T", "01/02/2010", 22.58);
        System.out.println(a);
        Book b = new Book();
        b.setAuthor("L .T");
        b.setTitle("Gone with wind");
        b.setPrice(22.58);
        b.setPublishing_date("01/02/2010");
        System.out.println(b.equals(a));

    }
}
