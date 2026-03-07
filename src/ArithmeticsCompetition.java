import java.util.*;

//  https://codeforces.com/problemset/problem/2132/E

public class ArithmeticsCompetition {

    public void solve(Scanner sc){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }
        for(int i=0;i<m;i++){
            b.add(sc.nextInt());
        }



        for(int i=0;i<q;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();



        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArithmeticsCompetition obj = new ArithmeticsCompetition();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
