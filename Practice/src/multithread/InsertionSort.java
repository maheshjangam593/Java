package multithread;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 6, 5, 1, 4, 2 };

		// calling sorting method

		int[] sortedList = getsortedElements(a);
		for (int i = 0; i < sortedList.length; i++) {
			System.out.print(" " + sortedList[i]);
		}

	}

	private static int[] getsortedElements(int[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {

			// comparing elements before the current index
			// swap if the before value is greater than the current value
			
			while (i > 0 && a[i - 1] > a[i]) {

				int temp = a[i - 1];
				a[i - 1] = a[i];
				a[i] = temp;
				i--;

			}
		}
		return a;
	}

}
