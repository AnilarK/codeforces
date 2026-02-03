import java.util.*;

public class ClusterComputingSystem {

    private static Long gcd(Long a,Long b) {
        if (b == 0) {return a;}
        return gcd(b, a % b);
    }

    private static void solve(Scanner sc){
        int n = sc.nextInt();
        List<Long> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextLong());
        }

        Long ans=0L, p=a.getFirst();
        List<Long> res = new ArrayList<>();
        res.add(p);

        for(int i=1;i<n;i++){
            p = gcd(p,a.get(i));
            res.add(p);}
//        ans+=p;
        p = a.getLast();

//        System.out.println(res);
        for(int i=n-2;i>=0;i--){
            p = gcd(p,a.get(i));
            ans+= Math.min(res.get(i), p);
        }

        System.out.println(ans);

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        sc.nextLine();
        while (testcases>0){
            solve(sc);
            testcases--;
        }
    }

}

