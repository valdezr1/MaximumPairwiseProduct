import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("MaximumPairwiseProduct Program!\nInput Size:");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine(); // throw away the '\n' being consumed as input
        // Have more than 1 value in the list
        if (size > 1) {
            int[] inputArr = new int[size];
            // get scanner input for array
            System.out.println("Input Values (space-separated):");
            String inputStr = scanner.nextLine();
            String[] strArr = inputStr.split(" ");
            for (int i = 0; i < size; i++) {
                inputArr[i] = Integer.parseInt(strArr[i]);
            }

            System.out.printf("The MaximumPairwiseProduct is %d", maximumPairwiseProduct(inputArr, size));
        }
        else {
            System.out.println("Invalid Size Given");
        }
    }

    public static int maximumPairwiseProduct(int[] arr, int size) {
        int currentMax = -1;
        int currentSecondMax = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] > currentMax) {
                currentSecondMax = currentMax;
                currentMax = arr[i];
            }
            else if (arr[i] > currentSecondMax && arr[i] != currentMax) {
                currentSecondMax = arr[i];
            }
        }

        return currentMax * currentSecondMax;
    }
}