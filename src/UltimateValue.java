import java.util.*;

//   https://codeforces.com/problemset/problem/2140/C

public class UltimateValue {

    public void solve(Scanner sc){
        long n = sc.nextInt();
        List<Long> a = new ArrayList<>();

        long ans = 0;
        for(int i=0;i<n;i++){
            a.add(sc.nextLong());
            if(i%2==0){
                ans += a.getLast();
            } else {
                ans -= a.getLast();
            }
        }

        long res = ans;

        List<Long> x = new ArrayList<>();
        long p = 0;
        for(int i=(int)(n-1L);i>=0;i--){
            if(i%2==1){
                p = Math.max(p,a.get(i)+a.get(i)+i);
            }
            x.add(p);
        }
         x = x.reversed();

        p = 0;
        for(int i = 0;i<n;i++){
            if(i%2==1){
                p = Math.max(p,a.get(i)+a.get(i)-i);
            } else {
                res = Math.max(res,ans + x.get(i) - a.get(i) -a.get(i) -i);
                res = Math.max(res,ans + p - a.get(i) -a.get(i) +i);
            }
        }

        if(n>2){
            res = Math.max(res,ans + n-1L - (n+1)%2);}

        System.out.println(res);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        UltimateValue obj = new UltimateValue();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
