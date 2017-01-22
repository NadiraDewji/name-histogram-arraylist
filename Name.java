
import java.io.IOException;
/**
 * @author NadiraDewji
 * This is the Name Class that creates a blueprint for the Name objects.
 */

public class Name implements Comparable<Name>{
	String name;
	String gender;
	int count;
	/**
	 * 
	 * @param name, this is the actual Name so a string. 
	 * @param gender, this is the gender and is limited to male or female.
	 * @param count, this is the count and is an integer representing how many people have that name.
	 */
	public Name(String name, String gender, int count){
		if((name.trim()).isEmpty()){
			throw new IllegalArgumentException("An inappropriate name has been entered");
		}
		else{
			this.name = name;
		}
		if(!((gender.equalsIgnoreCase("m")) ||(gender.equalsIgnoreCase("f")))){
			throw new IllegalArgumentException("An inappropriate gender has been entered");
		}
		else{
			this.gender= gender;
		}
		if(count<0){
			throw new IllegalArgumentException("An inappropriate count has been entered");

		}
		else{
			this.count = count;

		}
	}
	/**
	 * @return this method returns an integer that represents a Names compared to another. If it returns -1 it is "smaller" than the 
	 * the name being compared. If it is 1, it is larger and if they are the same count and name then they are the same. It starts comparing
	 * counts, names and then the gender (by alphabet)
	 */
	@Override public int compareTo(Name myName){
		if(this.name.compareToIgnoreCase((myName).name)<0){
			return 1;
		}
		else if(this.name.compareToIgnoreCase(((Name)myName).name)>0){
			return -1;
		}
		else{
			if(this.count< (myName).count){
				return -1;	
			}
			else if(this.count> (myName).count){
				return 1;
			}
			else{
				 if(this.gender.compareToIgnoreCase(((Name)myName).gender)<0){
					 return 1;
				}
				 else if(this.gender.compareToIgnoreCase(((Name)myName).gender)>0){
					 return -1;
				 }
				 else{
					 return 0;
				 }

			}
		}	
		
	}
	/**
	 * @return this method returns a boolean. And it overrides the equals method. 
	 * Two names are equivalent if the gender, name and count match
	 */
	@Override public boolean equals(Object o){
		Name myName = (Name) o;
		if((this.gender.equalsIgnoreCase(myName.gender)) && (this.name.equalsIgnoreCase(myName.name) && (this.count==(myName.count)))){
			return true;
		}
		else{
			return false;
		}
		
	}
	/**
	 * this method overrides object's toString method and it reports the gender, name and count for a Name object using 
	 * "|" to separate the qualities. 
	 * @return a string
	 */
	@Override public String toString(){
		String myString = new String("Name: "+this.name+"| Gender: "+ this.gender+" | Count: "+this.count+"|");
		return myString;
	}


}
