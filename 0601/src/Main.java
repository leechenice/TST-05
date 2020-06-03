import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> hashSet = new HashSet<>();
        while (in.hasNextLine()) {
            hashSet.add(in.next());
//            String s = in.nextLine();
//            int p = 0;
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) == ' ') {
//                    hashSet.add(s.substring(p,i-1));
//                }
//            }a
        }
        System.out.println(hashSet.size());

    }
}
