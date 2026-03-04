import java.util.*;

//  https://codeforces.com/problemset/problem/2150/B

public class GridCounting {

    public void solve(Scanner sc){
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i = 0;i<n;i++){
            a.add(sc.nextInt());
        }



    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        GridCounting obj = new GridCounting();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
