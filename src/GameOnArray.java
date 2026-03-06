import java.util.*;

//  https://codeforces.com/problemset/problem/2147/D

public class GameOnArray {

    public void solve(Scanner sc){
        int n = sc.nextInt();
        Map<Long,Long> m = new HashMap<>();
        long sum = 0;
        for(int i=0;i<n;i++){
            long num = sc.nextLong();
            sum += num;
            m.put(num,m.getOrDefault(num,0L)+1);
        }

        List<Long> a = new ArrayList<>();
        for(Map.Entry<Long,Long> ent : m.entrySet() ){
            long freq = ent.getKey();
            if(freq%2==1){
                a.add(ent.getValue());
                sum -= a.getLast();
            }
        }
        long ans1 = sum/2L , ans2 = sum/2L;

        a.sort(null);
        for(int i=a.size()-1;i>=0;i--){
            ans1 += a.get(i);
            i--;
            if(i>=0){
                ans2 += a.get(i);
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        GameOnArray obj = new GameOnArray();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
