import java.util.*;

public class Taxes {

    public static boolean isPrime(int n){
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0){return false;}
        }
        return true;
    }

    public static void solve(Scanner sc){
        int n = sc.nextInt();

        if(n==2 || n==3){
            System.out.println("1");
        }
        else if(n%2==0){
            System.out.println("2");
        } else{

            if(isPrime(n)){
                System.out.println("1");
            } else if(isPrime(n-2)){
                System.out.println("2");
            } else{
                System.out.println("3");}
        }

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
        int t=1;
        while(t>0){
            solve(sc);
            t--;
        }
    }
}
