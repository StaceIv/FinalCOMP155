/**      
 * AUTHOR:  			Stacey Ivanovic
 *
 * CONTACT INFORMATION: stacey.ivanovic007@gmail.com
 *
 * CREATION DATE:  		April 17th, 2015 
 *
 * CLASS PURPOSE:  		This is a parent class to Book.java
 *						and Magazine.java. It contains all the methods
 *						and variables that are common to both of
 *						the children classes. The child classes will
 *						inherit everything in this class. This class,
 *						however, sees nothing that is in either of
 *						the child classes.
 *	
 * CLASS INVARIANT:  	Availability; every item has an availability
 *						which is set to either true or false.
 *						Title; every item must have a title.
 *						Type; every item can only be either a book or
 *						a magazine.
 */ 

  
import java.io.*;
import java.lang.*;
import java.util.*;

public class Item {
	
	public String title;
	boolean avail;
	
	

    /*
     * TASK:          This helps when finding out
     *				  if the item in question is 
     *				  a book or a magazine. This is 
     *				  important because Book() and
     *				  Magazine() take different 
     *				  parameters. Items can only be 
     *				  assigned a type that is in the
     *				  enum. In this case, it can only be
     *				  a book or a magazine.
     *  
     * PRECONDITION:  There must be items in the library.
     *
     * MODIFIES:      One of these types is assigned to each
     *				  element of the items arraylist.
     *
     * POSTCONDITION: Returns either BOOK or MAGAZINE
     *				  depending on the item.
     */

    public enum ItemTypes {
    	BOOK,
    	MAGAZINE
    }
    

    public ItemTypes itemType; //This must be declared after the enum above it.
    						   //Otherwise it will not recognize the type.
    
   	/*
     * TASK:          This assigns each item in the library
     *				  to be available initially. Then that
     *				  can change depending on what the 
     *				  user does.
     *
     * PRECONDITION:  There must be items in the library
     *				  for this to be able to assign their
     *				  availability = true.
     *
     * MODIFIES:      Makes the items availability true.
     *
     * POSTCONDITION: Item's availability = true. That is
     *				  the default. When an item is created,
     *				  it is initially true.
     */
    public Item() {
    	avail = true;
    }
    
    

	/*
     * TASK:          This tells us whether the item
     *				  is a book or a magazine.
     *
     * PRECONDITION:  There must be an item for which
     *				  we need to get a type.
     *
     * MODIFIES:      The item's type.
     *
     * POSTCONDITION: The return value tells us if
     *				  a specific item in the arraylist
     *				  is a book or a magazine.
     *
     */
    public ItemTypes getItemType() {
    	return itemType;
    }    
    
    
    	
    /*
     * TASK:          This gets a title for an item.
     *				  This is important for when the
     *				  user chooses to add an item.
     *				  The reason this is in this class
     *				  is because unlike author or year, 
     *				  this is common to both child classes.
     *
     * PRECONDITION:  There must be an item for which we need
     *				  to get a title.
     *
     * MODIFIES:      Item's title.
     *
     * POSTCONDITION: This returns the title of the item.
     */
    public String getTitle(){
    	return title;
    }
    
    
    
    /*
     * TASK:          This sets an items title. The title is
     *				  set to whatever was 'got' using the 
     *				  getTitle method.
     *
     * PRECONDITION:  There must be an item for which we need
     *				  to set a title.
     *
     * MODIFIES:      The title of an item.
     *
     * POSTCONDITION: The item will have this title assigned
     *				  to it.
     *
     */
    public void setTitle(String ttl){
    	title = ttl;
    }
    
    
    
   	/*
     * TASK:          This will get the availability
     *				  of the item. It is called when
     *				  the user is checking an item out,
     *				  or returning an item. 
     *
     * PRECONDITION:  There must be items in the library.
     *
     * MODIFIES:      The items availability.
     *
     * POSTCONDITION: Returns true or fals to signify 
     *				  whether or not the item is available or
     *				  if it has already been checked out.
     */
    public boolean getAvailability(){
    	return avail;
    }
    
    
    
    /*
     * TASK:          This is accessor which sets the items
     *				  availability to true or false.
     *
     * PRECONDITION:  There needs to be an item in order for
     *				  the item to have an availability.
     *
     * MODIFIES:      The items availability.
     *
     * POSTCONDITION: The items availability is set to
     *				  true or false.
     */
    public void setAvailability(boolean v){
    	avail = v;
    }
    
    
    
    /*
     * TASK:          This is the toString method which
     *				  will be overriden by the toString
     *				  methods in each of the children.
     *				  This method is important for when
     *				  the display function is called.
     *				  Depending on the item type, either
     *				  the toString in Book or the toString
     *				  in Magazine will be called to display
     *				  the items information.
     *
     * PRECONDITION:  There must be an item for this method
     *				  to be called.
     *
     * MODIFIES:      How the item is displayed.
     *
     * POSTCONDITION: This will return the item and all the 
     *				  information that comes with it. This 
     *				  method will be overriden by the toString
     *				  in one of the child classes. 
     */
    public String toString(){
    	return "Items toString";
    }
}