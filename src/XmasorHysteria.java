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

//        System.out.println(x);

        int left = n;
        n--;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(left>=m && x.get(n).first <= x.get(n-1).first){
                ans.add(new ArrayList<>(Arrays.asList(x.get(n).second + 1,x.get(n-1).second + 1 )));
                n-=2;
                left-=2;
                m-=2;
                i--;
            } else if(left/2 == m){
                ans.add(new ArrayList<>(Arrays.asList(x.get(n).second + 1,x.get(i).second + 1 )));
                n--;
                left-=2; m--;
            } else {
                x.get(n).first -= a.get(x.get(i).second);
                left--; m--;
                ans.add(new ArrayList<>(Arrays.asList(x.get(i).second + 1,x.get(n).second + 1 )));
            }

           while(n>=0 && x.get(n).first == 0 ){
               n--;
               m--;
               left--;
           }
//            System.out.println(x);
        }

        if (m!=0){
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
