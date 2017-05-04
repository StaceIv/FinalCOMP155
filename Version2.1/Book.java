/**      
 * AUTHOR:  			Stacey Ivanovic
 *
 * CONTACT INFORMATION: stacey.ivanovic007@gmail.com
 *
 * CREATION DATE:  		April 17th, 2015
 *
 * CLASS PURPOSE:  		This class keeps track of the things that
 *						are specific to book. Things like author.
 *						The toString in this class overrides the
 *						one in the parent (Items) class and prints
 *						the book items information
 *						
 * CLASS INVARIANT:     Objects of this clas will always have
 *						an itemType of BOOK.
 *
 */ 


import java.util.Scanner;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Book extends Item {
	
	public String author;
   
    /*
     * TASK:          This constructor helps
     *				  give a book object a BOOK 
     *				  itemType. 
     *
     * PRECONDITION:  A book object needs to be created.
     *
     * MODIFIES:      Assigned Book as itemType to 
     *				  book object.
     *
     * POSTCONDITION: Will assign type BOOK to Book object.
     */

	Book(){
    	itemType = ItemTypes.BOOK;
	}
	
	/*
     * TASK:          This makes the item type	
     *				  BOOK, and takes the title
     *				  and author as parameters.
     *				  This is used in the add 
     *				  function to assign a title
     *				  and author to the book item.
     *  
     * PRECONDITION:  A book object needs to be created.
     *
     * MODIFIES:      A book object.
     *
     * POSTCONDITION: Accepts title and author as 
     *				  parameters. We then use these
     *				  to assign an author and title to 
     *				  a book object.
     */
	
	Book(String t, String a) {
    	itemType = ItemTypes.BOOK;
    	title = t;
    	author = a;
    }
	
    
    /*
     * TASK:          Gets the authors name
     *				  for a particular book.
     *
     * PRECONDITION:  There must be a book item
     *				  and an ask for the books 
     *				  author.
     *
     * MODIFIES:      The books author.
     *
     * POSTCONDITION: Returns the first and 
     *				  last name of the author.
     */
    
    public String getAuthor(){

    	return author;
    	
    }
    
    /*
     * TASK:          Sets the authors name.
     *				  This is used when a new
     *				  item is being added to the
     *				  arraylist. The user is asked
     *				  for the authors name, and
     *				  this method is used to 'get'
     *				  it.
     *
     * PRECONDITION:  There must be a book to assign
     *				  this author to. Can't have an
     *				  author without a book.
     *
     * MODIFIES:      The books author.
     *
     * POSTCONDITION: The book item will have this
     *				  author assigned to it.
     */
    
	public void setAuthor(String a){ 	
    	author = a;
    }
    
    /*
     * TASK:          Returns the book item
     *				  and its information.
     *				  This is important to the
     *				  displayAll method, or 
     *				  whenever we need all the
     *				  information on a specific
     *				  book item.
     *
     * PRECONDITION:  A Book object must exist.
     *
     * MODIFIES:      Book items.
     *
     * POSTCONDITION: Returns the book information
     *				  structured in this was.
     */
	
	public String toString(){
    	
    	return "Title: " + title + ", Author: " + author + ", Availability: " + avail + ", Type: BOOK\n"; 
    }

}
