import java.lang.Math;
/**
 * 
 * @author NadiraDewji
 * This is a YearNames class that consists of two data fields a a MyArrayList object and a year
 *
 */

public class YearNames {
	MyArrayList<Name> myArrayListNames = new MyArrayList<Name>();
	int year;
	/**
	 * this constructor makes a YearNames object
	 * @param year 
	 */
	public YearNames(int year){
		this.year = year;
	}
	/**
	 * 
	 * @param n, n is a name object that will be appended to the a YearNames' MyArrayList fields. If it already exists, an error will be thrown.
	 */
	public void add(Name n){
		if(myArrayListNames.contains(n)){
			 throw new IllegalArgumentException("This name already exists in the list");

		}
		else{
			 myArrayListNames.add(n);
		}
	}
	/**
	 *
	 * @param myInputName, this is a string that represents a Name. 
	 * @return number of babies that were given that name sum of male and female
	 * This method loops through the YearNames object, specifically through the arraylist and if a name matches the input name
	 * then it collects its count.
	 */
	public int getCountByName(String myInputName){
		int totalCount= 0;
		for(Name myName: myArrayListNames){
			if ((myName.name).equalsIgnoreCase(myInputName)){
				totalCount+= myName.count;
			}
		}
		return totalCount;
		
	}
	/**
	 * 
	 * @param name, this the name that is part components of a name object
	 * @return this returns a double which is a count of the name(both f, and m) and divided by the total count of all names
	 * This is an indication of the percentage of how common this name is.
	 */
	public double getFractionByName(String name){
		int totalCount =0;
		for(Name myName: this.myArrayListNames){
				totalCount+= myName.count;
			}

		float myNum = (float)(getCountByName(name))/(totalCount);
		return (myNum*100);
		
	}
	/**
	 * This method overrides the toString() method found in its super class. It reports the year this object is referring to
	 * as well as the number of elements.
	 */
	@Override public String toString(){
		String myString = new String("This data reports names from the year "+this.year+". It has a total number of "+myArrayListNames.size()+" different names.\n");
		for(Name names: myArrayListNames){
			myString+= names.toString()+"\n";
		}
		return myString;
	}

}
