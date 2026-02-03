import java.util.*;

public class FragmentedNim {

    private static void solve(Scanner sc){
        int n = sc.nextInt(), x=0;
        List<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
            if(a.get(i)==1){ x++;}
        }

        int y = n-x;

        if(y==0){
            if(x%2==1){
                System.out.println("Alice"); }
            else{
                System.out.println("Bob");
            }
        } else {
            if(x%2==0){
                System.out.println("Alice"); }
            else{
                System.out.println("Bob");
            }
        }



    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            solve(sc);
            t--;
        }
    }
}
