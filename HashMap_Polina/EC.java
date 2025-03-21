import java.util.Arrays;

public class EC {
    //O(n) time, where n is the length of the input array, where we iterate through each numer once
    //O(1) space, because we don't allocate any extra space and use only constant time operations like var allocation, reassignment, +,-.

    public static int[] sumTarget(int[] array, int k){
        int n = array.length;
        int start = 0;
        int end = 0;
        int sum = 0;

        //add to the sum

        for(int i = 0; i<n;i++){
            sum = sum + array[i];
            while (sum > k && start <= i) {
                sum = sum - array[start]; // Subtract the element at start
                start++; // Move the start pointer forward
            }

            // Check if we found the subarray with sum == K
            if (sum == k) {
                end = i; // record end
                break; // No need to continue
            }
        }




        if (end == 0){
            return new int[] {-1,-1};
        }

        return new int[]{start, end};
    }
    public static void main(String[] args) {
        // Test cases
        int[] A1 = {1, 2, 3, 7, 5};
        int K1 = 12;

        System.out.println(Arrays.toString(sumTarget(A1, K1)));

        int[] A2 = {1, 2, 3, 7, 5};
        int K2 = 5;

        System.out.println(Arrays.toString(sumTarget(A2, K2)));

        int[] A3 = {1, 2, 3, 7, 5};
        int K3 = 7;

        System.out.println(Arrays.toString(sumTarget(A3, K3)));

        int[] A4 = {1, 2, 3, 7, 5};
        int K4 = 11;

        System.out.println(Arrays.toString(sumTarget(A4, K4)));
    }
}
