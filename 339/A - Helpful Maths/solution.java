import java.util.*;
public class AHelpfulMaths {
    public static void main(String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int one = 0,two = 0,three = 0;
        for(int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch=='1') {
                one++;
            } else if(ch=='2') {
                two++;
            } else if(ch=='3') {
                three++;
            } else {
                ;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(one-->0) {
            if(one==0 && two==0 && three==0) {
                sb.append("1");
            } else {
                sb.append("1+");
            }
        }
        while(two-->0) {
            if(two==0 && three==0) {
                sb.append("2");
            } else {
                sb.append("2+");
            }
        }
        while(three-->0) {
            if(three==0) {
                sb.append("3");
            } else {
                sb.append("3+");
            }
        }
        System.out.println(sb.toString());
    }
}