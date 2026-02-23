import java.util.*;

//  https://codeforces.com/problemset/problem/2161/B

public class MakeConnected {

    static int total = 0;
    public static boolean validate(int n, List<String> a){
        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0; i<n; i++){
            int start_i = -1;
            for(int j=0;j<n;j++){
                if(a.get(i).charAt(j)=='#'){
                    if(start_i==-1){start_i = j;}
                    if(!m.containsKey(j)){
                        m.put(j,i);}
                    if( (j-start_i)>1 || (i-m.get(j))>1 ){
                        System.out.println("NO");
                        return true;}
                }
            }
        }
        return false;
    }

    public static boolean alreadyCorrect(int n,List<String> a){
        int hmm = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a.get(i).charAt(j)=='#'){total++;}
                if(j<n-1 && a.get(i).charAt(j)=='#' && a.get(i).charAt(j+1)=='#'
                    && i<n-1 && a.get(i+1).charAt(j)=='#' && a.get(i+1).charAt(j+1)=='#'){
                    hmm=1;
                }
            }
        }
        if(total==4 && hmm == 1){
            System.out.println("YES");
            return true;}

        return false;
    }

//    DownLeft
//    DownRight
//    leftDown
//    rightDown

    public static boolean check(int i,int j,int n){
        if(i>=0 && j>=0 && i<n && j<n){return true;}
        return false;
    }

    public static boolean downLeft(int i,int j,int n,List<String>a){
        int testTotal = 0;
        int p = 0;
        while(check(i,j,n)){
            if(a.get(i).charAt(j)=='#'){testTotal++;}
            if(p==0){i++;}
            else{j--;}
            p = 1 -p;
        }
        return testTotal==total;
    }

    public static boolean downRight(int i,int j,int n,List<String>a){
        int testTotal = 0;
        int p = 0;
        while(check(i,j,n)){
            if(a.get(i).charAt(j)=='#'){testTotal++;}
            if(p==0){i++;}
            else{j++;}
            p = 1 -p;
        }
        return testTotal==total;
    }

    public static boolean leftDown(int i,int j,int n,List<String>a){
        int testTotal = 0;
        int p = 1;
        while(check(i,j,n)){
            if(a.get(i).charAt(j)=='#'){testTotal++;}
            if(p==0){i++;}
            else{j--;}
            p = 1 -p;
        }
        return testTotal==total;
    }

    public static boolean rightDown(int i,int j,int n,List<String>a){
        int testTotal = 0;
        int p = 1;
        while(check(i,j,n)){
            if(a.get(i).charAt(j)=='#'){testTotal++;}
            if(p==0){i++;}
            else{j++;}
            p = 1 -p;
        }
        return testTotal==total;
    }


    public static void actuallySolve(int n,List<String> a){
        for(int i=0;i<n;i++){
            if(downLeft(0,i,n,a) || downRight(0,i,n,a) || leftDown(0,i,n,a) || rightDown(0,i,n,a)){
                System.out.println("YES");
                return; }
        }

        for(int i=0;i<n;i++){
            if(downRight(i,0,n,a) || rightDown(i,0,n,a)){
                System.out.println("YES");
                return; }
        }

        for(int i=0;i<n;i++){
            if(downLeft(i,n-1,n,a) || leftDown(i,n-1,n,a)){
                System.out.println("YES");
                return; }
        }

        System.out.println("NO");
    }

    public static void solve(Scanner sc){
        int n = sc.nextInt();
        sc.nextLine();

        List<String> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextLine());
        }

        if( validate(n,a) ){ return;}
        if(alreadyCorrect(n,a)){ return;}
        actuallySolve(n,a);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            total = 0;
            solve(sc);
            t--;
        }
    }
}
