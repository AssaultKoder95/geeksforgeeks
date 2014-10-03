import java.util.*;
/*
 * implementation of mergeSort, quickSort, bubbleSort, selectionSort, insertionSort, heapSort, bucketSort, shellSort
 */

public class sort {
	/*
	 * mergeSort
	 */
	public void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	public void mergeSort(int[] array, int start, int end) {
		int middle = start + (end - start) / 2;
		if(start >= end) return;
		mergeSort(array, start, middle);
		mergeSort(array, middle + 1, end);
		merge(array, start, middle, end);
	}
	public void merge(int[] array, int start, int middle, int end) {
		int[] helper = new int[end - start + 1];
		for(int i = start; i <= end; i++) {
			helper[i - start] = array[i];
        }
        int left = start, right = middle + 1, count = start;
        while(left <= middle && right <= end) {
        	if(helper[left - start] <= helper[right - start]) {
        		array[count++] = helper[left - start];
        		left++;
        	}
        	else {
        		array[count++] = helper[right - start];
        		right++;
        	}
        }
        while(left <= middle) {
        	array[count++] = helper[left - start];
        	left++;
        }
	}

	/*
	 * quickSort
	 */

	public void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	public void quickSort(int[] array, int start, int end) {
		if(start >= end) return;
		int pivot = partition(array, start, end);
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot, end);  
	}
	public int partition(int[] array, int start, int end) {
		int pivot = array[start + (end - start) / 2];  //must have pivot determined at the beginning, don't use int pivot = start + (end - start) / 2 !!!!
		int left = start, right = end;
		while(left <= right) {
			while(array[left] < pivot) {     //important: no "="
				left++;
			}
			while(array[right] > pivot) {
				right--;
			}
			if(left <= right) {
			    swap(array, left, right);
			    left++;
			    right--;
			}
		}
		return left;
	}

	/*
	 * bubbleSort
	 */

	public void bubbleSort(int[] array) {
		boolean change = true;
		while(change) {
			change = false;
			for(int j = 1; j < array.length; j++) {
				if(array[j] < array[j - 1]) {
					swap(array, j - 1, j);
					change = true;
				}
			}
		}
	}

	/*
	 * selectionSort
	 */

	public void selectionSort(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int minIndex = i;
			for(int j = i; j < array.length; j++) {
				if(array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			swap(array, i, minIndex);
		}
	}

	/*
	 * insertionSort
	 */

	public void insertionSort(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int num = array[i];
			int index = i - 1;
			while(index >= 0 && num < array[index]) {
				array[index + 1] = array[index];
				index--;
			}
			array[index + 1] = num;
		}
	}

	/*
	 * heapSort
	 */

	public void heapSort(int[] array) {
		int start = (array.length - 2) / 2;
		heapify(array); // build max heap, add the elements in array into the heap one by one: NlogN
		shiftUp(array); // exchange the peek with the last ele in the array, fill the peek with the max number in the heap: NlogN
	}
	public void heapify(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int index = i;
			while((index - 1) / 2 >= 0) {
				int parent = (index - 1) / 2;
				if(array[parent] < array[index]) {
					swap(array, parent, index);
					index = parent;
				}
				else break;
			}
		}
	}
	public void shiftUp(int[] array) {
		for(int i = array.length - 1; i >= 0; i--) {
			int index = 0;
			swap(array, 0, i);
			while(2 * index + 1 < i) {
				int left = 2 * index + 1;
				int in = index;
				if(array[in] < array[left]) {
					in = left;
				}
				if(left + 1 < i && array[in] < array[left + 1]) {
					in = left + 1;
				}
				if(index == in) {
					break;
				}
				swap(array, in, index);
				index = in;
			}
		}
	}

	/*
	 * bucket sort
	 */

	public void bucketSort(int[] array) {
		List<Integer> list[] = (LinkedList<Integer>[]) new LinkedList[10];
		for(int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<Integer> ();
		}
		for(int i = 0; i < array.length; i++) {
			int count = array[i] / 10;
			insert(list[count], array[i]);
		}
		int count = 0;
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j < list[i].size(); j++) {
				array[count++] = list[i].get(j);
			}
		}
	}
	public void insert(List<Integer> list, int num) {
		for(int i = list.size() - 1; i >= 0; i--) {
			if(list.get(i) > num) {
				i--;
			}
			else {
				list.add(i + 1, num);
				return;
			}
		}
		list.add(0, num);
	}

	/*
	 * shellSort
	 */

	public void shellSort(int[] array) {
		for(int gap = array.length / 2; gap > 0; gap /= 2) {
			for(int i = 0; i < gap; i++) {
			    for(int j = i; j < array.length; j += gap) {
				    int min = j;
				    for(int k = j + gap; k < array.length; k += gap) {
					    if(array[k] < array[min]) {
						    min = k;
						}
					}
					swap(array, j, min);
				}
			}
		}
	}

	public void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public int interpolationSearch(int[] array, int element) {
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
	public static void main(String[] args) {
		int[] array = {1,2,2,2,3, 10, 3, 40, 20, 50, 80, 70,12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
		sort ss = new sort();
		ss.shellSort(array);
		for(int i : array)
			System.out.println(i);
		System.out.println(ss.interpolationSearch(array, 10));
	}
}