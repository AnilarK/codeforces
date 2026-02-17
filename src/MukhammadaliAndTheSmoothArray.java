import java.util.*;

// https://codeforces.com/problemset/problem/2167/G

public class MukhammadaliAndTheSmoothArray {

    public static void solve(Scanner sc){
        int n = sc.nextInt();
        long sum = 0;
        List<Long> a = new ArrayList<>();
        List<Long> b = new ArrayList<>();
        List<Long> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            a.add(sc.nextLong());
        }

        for(int i=0;i<n;i++){
            b.add(sc.nextLong());
            sum+=b.getLast();
        }

        long res = 0;
        for(int j=0;j<n;j++){
            long res1 = b.get(j);
            for(int i=0;i<j;i++){
                if(a.get(i)<=a.get(j)){
                    res1 = Math.max(res1, ans.get(i) + b.get(j));
                }
            }
            ans.add(res1);
            res = Math.max(res,res1);
        }

        System.out.println(sum - res);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            solve(sc); t--;
        }
    }
}
