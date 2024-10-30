import java.io.*;
import java.util.*;

public class BubbleMerge {

    // Create an array of random integers between 0 and 100
    public static Integer[] createRandomArray(int arrayLength) {
        Random random = new Random();
        Integer[] array = new Integer[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(101); // Random integer between 0 and 100
        }
        return array;
    }

    // Write the array to a file, each integer on a new line
    public static <T> void writeArrayToFile(T[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (T element : array) {
                writer.write(element + "\n");
            }
            System.out.println("Array successfully written to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

    // Read integers from a file into an array
    public static Integer[] readFileToArray(String filename) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from file: " + e.getMessage());
        }
        Integer[] array = new Integer[list.size()];
        return list.toArray(array);
    }

    // Sort an integer array using Bubble Sort with Generics
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break; // If no two elements were swapped, the array is already sorted
            }
        }
    }

    // Sort an array using Merge Sort with Generics
    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static <T extends Comparable<T>> void merge(T[] result, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    // Main function to handle user's input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Generate a random array and save to file");
            System.out.println("2. Read array from file, sort it using Bubble Sort, and save the sorted array");
            System.out.println("3. Read array from file, sort it using Merge Sort, and save the sorted array");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Option 1: Generate and save random array to file
                System.out.println("Enter the length of the array:");
                int length = scanner.nextInt();
                Integer[] randomArray = createRandomArray(length);
                
                System.out.println("Enter the filename to save the array:");
                String filename = scanner.next();
                
                writeArrayToFile(randomArray, filename);

            } else if (choice == 2) {
                // Option 2: Read, sort with Bubble Sort, and save the sorted array
                System.out.println("Enter the filename to read the array from:");
                String filename = scanner.next();
                Integer[] array = readFileToArray(filename);

                System.out.println("Sorting the array using Bubble Sort...");
                bubbleSort(array);

                System.out.println("Enter the filename to save the sorted array:");
                String sortedFilename = scanner.next();
                
                writeArrayToFile(array, sortedFilename);
                System.out.println("Sorted array saved to " + sortedFilename);

            } else if (choice == 3) {
                // Option 3: Read, sort with Merge Sort, and save the sorted array
                System.out.println("Enter the filename to read the array from:");
                String filename = scanner.next();
                Integer[] array = readFileToArray(filename);

                System.out.println("Sorting the array using Merge Sort...");
                mergeSort(array);

                System.out.println("Enter the filename to save the sorted array:");
                String sortedFilename = scanner.next();
                
                writeArrayToFile(array, sortedFilename);
                System.out.println("Sorted array saved to " + sortedFilename);

            } else if (choice == 4) {
                // Option 4: Exit
                System.out.println("Exiting program...");
                break;
            } else {
                System.out.println("Invalid option. Please choose 1, 2, 3, or 4.");
            }
        }

        scanner.close();
    }
}
