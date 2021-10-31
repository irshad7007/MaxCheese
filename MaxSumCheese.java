import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSumCheese {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println("Enter Number of test cases : ");
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            //System.out.println("Enter number of cheese block weights : ");
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            //System.out.println("Enter space separated weights : ");
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }

            MaxSumCheese maxSumCheese = new MaxSumCheese();
            //System.out.println("maximum amount of cheese that the mouse can have : " + maxSumCheese.maxCheeseWeightSum(a, n));
            System.out.println(maxSumCheese.maxCheeseWeightSum(a, n));
        }
    }


    public int maxCheeseWeightSum(int[] ar, int n) {

        if (n > 0) { // base case that is size should be greater than 0
            int include = ar[0];
            int exclude = 0;

            for (int i = 1; i < n; i++) {
                int temp = include;
                include = Integer.max(exclude + ar[i] , include);//when current included,when current not included
                exclude = temp;
            }
            return include;
        }
        return 0; // if empty array
    }

}

