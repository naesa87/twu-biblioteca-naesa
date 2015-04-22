package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.StringHelper;

public class BookCollection extends LibraryCollection<Book> {

    private static final String LIBRARY_TITLE = "LIST OF BOOKS";

    public BookCollection(){
        super();
        loadTempBookData(); //since there is no db yet
    }

    @Override
    public String getLibraryCollection(boolean availableFlag) {
        StringBuilder listOfBooksString = new StringBuilder();
        String LS = System.getProperty("line.separator");
        listOfBooksString.append(StringHelper.horizontalLine());
        listOfBooksString.append(LS);
        listOfBooksString.append(LIBRARY_TITLE);
        listOfBooksString.append(LS);
        listOfBooksString.append(String.format("%-60s %-30s  %15s", "NAME", "AUTHOR", "YEAR"));
        listOfBooksString.append(LS);
        for (Book book: collection){
            if (book.isCheckedOut()!=availableFlag){
                listOfBooksString.append(
                        String.format("%-60s %-30s  %15d", book.name(), book.author(), book.year()));
                listOfBooksString.append(LS);
            }
        }
        listOfBooksString.append(StringHelper.horizontalLine());
        return listOfBooksString.toString();
    }

    /*temporary loading of book data while no database is in place and no addBook method is required */
    private void loadTempBookData(){
        collection.add(new Book("The Lord of the Rings","J.R.R. Tolkien",1954));
        collection.add(new Book("The Little Prince","Antoine de Saint-Exupéry",1943));
        collection.add(new Book("Harry Potter and the Philosopher's Stone","J.K. Rowling",1997, "123-1234"));
        collection.add(new Book("The Catcher in the Rye","J.D. Salinger",1951, "123-1235"));
        collection.add(new Book("The Hunger Games","Suzanne Collins",2008));
    }
}
