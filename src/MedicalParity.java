import java.util.*;

public class MedicalParity {


    private static void solve(Scanner sc){
        StringBuilder a = new StringBuilder(sc.nextLine().trim());
        StringBuilder b = new StringBuilder(sc.nextLine().trim());

        int n = a.length();
        List<List<Integer>> dp = new ArrayList<>();

        dp.add(Arrays.asList(0,0));
        for( int i=0 ; i<n ; i++ ){

            if(i==0){
                if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                    dp.add(Arrays.asList(2,0));
                } else if (a.charAt(i) == '0' && b.charAt(i) == '1') {
                    dp.add(Arrays.asList(1,1));
                } else if (a.charAt(i) == '1' && b.charAt(i) == '0') {
                    dp.add(Arrays.asList(1,1));
                } else if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                    dp.add(Arrays.asList(0,2));
                }
            } else {
                if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                    dp.add(Arrays.asList(
                            Math.min( dp.get(i).get(0) + 2, dp.get(i).get(1) + 1  ),
                            Math.min( dp.get(i).get(0) , dp.get(i).get(1) +1   )  ));
                } else if (a.charAt(i) == '0' && b.charAt(i) == '1') {
                    dp.add(Arrays.asList(
                            Math.min( dp.get(i).get(0) + 1, dp.get(i).get(1) + 2  ),
                            Math.min( dp.get(i).get(0) + 1, dp.get(i).get(1)   )  ));
                } else if (a.charAt(i) == '1' && b.charAt(i) == '0') {
                    dp.add(Arrays.asList(
                            Math.min( dp.get(i).get(0) + 1, dp.get(i).get(1)  ),
                            Math.min( dp.get(i).get(0) + 1, dp.get(i).get(1) + 2  )  ));
                } else if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                    dp.add(Arrays.asList(
                            Math.min( dp.get(i).get(0) , dp.get(i).get(1) + 1  ),
                            Math.min( dp.get(i).get(0) + 2 , dp.get(i).get(1) + 1   )  ));
                }
            }
        }

//        System.out.println(dp);
        System.out.println(Math.min(dp.getLast().getFirst(), dp.getLast().getLast()));
    }

    public static void main(String args[]){
        int testcases;
        Scanner sc = new Scanner(System.in);
        testcases = sc.nextInt();
        sc.nextLine();
        while(testcases>0){
            solve(sc);
            testcases--;
        }

    }


}
