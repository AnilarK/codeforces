import java.util.*;

//      https://codeforces.com/problemset/problem/2159/A

public class MADInteractiveProblem {

    public static void print(List<Integer> ans){
        System.out.print("! ");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
        System.out.flush();
    }

    public static int askQuery( Scanner sc,List<Integer> ans){
        int n = ans.size();
        System.out.print("? " + n + " ");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
        System.out.flush();
        return sc.nextInt();
    }
    public static void solve(Scanner sc){
        int n = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n+n;i++){
            ans.add(0);
        }

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(1);
        for(int i=1;i<n+n;i++){
            a.add(i+1);
            int num = askQuery(sc,a);
            if(num!=0){
                ans.set(i,num);
                a.remove(a.size()-1);
                b.add(i+1);
            }
        }

        for(int i=0;i<n+n;i++){
            if(ans.get(i)==0){
                b.add(i+1);
                int num = askQuery(sc,b);
                ans.set(i,num);
                b.remove(b.size()-1);
            }
        }

        print(ans);

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            solve(sc); t--;}
    }
}
