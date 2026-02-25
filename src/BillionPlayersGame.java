import java.util.*;
import static java.util.Collections.sort;

//  https://codeforces.com/problemset/problem/2157/D

public class BillionPlayersGame {

    public static void solve(Scanner sc){
        long n = sc.nextInt();
        long l = sc.nextInt();
        long r = sc.nextInt();

        List<Long> a = new ArrayList<>();

        long exSum = 0;
        long cnt = 0, s = 0;
        for(int i=0;i<n;i++){
            long x = sc.nextInt();
            if(x<l){
                exSum -= x; cnt ++;
            } else if(x>r){
                exSum += x; cnt--;
            }else {
                a.add(x); s+=x;
            }
        }

        n = a.size();
        Collections.sort(a);

        long ans = 0,ans1= 0,sum = 0;
        for(int i=0;i<=n;i++){
            long tempAns = 0, tempAns1 = 0;
            long left = 0, right= 0;

        //  without Skipping
            left = ( (s-sum) - (n-i)*(l) )  - (sum - (i)*l )  + exSum + cnt*l;
            right = ((i)*r -sum) - ( (n-i)*(r) - (s-sum) )  + exSum + cnt*r;
            tempAns = Math.min(left,right);
            ans = Math.max(ans,tempAns);

            if(i==n){continue;}
            sum += a.get(i);
        //  with Skipping
            left =  ( (s-sum) - (n-i-1)*(l) )  - (sum - (i*l) - a.get(i) )  + exSum + cnt*l;
            right = ( (i)*r - sum + a.get(i)) - ( (n-i-1)*(r) - (s-sum) )  + exSum + cnt*r;
            tempAns1 = Math.min(left,right);

            ans1 = Math.max(ans1,tempAns1);
        }
        System.out.println(Math.max(ans,ans1));
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
