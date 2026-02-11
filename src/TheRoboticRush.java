import java.util.*;

//https://codeforces.com/problemset/problem/2185/E

public class TheRoboticRush {


    public static int upper_bound(int num,List<Integer> a){
        if(a.isEmpty()) return -1;
        int lo = 0, hi = a.size()-1;
        while(hi-lo>1){
            int mid = (hi+lo)/2;
            if(a.get(mid)<=num){lo=mid;}
            else{hi=mid;}
        }
        if(a.get(lo)>num) return lo;
        if(a.get(hi)>num) return hi;

        if(a.get(hi)<=num) return a.size();
        return -1;
    }

    public static int lower_bound(int num,List<Integer> a){
        if(a.isEmpty()) return -1;
        int lo = 0, hi = a.size()-1;
        while(hi-lo>1){
            int mid = (hi+lo)/2;
            if(a.get(mid)<=num){lo=mid;}
            else{hi=mid;}
        }

        if(a.get(lo)>=num) return lo;
        if(a.get(hi)>=num) return hi;

        if(a.get(hi)<=num) return a.size();
        return -1;
    }

    public static void solve(Scanner sc){

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }

        List<Integer> b = new ArrayList<>();
        for(int i=0;i<m;i++){
            b.add(sc.nextInt());
        }

        Collections.sort(b);

        sc.nextLine();
        StringBuilder s = new StringBuilder(sc.nextLine());

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int death = 0;
        for(int i=0;i<n;i++){
            int num = a.get(i);
            int ind = lower_bound(num,b);
            if(ind!=-1 && ind<b.size() && b.get(ind)==num){
                death++;
            } else {
                if (ind != -1 && ind<b.size()) {
                    right.add(b.get(ind) - num);
                }
                ind--;
                if (ind != -1 ) {
                    left.add(num - b.get(ind));
                }
            }
        }

        Collections.sort(left);
        Collections.sort(right);

        int pos = 0;
        for(int i=0;i<k;i++){
            char c= s.charAt(i);
            if(c=='L'){
                pos--;
                if(pos<0) {
                    int ind = upper_bound(Math.abs(pos), left);
                    if (ind > 0) {
                        death += ind;
                        left.subList(0, ind).clear();
                    }
                }
            }else{
                pos++;
                if(pos>0) {
                    int ind = upper_bound(Math.abs(pos), right);
                    if (ind > 0) {
                        death += ind;
                        right.subList(0, ind).clear();
                    }
                }
            }
            System.out.print( (n -death) + " ");
        }
        System.out.println();
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
