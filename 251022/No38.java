import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for ( int r = 0 ; r < b ; r++ ){
            for ( int c = 0 ; c < a ; c++ ){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
