import java.util.*;

//  https://codeforces.com/problemset/problem/2149/E

public class HiddenKnowledgeOfTheAncients {

    public int resolve(int i,int j,int l,int r){
        if(i>j) return 0;
        i = Math.max(i,l);
        j = Math.min(j,r);
        return j - i + 1;
    }

    public void solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }
        Map<Integer,Integer> far = new HashMap<>();
        Map<Integer,Integer> clo = new HashMap<>();
        int farPnt = 0;
        int cloPnt = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            far.put(a.get(i),far.getOrDefault(a.get(i),0)+1);
            clo.put(a.get(i),clo.getOrDefault(a.get(i),0)+1);

            while(farPnt<=i && far.size()>k){
                far.put(a.get(farPnt),far.get(a.get(farPnt))-1);
                if(far.get(a.get(farPnt))==0){
                    far.remove(a.get(farPnt));
                }
                farPnt++;
            }

            while(cloPnt<=i && clo.size()>=k){
                clo.put(a.get(cloPnt),clo.get(a.get(cloPnt))-1);
                if(clo.get(a.get(cloPnt))==0){
                    clo.remove(a.get(cloPnt));
                }
                cloPnt++;
            }

            ans += resolve(i-cloPnt+2,i-farPnt,l,r);
        }
        System.out.println(ans);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        HiddenKnowledgeOfTheAncients obj = new HiddenKnowledgeOfTheAncients();
        while(t>0){
            obj.solve(sc);
            t--;
        }
    }
}
