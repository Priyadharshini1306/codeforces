import java.util.Scanner;
import java.util.Arrays;
 
public class BOlyaAndGameWithArrays {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
 
            int n = sc.nextInt();
 
            int[] secondMini = new int[n];
            int smallestFirst = Integer.MAX_VALUE;
 
            for (int i = 0; i < n; i++) {
 
                int k = sc.nextInt();
                int[] arr = new int[k];
 
                for (int j = 0; j < k; j++) {
                    arr[j] = sc.nextInt();
                }
 
                Arrays.sort(arr);
 
                secondMini[i] = arr[1];
 
                smallestFirst = Math.min(smallestFirst, arr[0]);
            }
 
            long sumofsec = 0;
 
            for (int i : secondMini) {
                sumofsec += i;
            }
 
            Arrays.sort(secondMini);
 
            long ans = sumofsec - secondMini[0] + smallestFirst;
 
            System.out.println(ans);
        }
 
        sc.close();
    }
}