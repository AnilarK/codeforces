//  https://codeforces.com/problemset/problem/2167/E

import java.util.*;

public class khbaLovesToSleep {

    public static boolean check(long num, long k, long d,List<Long> a){
        long possTel = 0;

        for(int i=0;i<a.size();i++){
            long diff=0;
            if(i==0){
                diff = a.get(i);
                possTel += Math.max(0L,diff-num +1L);
            }
            if(i==a.size()-1){
                diff = d - a.get(i);
                possTel += Math.max(0L,diff-num +1L);
            }
            if(i>0) {
                diff = a.get(i) - a.get(i - 1);
                possTel += Math.max(0L, diff - num - num + 1L);
            }
        }
        return possTel>=k;
    }

    public static void store(List<Long> ans, Set<Long> used, long k, long poss, long i){
        while(ans.size() < k && poss > 0){
            if(!used.contains(i)){
                ans.add(i);
                used.add(i);
            }
            poss--;
            i++;
        }
    }

    public static void print(long num,long k,long d,List<Long> a){
        List<Long> ans = new ArrayList<>();
        Set<Long> used = new HashSet<>();
        for(int i=0;i<a.size();i++){
            long diff=0;
            long possTel = 0;
            if(i==0){
                diff = a.get(i);
                possTel = Math.max(0L,diff-num +1L);
                store(ans,used,k,possTel,0L);
            }
            if(i==a.size()-1){
                diff = d - a.get(i);
                possTel = Math.max(0L,diff-num +1L);
                store(ans,used,k,possTel,a.get(i) +num);
            }
            if(i>0) {
                diff = a.get(i) - a.get(i - 1);
                possTel = Math.max(0L, diff - num - num + 1L);
                store(ans,used,k,possTel,a.get(i-1) +num);
            }
            if(ans.size()==k){break;}
        }

        for(Long val :ans){
            System.out.print(val +" ");
        }
        System.out.println();
    }

    public static void solveCorrect(Scanner sc){

        long n = sc.nextInt();
        long k = sc.nextInt();
        long d = sc.nextInt();

        List<Long> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextLong());
        }
        a.sort(null);

        long lo = 0, hi = d;
        while(hi - lo > 1){
            long mid = (hi+lo)/2;
            if(check(mid,k,d,a)){
                lo = mid;
            } else {
                hi = mid -1;
            }
        }

        if(check(hi,k,d,a)){
            print(hi,k,d,a);
        } else {
            print(lo,k,d,a);
        }
    }

    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            solveCorrect(sc);
            t--;
        }
    }
}
