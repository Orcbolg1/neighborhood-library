package com.pluralsight;

public class Book {

    // Attributes in the book class
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // empty constructor with default values
    public Book() {
        this.id = 0;
        this.isbn = " ";
        this.title = " ";
        this.isCheckedOut = false;
        this.checkedOutTo = " ";
    }

    //Constructor that takes all attributes
    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    // Methods
    // If the book is checked out method
    public void checkOut(String checkedOutTo) {
        if (isCheckedOut) {
            System.out.println("This book is already checked out.");
        } else {
            System.out.println("This books is checked out to: " + checkedOutTo);
            this.checkedOutTo = checkedOutTo;
            isCheckedOut = true;
        }
    }
        // If the book is Available method
    public void checkIn() {
        if (!isCheckedOut) {
                System.out.println("This Book is Available.");
        } else {
                System.out.println();
                checkedOutTo = " ";
                isCheckedOut = false;
            }
        }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                ", checkedOutTo='" + checkedOutTo + '\'' +
                '}';
    }
}
