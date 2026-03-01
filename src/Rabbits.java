import java.util.*;

//  https://codeforces.com/problemset/problem/2147/C

public class Rabbits {

    public void solve(Scanner sc){
        int n = sc.nextInt();
        sc.nextLine();
        StringBuilder s = new StringBuilder(sc.nextLine());

        for(int i=0;i<n;i++){
            int cnt = 0 , j=i;
            while(j<n && s.charAt(j)=='0'){
                cnt++; j++;
            }

            if(cnt>1){
                i = j + 1 ;
            } else if(cnt==1){
                if(i==0 || i==n-1 || (i<n-2 && s.charAt(i+2)=='0') ){
                    continue;
                } else if( i>1 && s.charAt(i-2)=='0'){
                    s.setCharAt(i,'1');
                } else {
                    System.out.println("NO");
                    return;
                }
            }

        }
        System.out.println("YES");
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Rabbits obj = new Rabbits();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
