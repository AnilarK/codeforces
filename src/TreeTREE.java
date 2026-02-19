import java.util.*;
//  https://codeforces.com/problemset/problem/2167/F

public class TreeTREE {

    public static long dfs(int i,int par,int k,List<Long> x,List<Long>ans,List<List<Integer>> a){
        long beneath = 0 , n= ans.size();
        List<Long> p = new ArrayList<>();
        for(int j=0;j<a.get(i).size();j++){
            if(a.get(i).get(j)==par) continue;
            long beneathLocal = 1 + dfs(a.get(i).get(j),i,k,x,ans,a);
            p.add(beneathLocal);
            beneath += beneathLocal;
        }
        p.add(n - beneath -1);

        long ansForI = 1;

        for (int i1 = 0; i1 < p.size(); i1++) {
            if ((n - p.get(i1)) > k) {
                ansForI += p.get(i1);
            }
        }

        x.set(i,beneath);
        ans.set(i,ansForI);
        return beneath;
    }

    public static void solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt() -1;

        List<List<Integer>> a = new ArrayList<>();
        List<Long> x = new ArrayList<>();
        List<Long> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(new ArrayList<>());
            x.add(0L);
            ans.add(0L);
        }
        for(int i=1;i<n;i++){
            int u = sc.nextInt() -1;
            int v = sc.nextInt() -1;
            a.get(u).add(v);
            a.get(v).add(u);
        }

        dfs(0,-1,k,x,ans,a);

//        System.out.println(x);
//        System.out.println(ans);
        int res = 0;
        for(int i=0;i<n;i++){
            res+=ans.get(i);
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
