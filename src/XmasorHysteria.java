import java.util.*;

//https://codeforces.com/problemset/problem/2178/D

public class XmasorHysteria {

    static class Pair {
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object e){
            if(this == e) return true;
            if(!(e instanceof Pair)) return false;
            Pair p = (Pair) e;
            return p.first == this.first && p.second==this.second;
        }

        @Override
        public int hashCode(){
            return Objects.hash(first,second);
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    public static void solve(Scanner sc){
        int n = sc.nextInt();
        int m = n - sc.nextInt();

        List<Integer> a = new ArrayList<>();
        List<Pair> x = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
            x.add(new Pair(a.getLast(),i));
        }

        if (m < (n+1)/2){
            System.out.println("-1");
            return;
        }

        x.sort((p1, p2) -> Integer.compare(p1.first, p2.first));
        List<List<Integer>> ans = new ArrayList<>();

        if(m==n){
            int i = 0;
            while(x.get(n-1).first > x.get(n-2).first){
                ans.add(new ArrayList<>(List.of(x.get(i).second+1,x.get(n-1).second+1)));
                x.get(n-1).first -= x.get(i).first;
                i++; m--;
            }

            if(i>n-2){
                System.out.println("-1");
                return;
            } else{m--;}

            for(int k=i+1;k<n;k++){
                ans.add(new ArrayList<>(List.of(x.get(k).second+1,x.get(k-1).second+1)));
                m--;
            }

        } else {
            int a1 = n-m-1;
            int i = n-a1-a1-1;
            for(int k=1;k<=i;k++){
                ans.add(new ArrayList<>(List.of(x.get(k).second+1,x.get(k-1).second+1)));
                m--;
            }
            i++;
            int j = n-1;

            while( j>i && m!=n-1 ){
                ans.add(new ArrayList<>(List.of(x.get(j).second+1,x.get(i).second+1)));
                j--; i++; m--;
            }
        }

        if(m!=0){
            System.out.println("-1");
            return;
        }

        System.out.println(ans.size());
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t>0){
            solve(sc);
            t--;
        }
    }
}
