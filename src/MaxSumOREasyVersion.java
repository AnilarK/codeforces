import java.util.*;

//  https://codeforces.com/problemset/problem/2146/D1

public class MaxSumOREasyVersion {

    public void solve(Scanner sc){
        long l = sc.nextInt();
        long r = sc.nextInt();

        long n = r + 1;
        long k = 1;
        while(k*2 <= r){
            k=k*2;
        }
        long ans = n*r , val = k*2 - 1;

        Set<Long> s = new HashSet<>();
        for(long i=0;i<=r;i++){
            s.add(i);
        }

        System.out.println(ans);
        for(int i = 0;i<=r;i++){
            long p = val - i;
            long k1 = k;
            while(!s.contains(p)){
                if(k1<=p){
                    p = p -k1;}
                k1= k1/2;
            }
            s.remove(p);
            System.out.print(p + " ");
        }

        System.out.println();

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        MaxSumOREasyVersion obj = new MaxSumOREasyVersion();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
