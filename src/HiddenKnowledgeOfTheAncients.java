import java.util.*;

//  https://codeforces.com/problemset/problem/2149/E

public class HiddenKnowledgeOfTheAncients {

    public int resolve(int i,int j,int l,int r){
        if(i>j) return 0;
        if(i>r || j<l) return 0;
        i = Math.min(Math.max(i,l),r);
        j = Math.max(Math.min(j,r),l);
        return Math.max(j - i + 1,0);
    }

    public void solve(Scanner sc){
        long n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();

        List<Long> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextLong());
        }
        Map<Long,Long> far = new HashMap<>();
        Map<Long,Long> clo = new HashMap<>();
        int farPnt = 0;
        int cloPnt = 0;
        long ans = 0;
        for(int i=0;i<n;i++){
            far.put(a.get(i),far.getOrDefault(a.get(i),0L)+1);
            clo.put(a.get(i),clo.getOrDefault(a.get(i),0L)+1);

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

            int farLen = i-farPnt +1;
            int cloLen = i -cloPnt +2;

            ans += resolve(cloLen,farLen,l,r);
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
