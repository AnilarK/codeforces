import java.util.*;

//https://codeforces.com/problemset/problem/2182/D

public class ChristmasTreeDecoration {

    public static long fact(long n){
        long mo = 998244353, ans = 1;
        for(long i=2;i<=n;i++){
            ans = (ans*i)%mo;
        }
        return ans;
    }

    static final int MOD = 998244353;

    static long power(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) result = (result * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }

    static long modInverse(long x) {
        return power(x, MOD - 2);
    }

    static long nCr(long n, long r) {
        if (r < 0 || r > n) return 0;
        long num = 1;
        long den = 1;

        for (long i = 1; i <= r; i++) {
            num = (num * (n - i + 1)) % MOD;
            den = (den * i) % MOD;
        }

        return (num * modInverse(den)) % MOD;
    }


    public static void solve(Scanner sc){
        int n = sc.nextInt();
        List<Long> a = new ArrayList<>();
        long ex = sc.nextLong();
        for(int i=0;i<n;i++){
            a.add(sc.nextLong());
        }
        Collections.sort(a);
        Collections.reverse(a);

        long maxNum = a.getFirst() -1, count = 1;
        for(int i=1;i<n;i++){
            if(a.get(i)>maxNum){
                count++;
                continue;}
            ex = ex - (maxNum - a.get(i));
        }

        long ans =1, mo =998244353;
        long rem = n - count;
        if(ex<0){
            System.out.println("0");
            return;
        }
        if(ex >= rem){
            ans = fact(n);
        } else{
            ans=ans*fact(count+ex)%mo;
            ans = (ans*fact(rem-ex))%mo;
            ans = (ans*nCr(rem,ex))%mo;
        }

        System.out.println(ans);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            solve(sc);
            t--;
        }
    }
}

