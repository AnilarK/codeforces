import java.util.*;

//  https://codeforces.com/problemset/problem/2137/E

public class Mexification {

    public List<Long> doMex(List<Long> a){
        long val = 0, n = a.size();
        Map<Long,Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            m.put(a.get(i),m.getOrDefault(a.get(i),0)+1);
        }
        while(m.containsKey(val)){
            val++; }
        List<Long> x = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(a.get(i)>val){x.add(val);}
            else if(m.get(a.get(i))==1){ x.add(a.get(i));}
            else{x.add(val);}
        }
//        System.out.println(x);
        return x;
    }

    public long sum(List<Long> a){
        long sum = 0;
        for(long val : a){
            sum += val; }
        return sum;
    }

    public void solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Long> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextLong());
        }

        long ans = 0;
        a = doMex(a);
        if(k==1){ans = sum(a);}
        else{
            a = doMex(a);
            if(k%2==0){ans = sum(a);}
            else{
                a = doMex(a);
                ans = sum(a);
            }
        }

        System.out.println(ans);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Mexification obj = new Mexification();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
