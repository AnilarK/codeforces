import java.util.*;


//        https://codeforces.com/problemset/problem/2162/C

public class BeautifulXOR {

    public static void solve(Scanner sc){
        int a = sc.nextInt();
        int b = sc.nextInt();

        int a1=a;
        List<Integer> ans = new ArrayList<>();
        Integer val =1;
        while(a>0 || b >0){
            if(a%2 != b%2){
                if(val>a1){
                    System.out.println("-1");
                    return;
                }
                ans.add(val);
            }
            val = val*2;
            a = a/2;
            b = b/2;
        }


        System.out.println(ans.size());
        for(Integer res : ans){
            System.out.print(res + " ");
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
        return;
    }

}
