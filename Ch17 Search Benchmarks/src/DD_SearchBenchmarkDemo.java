import java.util.Random;

/**
 * @author Dolunay Dagci
 * Assignment: Ch17 Search Benchmarks
 * CISS 111 - 360
 * Due Sunday, April 7, 2019
 * This program picks a random integer from the arrays, runs a sequential search on the unsorted array and
 * a binary search on the sorted array to find this integer, and keeps track of the number of comparisons for each sort.
 *
 */
public class DD_SearchBenchmarkDemo {
    public static void main(String[] args) {

        //create array and assign numbers
        int[] numbers = new int[500];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            int n = random.nextInt(500);
            numbers[i] = n; }

        int[] numbersSorted;
        numbersSorted = numbers; // they are both the same array, but in the next line numbersSorted array, will be sorted in numerical order, and numbers array will stay unsorted

        System.out.printf("There are %d integers in each array.\n", numbers.length); //display how many values are in the arrays
        System.out.println("Unsorted Array:"); DD_SearchBenchmark.printArray(numbers); //print unsorted array

        DD_SearchBenchmark.Quicksort(numbersSorted, 0, numbersSorted.length - 1); //sort array

        System.out.println("Sorted Array:"); DD_SearchBenchmark.printArray(numbersSorted); System.out.println(); //print sorted array

        boolean done = false;
        for (int i = 1; i <= 10; i++){ //do 10 times, and track # of comparisons each time
            DD_SearchBenchmark.sequentialSearch(numbers, getRandom(numbers));
            DD_SearchBenchmark.binarySearch(numbersSorted, getRandom(numbersSorted));
            System.out.println("***********************************************");
            if (i == 10) done = true;
            if (done)   System.out.println("The average number of comparisons overall for each search algorithm:\n" + //print the overall average of # of comparisons
                        "Sequential Search: " + DD_SearchBenchmark.getStotal()/i + "\n" +
                        "Binary Search: " + DD_SearchBenchmark.getBtotal()/i);

        }
}

    /**
     *
     * @param array from above
     * @return random integer chosen from the array
     */
    private static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
