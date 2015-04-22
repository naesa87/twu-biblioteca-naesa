package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.StringHelper;

public class MovieCollection extends LibraryCollection<Movie>{

    private static final String LIBRARY_TITLE = "LIST OF MOVIES";

    public MovieCollection(){
        super();
        loadTempMovieData(); //since there is no db yet
    }

    @Override
    public String getLibraryCollection(boolean availableFlag) {
        StringBuilder listOfBooksString = new StringBuilder();
        String LS = System.getProperty("line.separator");
        listOfBooksString.append(StringHelper.horizontalLine());
        listOfBooksString.append(LS);
        listOfBooksString.append(LIBRARY_TITLE);
        listOfBooksString.append(LS);
        listOfBooksString.append(String.format("%-40s %-30s %-15s %10s", "NAME", "AUTHOR", "RATING", "YEAR"));
        listOfBooksString.append(LS);
        for (Movie movie: collection){
            if (movie.isCheckedOut()!=availableFlag){
                listOfBooksString.append(
                        String.format("%-40s %-30s %-15s %10s", movie.getName(), movie.getDirector(), movie.getRating(), movie.getYear()));
                listOfBooksString.append(LS);
            }
        }
        listOfBooksString.append(StringHelper.horizontalLine());
        return listOfBooksString.toString();
    }

    /*temporary loading of book data while no database is in place and no addBook method is required */
    private void loadTempMovieData(){
        collection.add(new Movie("The Godfather","Francis Ford Coppola",1972,10, "123-1234"));
        collection.add(new Movie("Eternal Sunshine of the Spotless Mind","Michel Gondry",2004,9));
        collection.add(new Movie("Fight Club","David Fincher",1999, 8));
        collection.add(new Movie("The Breakfast Club","John Hughes",1985, 10, "123-1235"));
        collection.add(new Movie("Mean Girls","Mark Waters",2004,9));
    }
}
