import java.lang.String;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * 
 * 
 * @author Andon Shkurti
 * @version Project 3
 */
public class MovieCollection {
    private int count = 0; 
    private Movie[] MovieCollection;
    /**    
      * Constructor for objects of class MovieCollection
      * Holds 10 movie Objects
      */
     public MovieCollection()  {
        
        ArrayList <MovieCollection> array = new ArrayList <MovieCollection> (10);
    }

    /**
      * Overload Constructor. Assumes that size is non negative
      * 
      */
     public MovieCollection(int size) {
         MovieCollection = new Movie[size];
         count = 0;
    }

    /**
     * Adds a movie to the collection
     * It checks whether there is enough space to hold the movie
     * If not, a new collection with size = (double the original size + 1) 
     * is created; the old collection is copied into the new collection
     * and then the movie is added to the collection.
     * @param aMovie The movie that is to be added to the collection
     */
    public void add(Movie aMovie) {
        if (count >= MovieCollection.length)
            MovieCollection = Arrays.copyOf(MovieCollection, 2* count + 1);
            MovieCollection[count++] = aMovie; 
        }
    

    /**
     * Deletes the movie from the collection with the given title if the 
     * movie is found in the collection. 
     * If the movie is not in the collection, then this 
     * method has no effect on the collection.
     * @param aTitle is the name of the movie to be deleted from the collection
     * @return true if the movie with the given title is successfully deleted; 
     * false if there is no movie with the given title in the collection
     */
    public boolean delete(String aTitle) {
            for(int i = 0; i < count; i++) {
                if(aTitle.toUpperCase().equals(MovieCollection[i].getTitle().toUpperCase())) {
                    MovieCollection[i] = null;
                    count--;
                    return true;
                }
            }
            return false;
    }

    /**
     * Returns an array of Movie objects that are in the Cassette format
     * @return an array of Movie objects in the cassette format
     */
    public Movie[] getCassetteList() {
            int cassetteCount = 0;
            Movie[] cassetteList = new Movie[count];
            for(int i = 0; i < count; i++) {
                if((MovieCollection[i].getFormat() == 1)) {
                    cassetteList[i] = MovieCollection[i];
                    cassetteList[cassetteCount++] = MovieCollection[i];
                }
            }
            return Arrays.copyOf(MovieCollection, cassetteCount);
    }

    /**
     * get the count of movies in the collection
     * @return the number of Movies in the entire collection
     */
    public int getCount() {
       return count;
    }
    
    /**
     * returns an array of Movie objects that are in the DVD format
     * @return an array of Movie objects in the DVD format
     */
    public  Movie[] getDVDList() {
            int dvdCount = 0;
            Movie[] DVDList = new Movie[count];
            for(int i = 0; i < count; i++) {
                if(MovieCollection[i].getFormat() == 2)
                    DVDList[i] = MovieCollection[i];
                    DVDList[dvdCount++] = MovieCollection[i];
                }
            return Arrays.copyOf(MovieCollection, count);
    }

    /**
     * searches the collection for a particular movie title. 
     * Returns the movie object if movie is found. Otherwise null is returned.
     * @param aTitle  of the movie to be searched
     * @return the movie object with the given title if the movie is found in the collection; 
     * returns null if there is no movie in the collection with the given title
     */
    public  Movie search(String aTitle) {
            Movie m = null;
            for (int i = 0; i < count; i++) {
             if (aTitle.equalsIgnoreCase(MovieCollection[i].getTitle())){
                    m = MovieCollection[i];
              } 
            } 
            return m; 
    }
}