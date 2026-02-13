import java.util.*;

public class WarStrategy {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Solution sol = new Solution();
        while(t>0){
            sol.solve(sc);
            t--;
        }
    }
}

class Solution {

    public boolean check(int ans,int left,int right,int m){
        int days = 0;
        int p = ans -1;
        int minP = p/2, maxP = p - minP;

        if(left<minP){
            minP = left;
            maxP = p - minP;
        }

        days += maxP + maxP -1 + minP;

        return days<=m;
    }

    public void solve(Scanner sc){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int left = Math.min(k-1,n-k);
        int right = Math.max(k-1,n-k);

        int lo = 1, hi = n;
        while(hi - lo >1){
            int mid = (hi+lo)/2;
            if(check(mid,left,right,m)){
                lo=mid;
            } else{
                hi=mid;
            }
        }

        if(check(hi,left,right,m)){
            System.out.println(hi);
        }else{
            System.out.println(lo);
        }
    }
}
