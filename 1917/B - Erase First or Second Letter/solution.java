import java.util.Scanner;
public class BEraseFirstOrSecondLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            int[] a = new int[26];
            int cnt = 0;
            int ans = 0;
            for(int i = 0;i<n;i++) {
                if(a[s.charAt(i)-'a']==0) {
                    a[s.charAt(i)-'a']=1;
                    cnt++;
                }
                ans += cnt;
 
            }
            System.out.println(ans);
        }
    }
}