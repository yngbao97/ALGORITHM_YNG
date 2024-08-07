import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {5, 7, 3, 8, 4, 7, 5, 4};
		
		quickSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));

	}
	
	private static void quickSort(int[] arr, int left, int right) {

//		System.out.println(left + "," +right);
		if (left >= right) return;
		
		int mid = partition(arr, left, right);
		
		quickSort(arr, left, mid-1);
		quickSort(arr, mid+1, right);
		
	}

	private static int partition(int[] arr, int left, int right) {
		
		int pivot = arr[left];
		int low = left + 1;
		int high = right;
		
		while (low <= high) {
			while (arr[low] >= pivot && low <= right) low++;
			while (arr[high] < pivot && high >= left) high--;
			
			if (low < high) {
				int tmp = arr[low];
				arr[low] = arr[high];
				arr[high] = tmp;
			}
		}
		
		arr[left] = arr[high];
		arr[high] = pivot;
		
		return high;
	}

}
