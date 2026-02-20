//  https://codeforces.com/problemset/problem/2167/E

import java.util.*;

public class khbaLovesToSleep {

    public static long sumArray(int i,int j,List<Long> a){
        if(i==0 && j==0) return 0;
        if(i==0){
            return a.get(j-1);
        } else if (j==a.size()) {
            return a.getLast() - a.get(i-1);
        } else{
            return a.get(j-1) - a.get(i-1);
        }
    }

    public static boolean check(long num,long left,long right){
        if(num-left <= right-num) return true;
        return false;
    }

    public static int find(long left,long right,List<Long> a){
        int lo = 0, hi = a.size() -1;
        while(hi-lo>1){
            int mid = (hi+lo)/2;
            if(check(a.get(mid),left,right)){
                lo = mid;
            } else{
                hi = mid;
            }
        }

        if(check(a.get(hi),left,right)){return hi+1;}
        if(check(a.get(lo),left,right)){return lo+1;}
        return 0;
    }



    public static void solve(Scanner sc){

        long n = sc.nextInt();
        long k = sc.nextInt();
        long d = sc.nextInt();

        List<Long> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextLong());
        }

        a.sort(null);

        long left = k-1, right =d+1;
        long leftAns = k-1, rightAns =d+1;
        long sum = 0,maxSum =0;

        List<Long> x = new ArrayList<>();

        for(int i=0;i<n;i++){
            sum += (long) a.get(i);
            x.add(sum);
        }

        long sumI = 0;
        for(int i = 0;i<=k;i++){
            if(left<0){
                sumI = (long)n*right - sum;
            } else if(right>d){
                sumI = sum -(long) n*left;
            } else {
                int ind = find(left,right,a);
                sumI = sumArray(0,ind,x) - (long)ind*left;
                sumI += (long)(n-ind)*right - sumArray(ind,(int)n,x);
            }

            if(sumI>maxSum){
                maxSum = sumI;
                leftAns = left;
                rightAns = right;
            }
            left--;
            right--;
        }

        for(long i=0 ;i<=leftAns;i++){
            System.out.print(i+" ");
        }
        for(long i=rightAns ;i<=d;i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            solve(sc);
            t--;
        }
    }
}
