/**      
 * AUTHOR:  			Stacey Ivanovic
 *
 * CONTACT INFORMATION: stacey.ivanovic007@gmail.com
 *
 * CREATION DATE:  		April 17th, 2015
 *
 * CLASS PURPOSE:       This class contains all things
 *						specific to magazines, such as
 *						a magazines year. It also assigns
 *						MAGAZINE as the itemType of a
 *						magazine object. The toString in this
 *						class override the one in the parent
 *						(Items) class so that it displays all 
 *						the magazines information.
 *	
 * CLASS INVARIANT:     Any object of this class will always
 *						be assigned an itemType of MAGAZINE.
 *
 */ 

 
import java.io.*;
import java.lang.*;
import java.util.*;

public class Magazine extends Item {

	private int year;
	
	/*
     * TASK:          Assigned MAGAZINE as itemType
     *				  of a magazine object.
     *
     * PRECONDITION:  A magazine object need to be 
     *				  created.
     *
     * MODIFIES:      The itemType of a magazine object.
     *
     * POSTCONDITION: Magazine object will have type MAGAZINE.
     */
    Magazine() {
    	itemType = ItemTypes.MAGAZINE;
    }
    
    /*
     * TASK:          This is used in the add function to
     *				  assign a title and year to the
     *				  magazine object.
     *
     * PRECONDITION:  A magazine object needs to be created.
     *
     * MODIFIES:      The magazine object.
     *
     * POSTCONDITION: Accepts title and year as parameters,
     *				  then we assign that year and title to
     *				  that magazine object.
     */
    Magazine(String ttl, int y) {
    	itemType = ItemTypes.MAGAZINE;
    	title = ttl;
    	year = y;
    }
    
    /*
     * TASK:          To print a magazine objects
     *				  information.
     *
     * PRECONDITION:  There must be a magazine object.
     *
     * MODIFIES:      Magazine items.
     *
     * POSTCONDITION: This returns a magazine and all
     *				  its information.
     */
    public String toString(){
    	
    	return "Title: " + title + ", Published: " + year + ", Availability: " + avail + ", Type: MAGAZINE\n"; 
    }
    
    /*
     * TASK:          This is the getter for the 
     *				  year the magazine was first
     *				  published.
     *
     * PRECONDITION:  There must be a magazine object.
     *
     * MODIFIES:      A magazines year.
     *
     * POSTCONDITION: The year that belong to that
     *				  magazine object.
     */
    public int getYear(){
    	return year;	
    }
    
    /*
     * TASK:          This is the setter for the
     *				  year of the magaine item.
     *
     * PRECONDITION:  There must be a magazine object
     *				  which needs a year assigned to it.
     *
     * MODIFIES:      A magazines year.
     *
     * POSTCONDITION: A specific magazine object now has
     *				  this year.
     */
    public void setYear(int y){
    	year = y;
    }
    
}