import java.util.*;

public class TreeColoringEasy {

    public static void solve(Scanner sc){
        int n = sc.nextInt();
        List<List<Integer>> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(new ArrayList<>());
        }
        int ans = 0;
        for(int i=1;i<n;i++){
            int u = sc.nextInt() , v = sc.nextInt();
            a.get(u-1).add(v-1);
            a.get(v-1).add(u-1);
        }
        ans = a.get(0).size() + 1;

        Queue<Integer> q = new LinkedList<>();
        List<Integer> vis = new ArrayList<>();
        for(int i=0;i<n;i++){vis.add(0);}
        q.add(0);
        vis.set(0,1);
        while(!q.isEmpty()){
            n = q.size();
//            System.out.println(n);
            ans = Math.max(ans,n);
            for(int k=0;k<n;k++){
                int i = q.poll();
                ans = Math.max(ans,a.get(i).size());
                for(int j=0;j<a.get(i).size();j++){
                    if(vis.get(a.get(i).get(j))==0){
                        vis.set(a.get(i).get(j),1);
                        q.add(a.get(i).get(j));
                    }
                }
            }
        }

        System.out.println(ans);
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
