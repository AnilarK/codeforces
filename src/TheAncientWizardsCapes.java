import java.util.*;

//  https://codeforces.com/problemset/problem/2155/C

public class TheAncientWizardsCapes {

    public int verify(StringBuilder s,List<Integer> a){
        int lCnt = 0, rCnt = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L'){lCnt++;}
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R'){rCnt++;}

            if( (lCnt+rCnt) != a.get(i)){return 0;}

            if(s.charAt(i)=='L'){lCnt--;}
        }
        return 1;
    }

    public int doIt(char first, List<Integer> a) {
        StringBuilder s = new StringBuilder();
        s.append(first);
        int n = a.size();
        for(int i=1;i<n;i++){
            if(Objects.equals(a.get(i - 1), a.get(i))){
                if(s.charAt(i-1)=='L'){
                    s.append('R');
                }else{
                    s.append('L');
                }
            } else if(a.get(i-1)>a.get(i)){
                if(s.charAt(i-1)=='L'){
                    s.append('L');
                }else{
                    return 0;
                }
            } else if(a.get(i-1)<a.get(i)){
                if(s.charAt(i-1)=='R'){
                    s.append('R');
                }else{
                    return 0;
                }
            }
        }

        return verify(s,a);
    }

    public void solve(Scanner sc){
        int n = sc.nextInt();
        int ans = 0;
        List<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }

        ans += doIt('L', a);
        ans += doIt('R', a);

        System.out.println(ans);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t =  sc.nextInt();
        TheAncientWizardsCapes obj = new TheAncientWizardsCapes();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
