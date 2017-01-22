import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.lang.Math;
/**
 * 
 * @author NadiraDewji
 *This is the BabyNames class. It runs the program. It uses and creates multiple objects. The way this is structured is that for every
 *file it reads, it runs in a while loop and so it prints out data for one year and then loops again.
 */
public class BabyNames {
	/**
	 * The BabyNames class is the actual program. This is the class that should contain main method. It is responsible for opening and
reading the data files, obtaining user input, performing some data validation and handing all errors that may occur (in particular, it
should handle any exceptions thrown by your other classes and terminate gracefully, if need be, with a friendly error message presented
to the user).
You may (and probably should) implement other methods in this class to modularize the design.
	 * @param args
	 */
	public static void main(String[] args){
		boolean cont = true;
		Name a = new Name("cA", "F", 30);
		Name b = new Name("Bix", "M", 20);
		Name c = new Name ("Charlie", "M", 3);
		Name d = new Name("Dylan", "M", 1);
		YearNames mY = new YearNames(1);
		mY.add(a);
		mY.add(b);
		mY.add(c);
		System.out.print(mY.myArrayListNames.contains(d));
		System.out.println(a.compareTo(b));
		for(Name n: mY.myArrayListNames){
			System.out.println(n);
		}
		mY.myArrayListNames.sort();
		for(Name n: mY.myArrayListNames){
			System.out.println(n);
		}
		
		
		
		/**
		 * This is an ever running while loop. Cont is a boolean variable and it will remain true until
		 * the user enters q or Q to indicate they want to quit the program. 
		 */
		while(cont){
			System.out.println("Hello. Please enter a Baby Name to get a historgram displaying statistics on this name or enter (Q) or (q) to quit");
			Scanner input = new Scanner(System.in);
			String myInput = input.nextLine();
			if (myInput.equals("q")||myInput.equals("Q")){
				cont=false;
				System.out.println("Bye!");
			}
			else{
				int i = 1880;
				while(i<=2015){
					System.out.println();
					YearNames myYearNames = new YearNames(i);
					File f = new File("data/yob"+i+".txt");
					try{	
					Scanner sc = new Scanner(f);
					/**
					 * For every line within a file, each line is turned into an array of strings using the comma to separate the components.
					 */
					while(sc.hasNextLine()){
							String[] myNameComponents = sc.nextLine().split(",");

							try{
								Name myName = new Name(myNameComponents[0], myNameComponents[1], Integer.parseInt(myNameComponents[2]));
								myYearNames.add(myName);
							}
							catch(Exception E){
								continue;
							}

					}
					double percentage =0;
					percentage = myYearNames.getFractionByName(myInput);
					String myCalculation = String.format("%s    (%.4f) :  ",i, percentage);
					Double myAns = (Math.ceil(percentage/0.01));
					/**
					 * This loop prints the histogram using "|" and it repeats the loop accordidng to the myAns variable length.  WHich indicates
					 * how many lines to print.
					 */
					for(int k=0; k<myAns; k++){
						myCalculation += "|";
					}
					System.out.println(myCalculation);
		
							
					}
					catch(Exception E){
						System.out.println(E.toString());
						System.out.println(1);
					}
					
					

					i++;
					}
					
				}
			}
	}
	


}
