/*
 * Copyright (C) 2015 Aparna Mahadev
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
 */
 /**
  * In this project, we read a file of that contains
  * movie information possibly in a home.
  * Each line in the file corresponds to one movie. Each line contains
  * the movie name, rating, year released and an integer denoting
  * whether the movie is in a video cassette format or a DVD format.
  * We read each line from the file, create a movie object from it.
  * We create an array to store the movie objects.
  *
  * Once the array is created, we manipulate the array by adding,
  * removing and searching for movies.
  *
  * Concepts Used: Single-dimensional arrays, text files,
  * array manipulation.
  *
  * @author Aparna Mahadev
  * @version March 2015
  */
 // Known Bugs: None
import java.io.*;
import java.util.Scanner;

public class Project3 {
    public static void main(String args[]) throws IOException {

       Scanner inFile = new Scanner (new FileReader("movieList.txt"));
       Scanner keyboard = new Scanner (System.in);
       
       MovieCollection myCollection = new MovieCollection(20);
       String s;
       Movie m;
       int choice;
       Movie [] DVDList, cassetteList;

       while (inFile.hasNextLine() ) {
		  m = new Movie(inFile.nextLine() );
	  	  myCollection.add(m);
       }
       // at this point all the movie objects are created and added to the collection.

	   // now close the input file since it is no longer needed.
	   inFile.close();

	   // let us process the movie collection
	   do {
	       System.out.println("\n1. Search for  movie");
	       System.out.println("2. Delete a movie");
	       System.out.println("3. Get the list of movies in the DVD format");
	       System.out.println("4. Get the list of movies in the VHS format");
	       System.out.println("5. Get the count of movies in the entire collection");
	       System.out.println("6. Quit the program");
	       
	       System.out.print("Please enter your choice: ");
	       choice = Integer.parseInt(keyboard.nextLine() );
	       
	       switch (choice) {
	           case 1:
	              System.out.print("Please enter the title of the movie to search: ");
	              s = keyboard.nextLine();
	              m = myCollection.search(s);
	              if (m == null) 
	                 System.out.println("There is no movie with title " + s + " in the collection");
	              else 
	                 System.out.println("Here is the complete information on the movie " + "\n\t" + m);
	              break;
	           case 2:
	              System.out.print("Please enter the title of the movie to delete: ");
	              s = keyboard.nextLine();
	              boolean flag = myCollection.delete(s);
	              if (flag) 
	                  System.out.println("The movie with title " + s +" is sucessfully deleted from the collection");
	              else    
	                 System.out.println("There is no movie with title " + s + " in the collection");
	              break;
	           case 3:
	              DVDList = myCollection.getDVDList();
	              System.out.println("There are " + DVDList.length
	                      + " movies in DVD format");
	              System.out.println("Here is the list:\n");
	              for (int i = 0; i < DVDList.length; i++)
		               System.out.println( (i+1) + ": " + DVDList[i].getTitle() );
		          break;
		       case 4:
		          cassetteList = myCollection.getCassetteList();
	              System.out.println("There are " + cassetteList.length
	                      + " movies in VHS format");
	              System.out.println("Here is the list:\n");
	              for (int i = 0; i < cassetteList.length; i++)
		               System.out.println((i+1) + ": " + cassetteList[i].getTitle() );
		          break;
		       case 5:
		          System.out.println("There are " + myCollection.getCount()
	                      + " movies in the collection\n");
	              break;
	           case 6:
	              System.out.println("Thanks for using my program. Have a nice day!");
	              break;
	           default:
	              System.out.println("Illegal choice.  Please enter again");
	       }
	   } while (choice != 6);
   }
}