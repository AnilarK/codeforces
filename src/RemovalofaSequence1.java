import java.util.*;

public class RemovalofaSequence1 {

    public static boolean check(long n,long x, long y, long k){
        for(long i=0;i<x;i++){
            n = n - (n/y);
            if(n<k) return false;
        }
        return n >= k;
    }

    public static void solve(Scanner sc){

        long x = sc.nextLong();
        long y = sc.nextLong();
        long k = sc.nextLong();

        long lo = 1, hi = 1000000000000L;
        while(hi-lo>1){

            long mid = (hi+lo)/2L;
            if(check(mid,x,y,k)){
                hi=mid;
            } else{
                lo=mid;
            }
        }

        if(check(lo,x,y,k)){
            System.out.println(lo);
        } else if(check(hi,x,y,k)){
            System.out.println(hi);
        } else {
            System.out.println("-1");
        }

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            solve(sc);
            t--;
        }
    }
}
