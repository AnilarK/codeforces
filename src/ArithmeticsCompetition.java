import java.util.*;

//  https://codeforces.com/problemset/problem/2132/E

public class ArithmeticsCompetition {

    public List<Long> processList(List<Long> a){
        Collections.sort(a);
        a.add(0L);
        Collections.reverse(a);
        List<Long> aSum = new ArrayList<>();
        aSum.add(0L);
        for(int i=1;i<a.size();i++){
            aSum.add(a.get(i)+aSum.getLast());
        }
        return aSum;
    }

    public long findMaxSum(int x,int y,int z,List<Long> a,List<Long> b,List<Long> aSum,List<Long> bSum){
        long sum = bSum.get(Math.min(y,z));
        int lo = Math.max(1,z - Math.min(y,z)), hi = Math.min(x,z);
        while(hi-lo>=0){
            int mid = (hi+lo)/2;
            int ind = z - mid;
            sum = Math.max(sum, aSum.get(mid) + bSum.get(ind));
            if (a.get(mid) > b.get(ind)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return sum;
    }

    public void solve(Scanner sc){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        List<Long> a = new ArrayList<>();
        List<Long> b = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextLong());
        }
        for(int i=0;i<m;i++){
            b.add(sc.nextLong());
        }

        List<Long> aSum = processList(a);
        List<Long> bSum = processList(b);



        for(int i=0;i<q;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            System.out.println(findMaxSum(x,y,z,a,b,aSum,bSum));
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArithmeticsCompetition obj = new ArithmeticsCompetition();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
