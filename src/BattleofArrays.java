import java.util.*;

public class BattleofArrays {

    private static void solve(Scanner sc){
        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeMap<Integer,Integer> a = new TreeMap<>();
        TreeMap<Integer,Integer> b = new TreeMap<>();

        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            a.put(x,a.getOrDefault(x,0)+1);
        }

        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            b.put(x,b.getOrDefault(x,0)+1);
        }

        boolean t = true;
        while( !a.isEmpty() && !b.isEmpty() ){
            int x = a.lastKey() , y = b.lastKey();

            a.put(x,a.get(x)-1);
            if(a.get(x)==0){a.remove(x);}

            b.put(y,b.get(y)-1);
            if(b.get(y)==0){b.remove(y);}

            if(t){
                if(y>x){
                    b.put(y-x,b.getOrDefault(y-x,0)+1);
                }
                a.put(x,a.getOrDefault(x,0)+1);
            }else{
                if(x>y){
                    a.put(x-y,a.getOrDefault(x-y,0)+1);
                }
                b.put(y,b.getOrDefault(y,0)+1);
            }

            if(a.isEmpty()){
                System.out.println("Bob");
            } else if(b.isEmpty()) {
                System.out.println("Alice");
            }

            t = !t;
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
