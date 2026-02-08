import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Spreadsheets {

    private static int findType(StringBuilder s){
        int num = 0,n=s.length();
        for(int i=0;i<s.length();i++){
            if(num==1 && s.charAt(i)>='0' && s.charAt(i)<='9'){
                return 2;
            }
            while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
                i++;
                num = 1;
            }
        }
        return 1;
    }

    private static StringBuilder solveType1(StringBuilder s){
        int row=0,c=0,n=s.length();
        for(int i=0;i<s.length();i++){
            int x =0;
            while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
                x = x*10 + (int) (s.charAt(i)-'0');
                c++; i++; }
            row=x;
        }

        while(c>0){
            s.deleteCharAt(n-1);
            n--; c--;}

        int column=0,k=1;
        for(int i=n-1;i>=0;i--){
            column+= (int)(s.charAt(i)-'A' +1)*k;
            k=k*26; }

        StringBuilder ans = new StringBuilder();
        ans.append('R');
        ans.append(row);
        ans.append('C');
        ans.append(column);
        return ans;
    }

    private static StringBuilder solveType2(StringBuilder s){
        int row=0,column=0,n=s.length();
        for(int i=0;i<s.length();i++){
            int x =0;
            while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
                x = x*10 + (int) (s.charAt(i)-'0');
                i++; }
            if(row==0){row=x;}
            else{column=x;}
        }

        StringBuilder ans = new StringBuilder();
        while( column>0 ){
            int num = column%26;
            column=column/26;
            if(num==0){num=26; column--;}
            ans.append( (char) ('A'+num-1) );
        }
        ans.reverse();
        ans.append(row);
        return ans;
    }

    private static void test (){
        int count=0,time=0;
        for(int j=0;j<time;j++) {
            int x = ThreadLocalRandom.current().nextInt(1, 1_000_001);
            x = j;
            int column = x;
            StringBuilder ans = new StringBuilder();
            while( column>0 ){
                int num = column%26;
                column=column/26;
                if(num==0){num=26; column--;}
                ans.append( (char) ('A'+num-1) );
            }
            ans.reverse();
//            System.out.println(ans);
            column=0;
            int k=1;
            for(int i=ans.length()-1;i>=0;i--){
                column+= (int)(ans.charAt(i)-'A' +1)*k;
                k=k*26; }

            if(column!=x){
                count++;
                System.out.println("chossen number : "+ x + " calculated number " + column +" String : " + ans);
            }
        }
        if(count!=0){
        System.out.println(count);}
//        System.out.println("Samosa");
    }

    private static void solve(Scanner sc){

        StringBuilder s = new StringBuilder(sc.nextLine());
        int n = s.length();
        int type = findType(s);
        if(type==1){
            System.out.println(solveType1(s));
        } else{
            System.out.println(solveType2(s));
        }

    }

    public static void main(String args[]){
        test();
         Scanner sc = new Scanner(System.in);
         int t = sc.nextInt();
         sc.nextLine();
         while(t>0){
             solve(sc);
             t--;
         }
    }
}