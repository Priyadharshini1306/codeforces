import java.util.*;
public class ABoyOrGirl {
    public static void main(String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<userName.length();i++) {
            set.add(userName.charAt(i));
        }
        if(set.size()%2==0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    } 
}