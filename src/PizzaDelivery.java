import java.util.*;

//https://codeforces.com/problemset/problem/2193/F


public class PizzaDelivery {

    public static void solve(Scanner sc){
        long n = sc.nextLong();
        long ax=sc.nextLong(), ay=sc.nextLong();
        long bx=sc.nextLong(), by=sc.nextLong();

        List<Long> x = new ArrayList<>();
        TreeMap<Long,Pair> m = new TreeMap<>();

        for(int i=0;i<n;i++){
            x.add(sc.nextLong());
            m.put(x.getLast(),new Pair((int)1e9,(int)-1e9));
        }
        for(int i=0;i<n;i++){
            long y = sc.nextLong();
            Pair p = m.get(x.get(i));
            p.first = Math.min(p.first,y);
            p.second = Math.max(p.second,y);
            m.put(x.get(i),p);
        }
        m.put(ax,new Pair(ay,ay));
        m.put(bx,new Pair(by,by));
        long ans = bx-ax;
        List<Pair> a = new ArrayList<>();
        a.add(new Pair(0L,0L));
        Pair prev = null;
        for(Pair p: m.values()){
            if(prev!=null){
                long diff = p.second - p.first;
                long first = Math.min(
                        a.getLast().first + Math.abs(p.first - prev.first),
                        a.getLast().second + Math.abs(p.first - prev.second));
                long second = Math.min(
                        a.getLast().first + Math.abs(p.second - prev.first),
                        a.getLast().second + Math.abs(p.second - prev.second));
                a.add(new Pair(second + diff ,first + diff));
            }
            prev = p;
        }

        ans+= Math.min(a.getLast().first,a.getLast().second);
        System.out.println(ans);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            solve(sc);
        }

    }
}

class Pair {
    long first;
    long second;

    Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}