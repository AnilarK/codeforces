import java.util.*;

//https://codeforces.com/contest/2171/problem/D

public class RaeTaylorAndTreesEasy {

    public static int findPar(int num, Map<Integer,Integer> m){
        if(m.containsKey(num)){
            return m.put(num, findPar(m.get(num),m) );
        }
        return num;
    }

    public static void solve(Scanner sc){

        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }

        Stack<Integer> s = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,Integer> m = new TreeMap<>();
        for(int i=n-1;i>=0;i--){
            int num = a.get(i);
            while(!s.empty() && findPar(s.peek(),m)>num ){
                int val = findPar(s.pop(),m);
                if(m.containsKey(num) && m.get(num) <val){
                    m.put(num,val);}
                else if(!m.containsKey(num)){
                    m.put(num,val);}
                ans.add(new ArrayList<>(Arrays.asList(num, val)));
            }
            s.add(num);
        }

        int last = s.pop();
        while(!s.empty()){
            int num = findPar(s.pop(),m);
            if(num<last) break;
            ans.add(new ArrayList<>(Arrays.asList(num, last)));
        }

        if(ans.size()!=n-1){
            System.out.println("NO");
        } else{
            System.out.println("YES");
//            for (List<Integer> an : ans) {
//                System.out.println(an.getFirst() + " " + an.getLast());
//            }
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
