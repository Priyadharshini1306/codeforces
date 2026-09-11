import java.util.*;
public class BArrayMerging {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
 
            int n = sc.nextInt();
 
            int[] a = new int[n];
            int[] b = new int[n];
 
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
 
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
 
            int[] maxA = new int[2 * n + 1];
            int[] maxB = new int[2 * n + 1];
 
            // Find longest consecutive occurrence in a
            int count = 1;
 
            for (int i = 1; i < n; i++) {
 
                if (a[i] == a[i - 1]) {
                    count++;
                } else {
                    maxA[a[i - 1]] = Math.max(maxA[a[i - 1]], count);
                    count = 1;
                }
            }
 
            // Last group
            maxA[a[n - 1]] = Math.max(maxA[a[n - 1]], count);
 
 
            // Find longest consecutive occurrence in b
            count = 1;
 
            for (int i = 1; i < n; i++) {
 
                if (b[i] == b[i - 1]) {
                    count++;
                } else {
                    maxB[b[i - 1]] = Math.max(maxB[b[i - 1]], count);
                    count = 1;
                }
            }
 
            // Last group
            maxB[b[n - 1]] = Math.max(maxB[b[n - 1]], count);
 
 
            int ans = 0;
 
            for (int i = 1; i <= 2 * n; i++) {
                ans = Math.max(ans, maxA[i] + maxB[i]);
            }
 
            System.out.println(ans);
        }
    }
}