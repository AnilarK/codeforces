import java.util.*;

//  https://codeforces.com/problemset/problem/2163/B

public class SigaTaKymata {

    public static void solution(int n,List<Integer> a,StringBuilder s, boolean finalTry){
        if(s.charAt(0)=='1' || s.charAt(n-1)=='1'){
            System.out.println("-1");
            return;
        }

        int ind1 = 0,ind2 = 0;
        for(int i=0;i<n;i++){
            int num = a.get(i);
            if(num==1){ind1=i;}
            if(num==n){ind2=i;}
            if( (num==1 || num==n) && s.charAt(i)=='1'){
                System.out.println("-1");
                return;
            }
        }

        System.out.println("5");
        System.out.println("1 " + (ind1+1) );
        System.out.println((ind1+1) + " " + n);
        System.out.println("1 " + (ind2+1) );
        System.out.println((ind2+1) + " " +n);
        System.out.println(Math.min(ind1+1,ind2+1) + " " + Math.max(ind1+1,ind2+1));

    }

    public static void solve(Scanner sc){
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }
        sc.nextLine();
        StringBuilder s = new StringBuilder(sc.nextLine());
        solution(n,a,s,false);
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
