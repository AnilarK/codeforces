import java.util.*;

public class MortalKombatTower {

    private static int dp(int i,boolean include, List<Integer> a,List<List<Integer>> memo){
        if(i>=a.size()) return 0;
        int res;
        int inc = include ? 1 : 0;
        if(memo.get(i).get(inc)!=-1){
            return memo.get(i).get(inc);
        }
        if(!include){
            res = Math.min(dp(i+1,true,a, memo),dp(i+2,true,a,memo));
        } else {
            res = a.get(i) + dp(i+1,false,a,memo);
            if(i+1<a.size()) {
                res = Math.min(res, a.get(i) + a.get(i + 1) + dp(i + 2, false, a, memo));
            }
        }

        memo.get(i).set(inc,res);
        return res;
    }

    private static void solve(Scanner sc){
        int n = sc.nextInt();

        List<Integer> a = new ArrayList<>(n);
        for(int i=0;i<n ;i++) {
            a.add(sc.nextInt());
        }

        List<List<Integer>> memo = new ArrayList<>();
        for(int i=0;i<n;i++){
            memo.add(Arrays.asList(-1,-1));
        }

        System.out.println(dp(0,true,a,memo));
    }

    private static void solveV2(Scanner sc){
        int n = sc.nextInt();

        List<Integer> a = new ArrayList<>(n);
        List<List<Integer>> memo = new ArrayList<>();
        for(int i=0;i<n+2;i++){
            memo.add(new ArrayList<>(List.of(0,0)));
        }

        for(int i=0;i<n ;i++) {
            a.add(sc.nextInt());
        }

        for(int i=n-1;i>=0;i--){
            int inclu = a.get(i) + memo.get(i+1).get(1);
            if(i+1<n){
                inclu = Math.min(inclu, a.get(i) + a.get(i+1) + memo.get(i+2).get(1));
            }

            int not_inclu = Math.min(
                   memo.get(i+1).get(0), memo.get(i+2).get(0));

            memo.get(i).set(0,inclu);
            memo.get(i).set(1,not_inclu);
        }

        System.out.println(memo.getFirst().get(0));
    }

    public static void main(String args[]){
        int testcases;
        Scanner sc = new Scanner(System.in);
        testcases = sc.nextInt();

        while(testcases>0){
            solveV2(sc);
//            System.out.println("chutney");
            testcases--;
        }
    }
}
