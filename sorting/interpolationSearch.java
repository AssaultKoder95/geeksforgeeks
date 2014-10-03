public class interpolationSearch {
	public int interpolationsearch(int[] array, int element) {
		int low = 0;
		int high = array.length - 1;
		while(array[low] <= element && array[high] >= element) {
			int mid = (low + (element - array[low]) * (high - low) / (array[high] - array[low]));
			if(array[mid] < element) {
				low = mid + 1;
			}
			else if(array[mid] > element) {
				high = mid - 1;
			}
			else {
				return mid;
			}
		}
		if(array[low] == element) return low;
		return -1;
	}
}