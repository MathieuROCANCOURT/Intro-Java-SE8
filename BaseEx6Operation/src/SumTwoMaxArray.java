import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Calculate the sum of the two maximum values in an array.
 * 
 * @author RocancourtM
 */
public class SumTwoMaxArray {
	/**
	 * Take the maximum value from the array.
	 * 
	 * @param array Integer array.
	 * @return Maximum value.
	 */
	private static int max(ArrayList<Integer> array) {
		return Collections.max(array);
	}

	private static int sum2HighValueArray(ArrayList<Integer> array) {
		int firstMax = max(array);
		array.remove(array.indexOf(firstMax));
		int secondMax = max(array);

		return firstMax + secondMax;
	}

	public static void main(String[] args) {
		ArrayList<Integer> testArray = new ArrayList<>(Arrays.asList(78, 6, -250, 2, 12, 9));
		System.out.println(sum2HighValueArray(testArray));
	}

}
