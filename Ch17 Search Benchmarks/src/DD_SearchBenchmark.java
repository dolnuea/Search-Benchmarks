
/**
 * @author Dolunay Dagci
 * Assignment: Ch17 Search Benchmarks
 * CISS 111 - 360
 * Due Sunday, April 7, 2019
 * This class includes Quick sort, Sequential Search, and Binary Search algorithms, and also a method for printing array values.
 */

public class DD_SearchBenchmark {

    //comparison count variables removed

    //comparison totals for calculating averages
    static int stotal; static int btotal;

    /**
     *
     * @return total counts of Sequential Search
     */
    public static int getStotal() {
        return stotal;
    }

    /**
     *
     * @return total counts of Binary Search
     */
    public static int getBtotal() {
        return btotal;
    }

    /**
     * @param array array to be sorted
     * @param low starting index
     * @param high ending index
     * @return partition for quick sort
     */
     static int partition(int[] array, int low, int high)
    {
        int pivot = array[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            if (array[j] <= pivot)
            {
                i++;
                // swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap array[i+1] and array[high] (or pivot)
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;
    }

    /**
     * @param array array to be sorted
     * @param low starting index
     * @param high ending index
     */
     static void Quicksort(int[] array, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(array, low, high);
            Quicksort(array, low, pi-1);
            Quicksort(array, pi+1, high);
        }
    }

    /**
     * @param a array
     * @param b compared integer
     * @return flag
     */
    static boolean sequentialSearch(int[] a, int b){
        int seqcount = 0; //sequential comparison counter added back here
        for (int i : a) {
            if (i==b){
                System.out.println("The number of comparisons for unsorted array: " + seqcount);
                stotal+=seqcount;
                return true;
            }
            seqcount++;
        }
        return false;
    }

    /**
     * @param a array
     * @param b compared integer
     * @return flag
     */
    static boolean binarySearch(int[] a, int b) {
        int binarycount = 0; //binary search comparison counter added back here
        if (a.length == 0) {
            return false;
        }
        int low = 0;
        int high = a.length-1;

        while(low <= high ) {
            int middle = (low+high) /2;
            if (b> a[middle] ){
                low = middle +1;
            } else if (b< a[middle]){
                high = middle -1;
            } else { // the element has been found
                System.out.println("The number of comparisons for sorted array: " + binarycount);
                btotal+=binarycount; //totals are used to calculate average in the main
                return true;
            }
            binarycount++;
        }
        return false;
    }

    /**
     *
     * @param array that will be printed
     */
    static void printArray(int[] array)
    {
        for (int value : array) System.out.print(value + " ");
        System.out.println();
    }

}
