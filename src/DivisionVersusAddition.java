import java.util.*;

//  https://codeforces.com/problemset/problem/2152/D

public class DivisionVersusAddition {

    public void solve(Scanner sc){
        int n = sc.nextInt();
        int q = sc.nextInt();
        List<Long> a = new ArrayList<>();
        a.add(0L);
        for(int i=0;i<n;i++){
            a.add(sc.nextLong());
        }

        List<Long> pre = new ArrayList<>();
        List<Long> fre = new ArrayList<>();
        pre.add(0L);
        fre.add(0L);

        Set<Long> spc = new HashSet<>();
        long k =1;
        for(int i=0;i<40;i++){
            k = k*2L;
            spc.add(k+1);
        }

        long sum = 0;
        for(int i=1;i<=n;i++){
            long num = a.get(i), cnt=0;
            long f = fre.getLast();
            if(spc.contains(num)){f++;}
            while(num>1){
                num = num/2;
                if(num!=1){num++;}
                cnt++;
            }

            sum += cnt;
            pre.add(sum);
            fre.add(f);
        }

//        System.out.println(fre);
//        System.out.println(pre);

        for(int i = 0;i<q;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();

            long ans = pre.get(r) - pre.get(l-1);
            long f = fre.get(r) - fre.get(l-1);
            if(f>0){
                ans += f/2; }
            System.out.println(ans);

        }

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        DivisionVersusAddition obj = new DivisionVersusAddition();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}