
 
import java.util.Arrays;
class ArrayComparison
{
    public static void main (String[] args)
    {
        int[] arr1 = {1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,};
        int[] arr2 = {1, 2, 3, 1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,1, 2, 3,};
        
        if (arr1.length == arr2.length)
        	System.out.println("Number of elements is same");
        else
            System.out.println("Number of elements is NOT same");
        	
        //comparing
        if (Arrays.equals(arr1, arr2))
            System.out.println("Same");
        else
            System.out.println("Not same");
    }
}