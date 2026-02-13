import java.util.*;

public class TreeColoringHard {

    public static void solve(Scanner sc){
        int n = sc.nextInt();
        List<List<Integer>> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            a.get(u-1).add(v-1);
            a.get(v-1).add(u-1);
        }

        int op = a.getFirst().size() + 1;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> vis = new ArrayList<>();
        for(int i=0;i<n;i++){vis.add(0);}
        q.add(0); vis.set(0,1);
        while(!q.isEmpty()){
            int size = q.size();
            op = Math.max(op,size);

            for(int k=0;k<size;k++){
                int i = q.poll();
                op = Math.max(op,a.get(i).size());
                for(int j=0;j<a.get(i).size();j++){
                    if(vis.get(a.get(i).get(j))==0) {
                        vis.set(a.get(i).get(j), 1);
                        q.add(a.get(i).get(j));
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            vis.set(i,-1);
        }

        q.add(0); vis.set(0,0);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<op;i++){
            ans.add(new ArrayList<>());
        }

        int zop = 0;
        while(!q.isEmpty()){
            int size = q.size();
            LinkedHashSet<Integer> s = new LinkedHashSet<>();
            for(int i=0;i<op;i++){
                s.add( (i+zop)%op);
            }

            for(int k=0;k<size;k++){
                int i = q.poll();
                int color = vis.get(i);
                boolean flag = false;
                if(s.contains(color)){
                    s.remove(color);
                    flag = true;
                }

                for(int j=0;j<a.get(i).size();j++){
                    if(vis.get(a.get(i).get(j))==-1) {
                        q.add(a.get(i).get(j));
                        int key = s.iterator().next();
                        vis.set(a.get(i).get(j), key);
                        ans.get(key).add(a.get(i).get(j)+1);
                        s.remove(key);
                    }
                }

                if(flag){
                    s.add(color);
                }
            }
            zop++;
        }

        ans.get(0).add(1);
        System.out.println(op);
        for(int i=0;i<op;i++){
            System.out.print(ans.get(i).size() + " ");
            for(int j=0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
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