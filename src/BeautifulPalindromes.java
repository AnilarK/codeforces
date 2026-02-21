import java.util.*;

//  https://codeforces.com/problemset/problem/2162/E

public class BeautifulPalindromes {

    public static int diff(int n,List<Integer> a){
        int num = 1;
        int len = a.size();
        while(num==a.getLast() || num==a.get(len-2)){
            num++;
        }
        return Math.min(num, n);
    }

    public static void solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<n;i++){
            s.add(i+1);
        }
        for(int i =0;i<n;i++){
            a.add(sc.nextInt());
            s.remove(a.getLast());
        }

        while(k>0){
            int num = 0;
            if(!s.isEmpty()){
                num = s.iterator().next();
                s.remove(num);
            } else {
                num = diff(n,a);
            }
            a.add(num);
            System.out.print(num + " ");
            k--;
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
