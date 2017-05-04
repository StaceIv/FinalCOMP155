/*   
 * AUTHOR:  				Stacey Ivanovic
 *
 * CONTACT INFORMATION:		stacey.ivanovic007@gmail.com
 * 
 * CREATION DATE:     		April 17th, 2015
 *											
 * CLASS PURPOSE:  			This class contains all the methods required 
 *							for the library functions. These methods will
 *							be called from the Menu class depending on what
 *							the user chooses to input.
 *
 *							Most of the parts asking for user input will
 *							come from the Menu.java, however, there
 *							are exceptions where we have to ask for user 
 *							input in the method.
 *	
 * CLASS INVARIANT:  		The Items ArrayList. It can be empty, or full,
 *							but it must exist, since all the methods 
 *							affect or change it in some way.
 */ 

import java.io.*;
import java.lang.*;
import java.util.*;

public class Controller {

	 //This arrayList of Item will hold all the Item objects
	 //which are the library items.
   public ArrayList<Item> items = new ArrayList<Item>();
   


    /*
     * TASK:          This will display all the items in 
     *                the library. It will go through the 
     *                items arraylist and find out if each 
     *                element is a book or a magazine. Then 
     *                two seperate lists will be displayed.
     *				  One for books, one for magazines.
     *
     * PRECONDITION:  There has to be an items class since
     *				  an Item object (currentItem) is used.
     *
     * MODIFIES:      The arrayList items.
     *
     * POSTCONDITION: After this, all the items will be 
     *				  printed to screen under the appropriate
     *				  category.
     */
     
   public void displayAll() {
   	 Item currentItem;
   	 
   	 System.out.println("-----BOOKS-----");
   	 for(int i=0; i<items.size(); i++) {
   	   currentItem = items.get(i);
   	 	  //This next line checks if the current item is a book.
   	   if(currentItem.getItemType() == Item.ItemTypes.BOOK) 
   	     System.out.println(currentItem.toString());
   	 }
   	 	
   	 System.out.println("-----MAGAZINES-----");
   	 for(int i=0; i<items.size(); i++) {
   	   currentItem = items.get(i);
   	 	  //This next line checks if the current item is a magazine.
   	   if(currentItem.getItemType() == Item.ItemTypes.MAGAZINE)
   	     System.out.println(currentItem.toString());
   	 }

   }
   
   

   	/*
     * TASK:          This alows the user to return an item
     *				  to the library. If the item is already 
     * 				  in the library, the user will see an
     * 				  error message.
     *
     * PRECONDITION:  There must be items in the library,
     *				  and the item the user is trying 
     *				  to return must be checked out,
     *			      or they'll see an error message.
     *
     * MODIFIES:      The items arrayList. The items
     *				  availability will be changed 
     *				  from false to true. 
     *
     * POSTCONDITION: If getAvailability was previously
     *				  false, the user has 'returned'
     *				  the item to the library and 
     *				  getAvailability is now true, which
     *				  means the item is available.
     */
   public void checkIn(String title){
   	
   	 Iterator<Item> i = items.iterator();
   	 Item current = new Item();
   	
   	 
   	 while(i.hasNext()){
   	   current = i.next();
   	   
   	   if(title.compareTo(current.getTitle()) == 0) {
   	     	
	     System.out.print("Is this the item you are returning: " + current.toString());
	     System.out.println("(y/n)?");
		 Scanner sc = new Scanner(System.in);
		 String result = sc.next().toUpperCase();
		 
         if(result.charAt(0) == 'Y'){
         	
           if(current.getAvailability() == true){
           	 System.out.println("This item has is already in the library.");
           	 System.out.println();
      
           }else if(current.getAvailability() == false){
           	 current.setAvailability(true);
	         System.out.println("You have returned " + title + " to the library.");
           }
           
         }
   	   }

    }
    
  }

 

    /*
     * TASK:          Allows the user to check an
     *				  item out of the library.
     *
     * PRECONDITION:  There must be items in the 
     *				  library. If not, the user will
     *				  see an error message.
     *
     * MODIFIES:      This modifies the items availability.
     *
     * POSTCONDITION: If getAvailability was previously 
     *				  true, it is false afterwards. This
     *				  means that particular library item	
     *				  has been checked out.
     */
   public void checkOut(String title){
     Iterator<Item> i = items.iterator();
   	 Item current = new Item();
   	 
   	 while(i.hasNext()){
   	   current = i.next();
   	   if(title.compareTo(current.getTitle()) == 0) {
	     System.out.print("Is this the item you are checking out: " + current.toString());
	     System.out.println("(y/n)?");
		 Scanner sc = new Scanner(System.in);
		 String result = sc.next().toUpperCase();
		 
         if(result.charAt(0) == 'Y'){
         	
           if(current.getAvailability() == false){
           	 System.out.println("This item has is already checked out of the library.");
           	 System.out.println();
      
           }else if(current.getAvailability() == true){
           	 current.setAvailability(false);
	         System.out.println("You have checked " + title + " out of the library.");
           }
           
         }
   	   }
   	 }

   }
   
   
    /*
     * TASK:          This will save the arraylist
     *				  elements to a text file. If
     *				  a textfile by that name already
     *				  exists, the user will be asked
     *				  if they wish to overwrite the
     *				  already existing file.
     *
     * PRECONDITION:  There must be something to save.
     *				  If the arraylist is empty, a 
     *				  message will notify the user.
     *
     * MODIFIES:      The Library text file, or the
     *				  user can create a new file to
     *				  save the arraylist to.
     *
     * POSTCONDITION: The alrady existing text file 
     *				  will be updated, or a new file
     *				  will have been created.
     */
   public void save(String fileName){
   	int k = 0;
   		
      try{
          
       File f = new File(fileName + ".txt");
       	//Next line checks if the file already exists.
  	    if(f.exists()){
  	    	
  	    	//If it does, we have to ask the user if they
  	    	//want to overwrite it.
  	  	  System.out.println("A file by this name already exists.");
  	  	  System.out.println("Do you want to overwrite it? (Y/N)");
  	  	  Scanner ans = new Scanner(System.in);
  	  	  char answer = ans.next().toUpperCase().charAt(0);
  	  	  
  	  	  	//If they are comfortable overwriting the already
  	  	  	//existing file, we save the items to the file.
  	  	  if(answer == 'Y'){
  	  	  		//If the file exists, we have to delete it then
  	  	  		//save a new one with that name. This is because
  	  	  		//if the file has 6 elements, but the arrayList
  	  	  		//only has 4, then only the first 4 of the 6 in the
  	  	  		//file are overwritten. So we delete it and create
  	  	  		//a new file with the name. If we're over writing,
  	  	  		//then we don't care to keep whats in the existing
  	  	  		//file.
  	  	  	boolean success = f.delete();
  	  	  	if(success == false) {
  	  	  		System.out.println("Cannot delete file " + f.getName());
  	  	  		System.out.println("Check if the file is opened by another program and try again...");
  	  	  		return;
  	  	  	}
  	      }else if(answer == 'N'){
  	      	System.out.println("Try again and enter a different file name.");
  	      	return;
  	      } else {
  	      	System.out.println("The answer has to be 'Y' or 'N'. Try again...");
  	      	return;
  	      }
  	      
        }
       	//If there is no already existing file by that name,
       	//then the items are saved to this new file.
		FileWriter writer = new FileWriter(fileName + ".txt");
          
	   	while(k < items.size()){
   		    writer.write(items.get(k) + "\r\n");
   	    	k++;
	   	}
	   	writer.close();
	   	System.out.println("Saved to: " + fileName + ".txt");

      }catch(IOException e){
        System.out.println("Something went wrong with accessing the file.");
      }
   }
   

   	/*
     * TASK:          This will read from the text file
     *				  and populate the items arraylist
     *				  with the file contents.
     *	 
     * PRECONDITION:  The items arraylist may be empty,
     *				  unless the user has already added
     *				  items to it
     *	
     * MODIFIES:      The items arraylist.
     *
     * POSTCONDITION: The items arrayList will be populated
     *				  by the elements read from the text file.
     *
     */
   public void open(String fileName){
   	String inStr = "";
   	String[] parts;
   	String title = "";
   	String author = "";
   	String year = "";
   	String availability = "";
   	String type = "";
   	String temp = "";
   	
   	items.clear();
   	
   	try{
   	  BufferedReader ir = new BufferedReader(new FileReader(fileName + ".txt"));
   	  while((inStr = ir.readLine()) != null){
   	  		//First we have to split the string
   	  		//at every comma, since the file 
   	  		//contains a comma seperated list.
		parts = inStr.split(", ");
		if(parts.length == 1)
			continue;

		   
		for(int i = 0; i < parts.length; i++){
			String[] pts = parts[i].split(": ");
			
			  //A switch statement makes it a little
			  //easier and cleaner when splitting up
			  //the elements for the second time,
			  //by the :
			switch(i) {
   				case 0:
   					title = pts[1];
	   			break;
   				case 1:
   					temp = pts[1];
   				break;
	   			case 2:
   					availability = pts[1];
   				break;
   				case 3:
   					type = pts[1];
	   			break;
   			}
   	  	}	
   	  	
   	  		//Type and Title are common to all items,
   	  		//so we dont have to check the itemType
   	  		//before printing this part.
		System.out.println("Type: " + type);	
		System.out.println("Title: " + title);
		
			//Now we have to check if the type is a book
			//or a magazine, since the two will have
			//different information attached to them.
   		if(type.equalsIgnoreCase("BOOK")) {
			System.out.println("Author: " + temp);
			Book b = new Book(title, temp);
			if(availability.equalsIgnoreCase("true"))
				b.setAvailability(true);
			else
				b.setAvailability(false);
			items.add(b);
   		} else {
			System.out.println("Year: " + temp);
			Magazine b = new Magazine(title, Integer.parseInt(temp));
			System.out.println("Control: " + availability);
			if(availability.equalsIgnoreCase("true"))
				b.setAvailability(true);
			else
				b.setAvailability(false);
			items.add(b);
   		}
   		
   			//Since Availability is also common to all items,
   			//it can be printed here without testing the
   			//itemType. 
		System.out.println("Availability: " + availability);
		System.out.println("");
	  }

      ir.close();	//Close file when done.
   	  } catch (FileNotFoundException e) {
        System.out.println("ERROR:  file not found");
      } catch (IOException e) {
        System.out.println("ERROR:  file I/O problem");
      } catch (NullPointerException e){
      	System.out.println("ERROR:  Null Pointer.");
      }
   }

   
    /*
     * TASK:          This will sort alphabetically
     *				  by the authors last name.
     *
     * PRECONDITION:  There must be books in the
     *				  arraylist.
     *
     * MODIFIES:      The order of book items in the arrayList.
     *
     * POSTCONDITION: The books in the arraylist will
     *				  be displayed in alphabetical 
     *				  order by authors name.
     */
  public void sortAuthor(){
  
    Book temp;      // used for swapping books in the array
    for(int i=0; i<items.size(); i++) {

	  // Check to see the item is a book. We will only
      //use books.
	   if(items.get(i).getItemType() != Item.ItemTypes.BOOK)
	     continue;
					
	   for(int j=i+1; j<items.size(); j++) {
		   // We consider only books
	        // We consider only magazines
	     if(items.get(j).getItemType() != Item.ItemTypes.BOOK)
		   continue;
		   // Compare the authors of the two books
	     if(((Book)items.get(i)).getAuthor().compareTo(((Book)items.get(j)).getAuthor()) > 0) {
		   // Swap the items
		   temp = (Book)items.get(i);
		   items.remove(i);
		   items.add(i, items.get(j-1));
		   items.remove(j);
		   items.add(j, temp);
	     }
	   }
	 }
		// Print the magazines
    for(int i=0; i<items.size(); i++)
	  if(items.get(i).getItemType() == Item.ItemTypes.BOOK)
		System.out.println(items.get(i).toString());
    	
  }
   

    /*
     * TASK:          This will sort then display
     *				  the magazines in order by year
     *				  from most recent to oldest.
     *
     * PRECONDITION:  There must be magazines in 
     *				  the arraylist. If there are
     *				  no magazines, nothing will 
     *				  print.
     *
     * MODIFIES:      The items arrayList.
     *
     * POSTCONDITION: List of magazines sorted
     *				  numerically by year will 
     *				  be displayed.
     */
   public void sortYear(){

		// sort magazines by year inside the items array
     Magazine temp; // used for swapping magazines in the array
	 for(int i=0; i<items.size(); i++) {

		// Check to see the item is a magazine. We will only
		//use magazines.
	   if(items.get(i).getItemType() != Item.ItemTypes.MAGAZINE)
	     continue;
			
	   for(int j=i+1; j<items.size(); j++) {
		   // We consider only magazines
	     if(items.get(j).getItemType() != Item.ItemTypes.MAGAZINE)
		   continue;
		   // Compare the years of the two magazines
	     if(((Magazine)items.get(i)).getYear() < 
	     	((Magazine)items.get(j)).getYear()) {
		   // Swap the items
		   temp = (Magazine)items.get(i);
		   items.remove(i);
		   items.add(i, items.get(j-1));
		   items.remove(j);
		   items.add(j, temp);
	     }
	   }
	 }
		// Print the magazines
		for(int i=0; i<items.size(); i++)
			if(items.get(i).getItemType() == Item.ItemTypes.MAGAZINE)
				System.out.println(items.get(i).toString());
   }

  
  
    /*
     * TASK: 			This method iterates through the
     *					list until it finds a match and
     *					then displays it.
     *					If there is no match, then an
     *					error message is displayed.	         
     *                 
     * PRECONDITION:    There must be items in the library.
     *					If there are no items, and a user tries
     *					to search for an item, it will print 
     *					that item could not be found. They will
     *					also see an error message if they try
     *					to search a title that doesn't exist.
     *                
     * MODIFIES:        This doesn't change any items, or the
     *					arrayList. It only displays a specific
     *				    item to the screen.
     *                 
     * POSTCONDITION:   The item that was searched for is printed
     *					to screen with all its information.
     *                                 
     */
   public void searchTitle(String srchttl){
   	
   	boolean found = false;					
   	Iterator<Item> i = items.iterator();
   	Item current = new Item();

	while(i.hasNext()){
	  current = i.next();
	   
	  if(srchttl.compareTo(current.getTitle()) == 0) {
	    System.out.print("Found " + current.toString());
	    found = true;
	  } 
    }
    
	if(found != true){
	 System.out.println("Title " + srchttl + " could not be found.");
	 System.out.println("Check the spelling and try again.");
	}
   
   }


 
    /*
     * TASK: 			Allows the user to delete any 
     * 					item from the library.	         
     *                 
     * PRECONDITION:    There must be at least one
     *					item in the library.
     *                
     * MODIFIES:        The items. This method removes
     *					items from the arrayList.
     *                                       
     * POSTCONDITION:   There will be less items in the library
     *					than there were before.
     *                                 
     */
   
   public void delete(String title){
   	 boolean found = false;					
   	 Iterator<Item> i = items.iterator();
   	 Item current = new Item();

	 while(i.hasNext()){
	   current = i.next();
	   
	   	 //First we find the item we are looking for.
	   if(title.compareTo(current.getTitle()) == 0) {
	     System.out.print("Are you sure you wish to remove " + current.toString());
	     System.out.println("from the library (y/n)?");
		 Scanner sc = new Scanner(System.in);
		 String result = sc.next().toUpperCase();
         if(result.charAt(0) == 'Y'){
         	//This deletes that specific item.
    	   i.remove(); 
	       System.out.println("Title: " + title + " has been removed.");
         }
	     found = true;
	   }
	 }
	 if(found != true)
	 {
	   System.out.println("Title " + title + " could not be found.");
	   System.out.println("Check the spelling and try again.");
	 }
	
   }

   
  
    /*
     * TASK: 			Allows the user to add a book
     *				    to the library. Once the user 
     *				    inputs all the information,
     *					the new item is added to the library.	         
     *                 
     * PRECONDITION:    There must be an arrayList for this
     *					item to be added to.
     *                
     * MODIFIES:        A new element is added to
     *					the items arraylist.
     *                         
     * POSTCONDITION:   After this, there will be at least 
     *					one item in the library, or 
     *					another book item in the library.
     *                 
     */
 
   public void add(String t, String author){
	  
	  items.add(new Book(t, author));
	  
   }
   
   
    /*
     * TASK:          Allows the user to add another
     *				  magazine to the library.
     *				  The add method was overloaded
     *				  because book and magazine 
     *				  require different inputs,
     *				  this way they can be added 
     *				  seperately and easily.
     *					
     * PRECONDITION:  There must be an arrayList for 
     *				  this item to be added to.
     *
     * MODIFIES:      A new element is added to
     *				  the items arraylist.
     *
     * POSTCONDITION: After this add function, there
     *				  will be another magazine in the
     *				  items arraylist. There will be
     *				  at least one item in the library.
     */
   public void add(String t, int year){
   	 	
	  items.add(new Magazine(t, year));
   	 
   } 
   	
   //----------------------------------------------------------------------------------------------------------EDIT (DONE)	
   	
   	/*
     * TASK:          Allows the user to edit an item
     *				  in the library. They will search
     *				  by title for the item they wish 
     *				  to edit.   
     *
     * PRECONDITION:  There must be items in the library
     *
     * MODIFIES:      An item in the arrayList that the
     *				  user chooses to edit.
     *
     * POSTCONDITION: Whatever changes the user makes to
     *				  that certain item will take place
     *				  in the arrayList.
     */
   	
    public void edit(String title){
 		
 	  char inpt;
 	  Scanner e;
 	  Scanner ttl;
 	  String t;
 		
 	  boolean found = false;					
   	  Iterator<Item> i = items.iterator();
   	  Item current = new Item();

	  while(i.hasNext()){
	    current = i.next();
	   
		       //First we have to find the title we want to edit.
	    if(title.compareTo(current.getTitle()) == 0) {
	      System.out.print("Found " + current.toString());
	      found = true;
	      System.out.println("Is this the item you wish to edit? (Y/N)");
	      Scanner response = new Scanner(System.in);
	      char r = response.next().toUpperCase().charAt(0);
	      if(r == 'Y'){
	      	 
	        		//Check if item is Book or magazine, then ask
	        		//user what element they wish to change.
 		    if(current.getItemType() == Item.ItemTypes.BOOK){
 		      System.out.println("Edit: (T)itle or (A)uthor.");
 		  	  e = new Scanner(System.in);
 		      inpt = e.next().toUpperCase().charAt(0);
 			
 		      if(inpt == 'T'){
 		        System.out.println("Enter the new title: ");
 			    ttl = new Scanner(System.in);
 			    t = ttl.nextLine();
 				
 					//set new title!
 			    current.setTitle(t);
 				
 		  	  }else if(inpt == 'A'){
 				
 		        System.out.println("Enter new authors name: ");
 		        Scanner a = new Scanner(System.in);
 		        String author = a.nextLine();
 		  
 		        ((Book)current).setAuthor(author);
 		        	//This needded to be cast because setAuthor
 		        	//is a method in the child class (Book),
 		        	//not the parent class (Item.)	
 		       }
 		     } else if(current.getItemType() == Item.ItemTypes.MAGAZINE){
 		       System.out.println("Edit: (T)itle or (Y)ear.");
 		       e = new Scanner(System.in);
 		       inpt = e.next().toUpperCase().charAt(0);
 			
 		       if(inpt == 'T'){
 		         System.out.println("Enter the new title: ");
 			     ttl = new Scanner(System.in);
 			     t = ttl.nextLine();
 				
 				 	//set new title!
 		  	     current.setTitle(t);
 				
 		       } else if (inpt == 'Y'){
 		   	
 		         System.out.println("Enter new year: ");
 		         Scanner y = new Scanner(System.in);
 		         int year = y.nextInt();
 		     
 		         ((Magazine)current).setYear(year);	
 		         	//This needded to be cast because setAuthor
 		        	//is a method in the child class (Book),
 		        	//not the parent class (Item.)		
 		       }
 		     }
	       }
	     } 
       }
    
      	//If the title can't be found, print this.
	  if(found != true){
	    System.out.println("Title: " + title + " could not be found.");
	    System.out.println("Check the spelling and try again.");
	  }
    }
}