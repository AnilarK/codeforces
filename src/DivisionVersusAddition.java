import java.util.*;

//  https://codeforces.com/problemset/problem/2152/D

public class DivisionVersusAddition {

    public void solve(Scanner sc){
        int n = sc.nextInt();
        int q = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        DivisionVersusAddition obj = new DivisionVersusAddition();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
