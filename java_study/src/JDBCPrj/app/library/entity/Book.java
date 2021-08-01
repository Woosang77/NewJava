package JDBCPrj.app.library.entity;

public class Book {

    private String title;
    private String writer;
    private String clazz;
    private int id;
    private String rentable;

    public Book(int id) {
        this.id = id;
    }

    public Book(String title, String writer, String clazz) {
        this.title = title;
        this.writer = writer;
        this.clazz = clazz;
    }

    public String getTitle() {
        return title;
    }

    public Book(String title, String writer, String clazz, int id, String rentable) {
        this.title = title;
        this.writer = writer;
        this.clazz = clazz;
        this.id = id;
        this.rentable = rentable;
    }

    public String getWriter() {
        return writer;
    }

    public String getClazz() {
        return clazz;
    }

    public int getId() {
        return id;
    }

    public String getRentable() {
        return rentable;
    }

    public void setRentable(String rentable) {
        this.rentable = rentable;
    }
}
