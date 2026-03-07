import java.util.*;

//  https://codeforces.com/problemset/problem/2135/B

public class ForTheChampion {

    public long askQuery(char c, long k, Scanner sc){
        System.out.println("? " + c + " " + k);
        return sc.nextLong();
    }

    public void printAns(long x, long y){
        System.out.println("! " + x + " " + y);
    }

    public int findInd(long a,long b,List<Long> x,List<Long> y){
        int ind = 0, n = x.size();
        long ans = 1000000000000000000L;
        for(int i = 0;i < n; i++ ){
            long dis = Math.abs(x.get(i) - a);
            dis += Math.abs(y.get(i) - b);
            if(dis < ans ){
                ans = dis;
                ind = i;
            }
        }
        return ind;
    }

    public void solve(Scanner sc){
        int n = sc.nextInt();
        List<Long> x = new ArrayList<>();
        List<Long> y = new ArrayList<>();
        for (int i=0;i<n;i++){
            x.add(sc.nextLong());
            y.add(sc.nextLong());
        }

        long d = 1000000000L, val;
        int ind = findInd(-d*10000L,-d*10000L,x,y);

        askQuery('D',d,sc);
        askQuery('D',d,sc);
        askQuery('L',d,sc);
        val = askQuery('L',d,sc);

        long sum = (2L*d + 2L*d + x.get(ind) + y.get(ind) - val);

        ind = findInd(-d*10000L,d*10000L,x,y);
        askQuery('U',d,sc);
        askQuery('U',d,sc);
        askQuery('U',d,sc);
        val = askQuery('U',d,sc);
        long diff = (2L*d + 2L*d - val + x.get(ind) - y.get(ind));

        long xi = (sum + diff)/2L;
        long yi = sum - xi;

        printAns(xi,yi);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ForTheChampion obj = new ForTheChampion();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
