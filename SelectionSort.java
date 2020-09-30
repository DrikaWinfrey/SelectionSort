
package selectionsort;
import java.util.*;
public class SelectionSort
{
    private int[] nums;
    public SelectionSort(int[] nums) 
    {
	this.nums = Arrays.copyOfRange(nums, 0, nums.length);
    }
    private int posnMaxItem(int highIndex) 
    {
        int posnMaxItem = 0;
	for (int i = 0; i <= highIndex; i++) 
	    if (nums[i] > nums[posnMaxItem])
	       posnMaxItem = i;
        return posnMaxItem;
    }
    public void testPosnMaxItem() 
    {	
        System.out.println("Testing posnMaxItem-function:");
        for (int highIndx = nums.length - 1 ; highIndx >= 0; highIndx--)        	
	    System.out.printf("   highIndx = %d, nums[0..%d] = %s, "
                             + "posnMaxItem = %d, maxItem = %d\n", 
                             highIndx, highIndx, Arrays.toString
                             (Arrays.copyOfRange(nums, 0, highIndx+1)), 
                             posnMaxItem(highIndx), 
                             nums[posnMaxItem(highIndx)]);	
    }
    public void selectionSort() 
    {
	System.out.println("------");
	System.out.println("Testing SelectionSort:");
	int posnMaxItem = 0, temp, totalNumExchanges = 0,
            totalNumComparisons = 0;
	for (int posnToFill = nums.length - 1; posnToFill > 0; posnToFill--) 
        {
            System.out.println("nums = " + Arrays.toString(nums) 
                              + ", totalNumExchanges = " + totalNumExchanges);
	    posnMaxItem = posnMaxItem(posnToFill);
	    totalNumComparisons = totalNumComparisons + posnToFill;
	    System.out.println("posnToFill = " + posnToFill 
                              + ", items looked at : " 
                              + Arrays.toString(Arrays.copyOfRange
                              (nums, 0, posnToFill+1))+ ", posnMaxItem = " 
                              + posnMaxItem + ", totalNumComparisons = " 
                              + totalNumComparisons);
	    if (posnMaxItem < posnToFill) 
            {
		System.out.printf("   nums[%d] = %d to be exchanged with "
                                 + "nums[%d] = %d\n", posnMaxItem, 
                                 nums[posnMaxItem], posnToFill, 
                                 nums[posnToFill]);
		temp = nums[posnMaxItem];
		nums[posnMaxItem] = nums[posnToFill];
		nums[posnToFill] = temp;
		totalNumExchanges++;
	    } 
            else System.out.println("   *** no exchange done");
	}
	System.out.println("nums = " + Arrays.toString(nums) 
                          + ", totalNumExchanges = " + totalNumExchanges);
	}
	public static void main(String[] args) 
        {
	    int[] nums = {4, 5, 7, 1, 10, 15, 3, 5};
	    SelectionSort ss = new SelectionSort(nums);
	    ss.testPosnMaxItem();
	    ss.selectionSort();
	}
}
/*
Testing posnMaxItem-function:
   highIndx = 5, nums[0..5] = [3, 10, 4, 15, 5, 7], posnMaxItem = 3, maxItem = 15
   highIndx = 4, nums[0..4] = [3, 10, 4, 15, 5], posnMaxItem = 3, maxItem = 15
   highIndx = 3, nums[0..3] = [3, 10, 4, 15], posnMaxItem = 3, maxItem = 15
   highIndx = 2, nums[0..2] = [3, 10, 4], posnMaxItem = 1, maxItem = 10
   highIndx = 1, nums[0..1] = [3, 10], posnMaxItem = 1, maxItem = 10
   highIndx = 0, nums[0..0] = [3], posnMaxItem = 0, maxItem = 3
------
Testing SelectionSort:
nums = [3, 10, 4, 15, 5, 7], totalNumExchanges = 0
posnToFill = 5, items looked at : [3, 10, 4, 15, 5, 7], posnMaxItem = 3, totalNumComparisons = 5
   nums[3] = 15 to be exchanged with nums[5] = 7
nums = [3, 10, 4, 7, 5, 15], totalNumExchanges = 1
posnToFill = 4, items looked at : [3, 10, 4, 7, 5], posnMaxItem = 1, totalNumComparisons = 9
   nums[1] = 10 to be exchanged with nums[4] = 5
nums = [3, 5, 4, 7, 10, 15], totalNumExchanges = 2
posnToFill = 3, items looked at : [3, 5, 4, 7], posnMaxItem = 3, totalNumComparisons = 12
   *** no exchange done
nums = [3, 5, 4, 7, 10, 15], totalNumExchanges = 2
posnToFill = 2, items looked at : [3, 5, 4], posnMaxItem = 1, totalNumComparisons = 14
   nums[1] = 5 to be exchanged with nums[2] = 4
nums = [3, 4, 5, 7, 10, 15], totalNumExchanges = 3
posnToFill = 1, items looked at : [3, 4], posnMaxItem = 1, totalNumComparisons = 15
   *** no exchange done
nums = [3, 4, 5, 7, 10, 15], totalNumExchanges = 3

Testing posnMaxItem-function:
   highIndx = 7, nums[0..7] = [4, 5, 7, 1, 10, 15, 3, 5], posnMaxItem = 5, maxItem = 15
   highIndx = 6, nums[0..6] = [4, 5, 7, 1, 10, 15, 3], posnMaxItem = 5, maxItem = 15
   highIndx = 5, nums[0..5] = [4, 5, 7, 1, 10, 15], posnMaxItem = 5, maxItem = 15
   highIndx = 4, nums[0..4] = [4, 5, 7, 1, 10], posnMaxItem = 4, maxItem = 10
   highIndx = 3, nums[0..3] = [4, 5, 7, 1], posnMaxItem = 2, maxItem = 7
   highIndx = 2, nums[0..2] = [4, 5, 7], posnMaxItem = 2, maxItem = 7
   highIndx = 1, nums[0..1] = [4, 5], posnMaxItem = 1, maxItem = 5
   highIndx = 0, nums[0..0] = [4], posnMaxItem = 0, maxItem = 4
------
Testing SelectionSort:
nums = [4, 5, 7, 1, 10, 15, 3, 5], totalNumExchanges = 0
posnToFill = 7, items looked at : [4, 5, 7, 1, 10, 15, 3, 5], posnMaxItem = 5, totalNumComparisons = 7
   nums[5] = 15 to be exchanged with nums[7] = 5
nums = [4, 5, 7, 1, 10, 5, 3, 15], totalNumExchanges = 1
posnToFill = 6, items looked at : [4, 5, 7, 1, 10, 5, 3], posnMaxItem = 4, totalNumComparisons = 13
   nums[4] = 10 to be exchanged with nums[6] = 3
nums = [4, 5, 7, 1, 3, 5, 10, 15], totalNumExchanges = 2
posnToFill = 5, items looked at : [4, 5, 7, 1, 3, 5], posnMaxItem = 2, totalNumComparisons = 18
   nums[2] = 7 to be exchanged with nums[5] = 5
nums = [4, 5, 5, 1, 3, 7, 10, 15], totalNumExchanges = 3
posnToFill = 4, items looked at : [4, 5, 5, 1, 3], posnMaxItem = 1, totalNumComparisons = 22
   nums[1] = 5 to be exchanged with nums[4] = 3
nums = [4, 3, 5, 1, 5, 7, 10, 15], totalNumExchanges = 4
posnToFill = 3, items looked at : [4, 3, 5, 1], posnMaxItem = 2, totalNumComparisons = 25
   nums[2] = 5 to be exchanged with nums[3] = 1
nums = [4, 3, 1, 5, 5, 7, 10, 15], totalNumExchanges = 5
posnToFill = 2, items looked at : [4, 3, 1], posnMaxItem = 0, totalNumComparisons = 27
   nums[0] = 4 to be exchanged with nums[2] = 1
nums = [1, 3, 4, 5, 5, 7, 10, 15], totalNumExchanges = 6
posnToFill = 1, items looked at : [1, 3], posnMaxItem = 1, totalNumComparisons = 28
   *** no exchange done
nums = [1, 3, 4, 5, 5, 7, 10, 15], totalNumExchanges = 6     
*/