import java.util.*;

//  https://codeforces.com/problemset/problem/2147/D

public class GameOnArray {

    public void solve(Scanner sc){
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }



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
