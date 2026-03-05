import java.util.*;

//  https://codeforces.com/problemset/problem/2150/B

public class GridCounting {

    static final long MOD = 998244353;
    static final int MAX_N = 200000; // set according to constraints

    static long[] fact = new long[MAX_N + 1];
    static long[] invFact = new long[MAX_N + 1];

    static long modPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    static void precompute() {
        fact[0] = 1;

        for (int i = 1; i <= MAX_N; i++)
            fact[i] = (fact[i - 1] * i) % MOD;

        invFact[MAX_N] = modPow(fact[MAX_N], MOD - 2);

        for (int i = MAX_N - 1; i >= 0; i--)
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
    }

    static long nCp(long n1, long r1) {
        int n = (int)n1 , r = (int)r1;
        if (r < 0 || r > n || n<0) return 1;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    public void solve(Scanner sc){
        int n = sc.nextInt();
        long sum = 0;

        List<Long> a = new ArrayList<>();
        for(int i = 0;i<n;i++){
            a.add(sc.nextLong());
            sum += a.getLast();
        }
        long mo = 998244353L;
        if(sum!=n){
            System.out.println("0");
            return;}


        sum = 0;
        int last = (n+1)/2;
        long p = 0;

        for(int i=0;i<last;i++){
            sum += a.get(i);

            if(i == last-1 && n%2==1){ p++;}
            else{p+=2;}

            if(sum<p){
                System.out.println("0");
                return;}
        }

        long ans = 1;
        p = 1;
        if(n%2==0){p++;}
        sum = 0;
        for(int i= last-1;i>=0;i--){
           ans = (ans*nCp((int)p,a.get(i)))%mo;
           p = p + 2 - a.get(i);
        }

        System.out.println(ans);
    }

    public static void main(String args[]){
        precompute();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        GridCounting obj = new GridCounting();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
