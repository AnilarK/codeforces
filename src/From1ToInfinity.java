import java.util.*;

//  https://codeforces.com/problemset/problem/2132/D

public class From1ToInfinity {

    public long check(long x){
        long t = 0,k1=1L;
        long p = 1L;
        while(x>=k1){
            t += Math.min(x-k1+1,9L*k1) *p;
            k1 = k1*10L;
            p++;
        }
        return t;
    }

    public void solve(Scanner sc){
        long k = sc.nextLong();

        long lo = 1, hi = 100L;
        long ans = 0;
        while(hi-lo>=0){
            long mid = (hi+lo)/2L;
            long t = check(mid);
            if(t==k){ans=mid; break;}
            if(t>k){
                hi = mid-1L;
            } else{
                ans = mid;
                lo = mid +1L;
            }
        }

        long sum = 45;
        if(ans<=9){
            sum = (ans*(ans+1))/2L;
            k = k -9;
            ans = 9;
        } else {
            long n = ((ans-9)/10L);
            sum += ((110L + (n-1L)*10L)*n)/2L;
            if(n==0){ans = 9;}
            else{
                ans = ans - ans%10;}
            k = k - check(ans);
        }

        long p = 10;
        while(k>0){
            ans++;
            while(p<ans){
                p = p*10;
            }
            long x = ans,p1 = p;
            while(x!=0 && k>0 && p1>0){
                sum += x/p1;
                x = x%p1;
                p1 = p1/10L;
                k--;
            }
        }

        System.out.println(sum);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        From1ToInfinity obj = new From1ToInfinity();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
