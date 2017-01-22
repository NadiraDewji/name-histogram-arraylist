import java.util.ArrayList;
/**
This is the MyArrayList Class. 
* @author NadiraDewji
* This class extends ArrayList class however has its own methods such as sort(), isSorted() and it overrides 
*/
import java.util.Collection;
import java.util.Collections;
public class MyArrayList<E extends Comparable<E>> extends ArrayList<E>
{
	/**
	 * This method does not return anything nor does it take any parameters. It overloads the sort method in the ArrayList class. 
	 * It uses the Collections.sort() method 
	 * You are dealing with comparable items
	 */
	 public void sort(){
		Collections.sort(this);			
	}
	/**
	 *This method uses the compareTo method and checks to see if each element is "smaller" than
	 * the proceeding element. 
	 * @return It returns a boolean (True if its sorted and false if it is not).
	 */
	 public boolean isSorted(){
		for (int i=0; i<this.size()-1; i++){
			if(this.get(i).compareTo(this.get(i+1))<1){
			}
			else{
				return false;
			}	
		}
		return true;
		
	}
	/**
	 * This method overides the contains method found in ArrayList and it takes in Object o. It is then casted to a generic
	 * E element that can be compared (using the compareTo) interface. This applies a binary search algorithm to find the element. 
	 * Binary search is an efficient way to find an element as it splits the array into parts where the element resides.
	 * @returns boolean.
	 */
	@Override public boolean contains(Object o){
		E myE = (E)o;
		if(this.isSorted()){
			int low =0;
			int high = this.size() -1;
			while(high>= low){
				int mid = (low+high)/2;
				if(((E)o).compareTo(this.get(mid)) <0){
					high = mid-1;
				}
				else if(((E)o).compareTo(this.get(mid)) ==0){
					return true;
				}
				else{
					 low =mid+1;
				}
			}
			return false;
		}
		else{
			return super.contains(o);
					
		}
		
	}
	
	
	

}
