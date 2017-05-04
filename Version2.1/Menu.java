/**      
 * AUTHOR:  			Stacey Ivanovic
 *
 * CONTACT INFORMATION: stacey.ivanovic007@gmail.com
 *
 * CREATION DATE:   	April 17th, 2015
 *
 * PROBLEM STATEMENT:  	Create a record keeping system, in this
 *						case, a library that holds both books
 *						as well as magazines. Create a Library.
 * 
 * PROGRAM DESCRIPTION: This program acts as a library. The user will
 *						have the option to check items out, look-up
 *						items, as well as many other things you would 
 *			 			be able to do in a library. 
 *
 *						There is one text file,
 *						which contains information of items already in the
 *						library. When the user makes changes to anything
 *						in the library, they will also be able to save
 *						everything back into that same file, or if they 
 *						wish, they will be able to save the library to
 *						a new file.
 *
 * CLASS PURPOSE:  		This is the user interface part of
 *						the library. Almost all menu's and 
 *						calls for user input will happen here.
 *						
 *						The main method from which the program
 *						runs is in this class.
 *
 * CLASS INVARIANT:  	Controller class must exist, and there has to
 *						be a Controller object instantiated so methods
 *						from the class can be called.
 *
 * RUN INSTRUCTIONS: 	When the program starts, a menu will be presented
 *						which will give options that would exist in a
 *						library.
 *
 *						Most of the user input required will be asked for in
 *						this class, however, when that is not possible,
 *						then the user input is asked for from the method that
 *						requires it.
 *						
 *						Year entered must be an integer. The program will print
 *						an error message is a string is given instead of an int.
 *						If a decimal is entered, an error message will display
 *						and say that year must be an integer.
 *
 *					    The authors name can be an initial; A. Uthor is acceptable.
 *						A Books title may contain numbers, letters, other characters.
 *
 *						When looking up an item by its title, the title must be
 *						entered identically to what the items title is. Otherwise
 *						an error message will appear saying that spelling should
 *						be double checked, and then suggest you try again.
 *
 *						The file name entered may also have alphabetical 
 *						characters and numbers in the title. Letter may be
 *						capitalized.
 *			
 *						The text file that goes with this program is
 *						theLibrary.txt and while you can save to that same file,
 *						it is also possible to create a new file when the save
 *						option is chosen and save the arrayList and information
 *						to that new file.
 *
 */ 



import java.util.Scanner;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Menu {
    
    private boolean go = true;

    public Controller c = new Controller();
      
    
    /*
     * TASK: 		   The run method calls methods
     *				   from the controller class 
     *				   depending on the users input.
     *			  
     *                 
     * PRECONDITION:  The controller class must exist
     *				  and contain all the methods called
     *				  in this class.
     *                
     * MODIFIES:      The Controller object.
     *                               
     * POSTCONDITION: The controller object. What that object 
     *				  does, method it calls, message it gets, etc.                                 
     */

    private void run() {
    	
    System.out.println("THE LIBRARY.");
    System.out.println("~~~~~~~~~~~~");
    
    while(go) {
      displayChoices();
      switch(getChoice()) {
        case 'C' :  System.out.println("Enter title of the item you wish to check out: ");
        			Scanner co = new Scanner(System.in);
        			String checkOut = co.nextLine();
        			c.checkOut(checkOut);
        	break;
        case 'R' :  System.out.println("Enter title of the item you wish to return: ");
        			Scanner r = new Scanner(System.in);
        			String rtrn = r.nextLine();
        			c.checkIn(rtrn);
        	break;
        case 'U' :  c.sortAuthor();
        	break;
        case 'I' :  c.sortYear();
        	break;
        case 'A' :  System.out.println("Do you wish to add a (B)ook or a (M)agazine");
					Scanner i = new Scanner(System.in);
					String result = i.next().toUpperCase();
					
					if(result.charAt(0) != 'B' && result.charAt(0) != 'M'){
						System.out.println("Invalid Input.");
						break;
					}
						
					System.out.println("Enter the title of the item you wish to add: ");
					Scanner t = new Scanner(System.in);
					String ti = t.nextLine();
					
					if(result.charAt(0) == 'B'){
						System.out.println("Enter the name of the author: ");
						Scanner a = new Scanner(System.in);
						String author = a.nextLine();
						c.add(ti, author);
					} else if(result.charAt(0) == 'M'){
						System.out.println("Year (numerically) the magazine was first published: ");
						Scanner y = new Scanner(System.in);
						try{
							int year = y.nextInt();
							c.add(ti,year);
						}catch(Exception e){
							System.out.println("Year must be an integer. Please try again.");
						}
				    }
        	break;
        case 'D' :  System.out.println("Enter the title of the item you wish to delete: ");
        			Scanner d = new Scanner(System.in);
   	 				String title = d.nextLine();
   	 				
        			c.delete(title);
        	break;
        case 'S' :  c.displayAll();
        	break;
        case 'T' : 	System.out.println("Enter the title you are looking for: ");
   	 
   	 				Scanner st = new Scanner(System.in);
   	 				String stitle = st.nextLine();
        	
        			c.searchTitle(stitle);
        	break;
        case 'V' :     		//First, we have to check if the items arrayList
   							//has anything in it. If not, don't bother saving.
   							//Tell the user there is nothing to save, then break.
        			if(c.items.isEmpty()) {
        			  System.out.println("There are no items in the library.");
        			  System.out.println("Nothing to save.");
        			  break;
        			}
        			
        			System.out.println("Enter the name of the file ");
        			System.out.println("you wish to save to, without spaces.");
        			    	//If you use spaces, the space and anything after it will be ignored.
        			
        			Scanner fn = new Scanner(System.in);
        			String fileNm = fn.next();
        
        			c.save(fileNm);
        	break;
        case 'O' : 	System.out.println("Enter the name of the file you wish to open: ");
        			Scanner fl = new Scanner(System.in);
        			String opFi = fl.next();
        			
        			c.open(opFi);
        	break;
        case 'E' :  System.out.println("Enter the title of the item you wish to edit: ");
        		 	Scanner ed = new Scanner(System.in);
        		 	String edt = ed.nextLine();
        			c.edit(edt);
        	break;
        case 'Q' :  go = false;
        	break;
        default:    System.out.println("Invalid Input!");
      }
    }
  }
    
    
    /*
     * TASK: 		  Displays a list of choices for the user.	         
     *                 
     * PRECONDITION:  The program has to compile and run. But there 
     *				  are no objects, arrayList, or anything that has
     *				  to exist in order for the program to be able
     *				  to run this method.
     *                
     * MODIFIES:      This modifies nothing. It only prints a list
     *				  of choices for the user to see.
     *                               
     * POSTCONDITION: This method is void, takes no input, returns
     *				  nothing. Just prints options to the screen.
     *                                 
     */
    
     private void displayChoices() {
    	System.out.println("");
    	System.out.println("What would you like to do?");
    	System.out.println("(C)heck Out an item,"); 
    	System.out.println("(R)eturn an item,");
    	System.out.println("(A)dd an item,");
    	System.out.println("(D)elete an item,");
    	System.out.println("Di(S)play all items in the library,");
    	System.out.println("Display books sorted by a(U)thor,");
    	System.out.println("search by (T)itle,");
    	System.out.println("Display magazines sorted by year (I)ssued, ");
    	System.out.println("(E)dit an item,");
    	System.out.println("Sa(V)e the Library to file,");
    	System.out.println("(O)pen file?");
    	System.out.println("(Q)uit.");
    	System.out.print("> ");
  	}

    
    /*
     * TASK: 	        Takes the users input and passes
     *					it to the run method where something
     *					will happen based on that input.		         
     *                  
     * PRECONDITION:    There must be a menu that calls for 
     *					a choice from the user.
     *                
     * MODIFIES:        The choice the user inputs will determine
     *					what happens next.
     *                                               
     * POSTCONDITION:   This will return the users input.
     *                                
     */
    
    private char getChoice() {
    	String input = "Empty";
    	Scanner in = new Scanner(System.in);
    	try {
      		//Grab everthing up to the 'enter' and convert to uppercase
      		input = in.next().toUpperCase();
    	} catch (Exception e) {
      		System.out.println("ERROR:  key read problem");	
    	}
    	//No matter how many characters are typed return the first
    	return input.charAt(0);
  	}
  	
    
    /*
     *  
     * TASK: 		   The program runs from this main. This
     *				   calls the run method and starts the 
     *				   program.
     *                 
     * PRECONDITION:   Since run method is called, it must
     *				   exist, the program has to compile.
     *                
     * MODIFIES:       The Controller object.
     *                 
     * POSTCONDITION:  What the controller object does is
     *				   decided by what happens in the run
     *				   method.
               
     */
     
    public static void main(String[] args) {
    	
    	Menu mn = new Menu();
    	mn.run();	
    }
}
