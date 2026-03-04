import java.util.*;

//  https://codeforces.com/problemset/problem/2152/D

public class DivisionVersusAddition {

    public int findOp(long num){
        int cnt = 0;
        while(num>1){
            num = num/2;
            if(num!=1){num++;}
            cnt++;
        }
        return cnt;
    }

    public void resolve(long num, List<Long> a, List<Long> fre){
        int x = findOp(num);
        int x1 = findOp(num+1L);
        a.add(a.getLast() + x1);

        if(x1!=x){
            fre.add(fre.getLast() + 1);
        } else {
            fre.add(fre.getLast());
        }
    }

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

        for(int i=1;i<=n;i++){
            resolve(a.get(i),pre,fre);
        }

        for(int i = 0;i<q;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();

            long ans = pre.get(r) - pre.get(l-1);
            long f = fre.get(r) - fre.get(l-1);

            if(f!=0){
                ans -= (f+1)/2; }
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
