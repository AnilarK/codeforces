import java.util.*;

//  https://codeforces.com/problemset/problem/2153/C

public class SymmetricalPolygons {

    public void solve(Scanner sc){
        int n = sc.nextInt();
        TreeMap<Long,Long> m = new TreeMap<>();
        for(int i=0;i<n;i++){
            long x = sc.nextLong();
            m.put(x,m.getOrDefault(x,0L)+1);
        }

        long ans = 0;
        long sideLen = 0;
        long totalSide = 0;

        for(Map.Entry<Long,Long> ent : m.entrySet()){
            if(ent.getValue()>1){
                long t1 = ent.getValue() - ent.getValue()%2;
                long side = ent.getKey();
                ans += t1*side;
                sideLen += (t1/2L)*side;
                totalSide += t1;
                m.put(side,ent.getValue()%2);
            }
        }

        if(totalSide==0) {
            System.out.println(0);
            return;}

        boolean posAns = false;
        long res = ans;
        List<Long> a = new ArrayList<>();
        for(long val : m.keySet()){
            if(m.get(val)==0) continue;
            if(ans >val){
                posAns = true;
                res = Math.max(res,ans + val); }
            a.add(val);}

        int j = 0;
        n = a.size();
        for(int i = 0;i<n;i++){
            j= Math.max(j,i+1);
            while(j<n-1 &&  (ans + a.get(i)) > a.get(j+1)){
                j++;
            }

            if(i!=j && j<n && ans + a.get(i) > a.get(j)){
                posAns = true;
                res = Math.max(res,ans + a.get(i) + a.get(j));
            }
        }

        if(!posAns && totalSide<4) res = 0;
        System.out.println(res);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        SymmetricalPolygons obj = new SymmetricalPolygons();
        while (t>0) {
            obj.solve(sc);
            t--;
        }
    }
}
