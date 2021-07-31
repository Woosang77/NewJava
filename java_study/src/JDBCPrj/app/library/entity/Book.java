package JDBCPrj.app.library.entity;

import java.util.Date;

public class Book {

    private String title;
    private String writer;
    private String clazz;
    private int id;
    private String rentable;

    public Book() {

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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRentable() {
        return rentable;
    }

    public void setRentable(String rentable) {
        this.rentable = rentable;
    }
}
