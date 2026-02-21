import java.util.*;

//  https://codeforces.com/problemset/problem/2163/C

public class Monopati {

    static class Pair{
        long first;
        long second;

        Pair(long first,long second){
            this.first = first;
            this.second = second;
        }
    }

    public static void solve(Scanner sc){
        int n = sc.nextInt();
        List<List<Long>> a = new ArrayList<>();
        List<List<Pair>> ans = new ArrayList<>();

        for(int i=0;i<2;i++){
            a.add(new ArrayList<>());
            ans.add(new ArrayList<>());
            for(int j=0;j<n;j++){
                long num = sc.nextInt();
                a.get(i).add(num);
                ans.get(i).add(new Pair(num,num));
            }
        }

        for(int i=1;i<n;i++){
            ans.get(0).get(i).first = Math.min(ans.get(0).get(i-1).first,ans.get(0).get(i).first);
            ans.get(0).get(i).second = Math.max(ans.get(0).get(i-1).second,ans.get(0).get(i).second);
        }
        for(int i=n-2;i>=0;i--){
            ans.get(1).get(i).first = Math.min(ans.get(1).get(i+1).first,ans.get(1).get(i).first);
            ans.get(1).get(i).second = Math.max(ans.get(1).get(i+1).second,ans.get(1).get(i).second);
        }

        Map<Long,Long> m = new HashMap<>();
        for(int i=0;i<n;i++){
            Pair p = new Pair(1000000,0);
            p.first = Math.min(ans.get(0).get(i).first,ans.get(1).get(i).first);
            p.second = Math.max(ans.get(0).get(i).second,ans.get(1).get(i).second);
            m.put(p.first,Math.min(p.second,m.getOrDefault(p.first,(long)n+n)));
        }

        long res =0;
        long hehe = 0;
        for(int i=n+n;i>0;i--){
            if(m.containsKey((long)i)){
                hehe = Math.max(hehe, n + n - m.get((long)i) + 1);
            }
            res += hehe;
        }
        System.out.println(res);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            solve(sc);
            t--;
        }
    }
}
