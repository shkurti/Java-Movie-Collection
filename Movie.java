/**
 * Abstraction of a real-world entity Movie.  Each Movie has a title,
 * a system assigned id number, rating, year it was released and
 * has information on whether it is a video Cassette or a DVD.
 * A value of 1 for format denotes that the movie is in a
 * video Cassette format and a value of 2 denotes that the movie
 * is in a DVD format.
 */

public class Movie {
    private static int count = 0;

    private int id;
    private String title;
    private String rating;
    private int yearReleased;
    private int format;

    /** Creates a Movie object from a String by parsing it
     * and extracting the title, rating, yearReleased and format
     * fields.  Each movie is assigned an integer ID
     * automatically by the system.
     *
     * @param  s a line which represents a Movie object
     */

    public Movie (String s) {
		 id = ++count;
		 title = s.substring(0,46).trim();
		 rating = s.substring(50,56).trim();
		 yearReleased = Integer.parseInt(s.substring(58,62));
		 format = Integer.parseInt(s.substring(67,68));
    }

    /** Sets the title of the movie - Mutator method
     *  @param aTitle title of the movie
     */
    public void setTitle(String aTitle) {
        this.title = aTitle;
    }

    /**
     * Sets the year the movie was released - Mutator method
     *
     * @param yearReleased year the movie was released
     */
    public void setYear(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    /** Sets the rating of the movie - Mutator method
     *
     *  @param rating of the movie - NR, PG-13, PG, R, G
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /** gets the rating of the movie as assigned by MPAA - Accessor method
     *
     * @return rating of the movie as assinged by MPAA
     */
	public String getRating() {
	    return rating;
    }

    /** gets the name of the movie - Accessor method
     *
     * @return the title of the movie
     */
    public String getTitle() {
		return title;
    }

    /**
     * gets the format of the movie - Accessor method
     * @return the format of the movie.  1 represents a video
     * cassette format and 2 represents DVD format
     */
	public int getFormat() {
		return format;
    }

    /** gets the year the movie was released - Accessor method
     *
     * @return the year the movie was releassed
     */
    public int getYearReleased() {
		return yearReleased;
    }

    /**
     * returns the system assigned ID of the movie - Accessor method
     *
     * @return the id assigned to the movie
     */
    public int getID() {
		return id;
    }

    /**
     * returns a String representation of the Movie object
     *
     * @return String representation of the Movie object
     */
    public String toString() {
        String str = "";
        str += "ID: " + id + "   ";
        str += "Title: " + title + "   ";
        str += "Year Released: " + yearReleased + "   ";
        str += "Rating: " + rating + "   ";
        if (format == 1) str += "Format: Video Cassette" + "   ";
        else str += "Format: DVD" + "\n";
        return str;
     }
}