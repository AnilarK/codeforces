import java.util.*;

public class BattleCows {

    public static int findXor(int i,int j,List<Integer> a,List<Integer>num,int k,int p){
        int ans = a.get(j);
        if(i!=0){
            ans=  ans^a.get(i-1);
        }
        if(k>=i && k<=j){
            ans=ans^num.get(k);
            ans=ans^p;
        }
        return ans;
    }

    public static void solve(Scanner sc){
        int n = sc.nextInt();
        int q = sc.nextInt();
        int final_n = 1<<n , x=0;

        List<Integer> a = new ArrayList<>();
        List<Integer> pref = new ArrayList<>();
        for(int i=0;i<final_n;i++){
            a.add(sc.nextInt());
            x=x^a.getLast();
            pref.add(x);
        }

        while(q>0){
            int j = sc.nextInt(); j--;
            int p = sc.nextInt();

            int n1 = 1, ans=0;
            for(int i=0;i<n;i++){
                int pos = (j+n1)/n1;
                int start_pos = j - j%n1;
                int end_pos = start_pos + n1 -1;

                int start_pos2, end_pos2;
                if( pos%2 ==0){
                    start_pos2 = start_pos - n1;
                    end_pos2 = start_pos -1;
                } else {
                    start_pos2 = end_pos + 1;
                    end_pos2 = start_pos2 + n1-1;
                }

                int xor_curr = findXor(start_pos,end_pos,pref,a,j,p);
                int xor_opp= findXor(start_pos2,end_pos2,pref,a,j,p);

                if(xor_curr < xor_opp){
                    ans+=n1;
                } else if( xor_curr==xor_opp && pos%2==0){
                    ans+=n1;
                }

                n1=n1*2;
            }

            System.out.println(ans);
            q--;
        }

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
