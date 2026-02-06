import java.util.*;

public class RemovalofaSequence2 {

    public static boolean check(long p, long x,long y,long k){

//        for(long i=0;i<x;){
//            long num = n/y , p = num*y - 1L;
//            if(num==0L) { break;}
//            long times = (n-p-1)/num + 1;
//
//            if(i+times >= x){
//                n = n - (x-i)*num;
//            } else{
//                n = n - times*num;
//            }
//            i+=times;
//            if(n<k) return false;
//        }
//        return n>=k;

        for (long i = 0; i < x;){
            long cur_value = p / y;
            if (cur_value == 0){
                break;
            }
            long where_cur_value_changes = cur_value * y - 1L;
            long actions_in_group = (p - where_cur_value_changes + cur_value - 1L) / cur_value;
            actions_in_group = Math.min(x - i, actions_in_group);
            p -= actions_in_group * cur_value;
            i += actions_in_group;
        }

        return p>=k;
    }

    public static void solve(Scanner sc){
        long x = sc.nextLong();
        long y = sc.nextLong();
        long k = sc.nextLong();

        if(y==1){
            System.out.println("-1");
                return;
            }
        if(k<y){
            System.out.println(k);
            return;
        }

        long lo = 1, hi = 1000000000000L;
        while(hi-lo>1){
            long mid = (hi + lo)/2L;
            if (check(mid, x, y, k)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        if(check(lo,x,y,k)){
            System.out.println(lo);
        } else if(check(hi,x,y,k)){
            System.out.println(hi);
        } else{
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
