import java.util.*;

//https://codeforces.com/problemset/problem/2185/E

public class TheRoboticRush {


//    public static int upper_bound(int num,List<Integer> a){
//        if(a.isEmpty()) return -1;
//        int lo = 0, hi = a.size()-1;
//        while(hi-lo>1){
//            int mid = (hi+lo)/2;
//            if(a.get(mid)<=num){lo=mid;}
//            else{hi=mid;}
//        }
//        if(a.get(lo)>num) return lo;
//        if(a.get(hi)>num) return hi;
//
//        if(a.get(hi)<=num) return a.size();
//        return -1;
//    }

    public static int lower_bound(int num,List<Integer> a){
        if(a.isEmpty()) return -1;
        int lo = 0, hi = a.size()-1;
        while(hi-lo>1){
            int mid = (hi+lo)/2;
            if(a.get(mid)<=num){lo=mid;}
            else{hi=mid;}
        }
        if(a.get(hi)==num) return hi;
        if(a.get(lo)>=num) return lo;
        if(a.get(hi)>=num) return hi;
        if(a.get(hi)<=num) return a.size();
        return -1;
    }

    public static boolean check(int i,int j,int a,int b){
        if(i!=-1 && a>=i) return true;
        if(j!=-1 && b>=j) return true;
        return false;
    }

    public static int findInd(int leftB,int rightB,List<Integer>left,List<Integer>right,int k){
        int lo=0,hi=k-1;
        while(hi-lo>1){
            int mid = (hi+lo)/2;
            if(check(leftB,rightB,left.get(mid),right.get(mid))){
                hi=mid;
            } else{
                lo=mid;
            }
        }
        if(check(leftB,rightB,left.get(lo),right.get(lo))){
            return lo;
        }
        if(check(leftB,rightB,left.get(hi),right.get(hi))){
            return hi;
        }
        return -1;
    }

    public static void solve(Scanner sc){

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }

        List<Integer> b = new ArrayList<>();
        for(int i=0;i<m;i++){
            b.add(sc.nextInt());
        }

        Collections.sort(b);

        sc.nextLine();
        StringBuilder s = new StringBuilder(sc.nextLine());

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int left_max=0,right_max=0,pos=0;
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='L'){
                pos--;
                if(pos<0 && Math.abs(pos)>left_max){
                    left_max = Math.abs(pos);
                }
            } else{
                pos++;
                if(pos>right_max){
                    right_max = pos;
                }
            }
            left.add(left_max);
            right.add(right_max);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<k;i++){ans.add(0);}

        for(int i=0;i<n;i++){
            int num = a.get(i);
            int ind = lower_bound(num,b);
            int leftB=-1,rightB=-1;

            if(ind==-1){
            }else if(ind==b.size()){
                leftB = (num - b.get(ind-1));
            }else {
                rightB = (b.get(ind)-num);
                if(ind-1>=0){
                    leftB = (num - b.get(ind-1));}
            }

            ind = findInd(leftB,rightB,left,right,k);

            if(ind!=-1){
                ans.set(ind,ans.get(ind)+1);
            }

        }






        int sum =0;
        for(int i=0;i<k;i++){
            sum+=ans.get(i);
            System.out.print( n - sum + " ");
        }System.out.println();

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
