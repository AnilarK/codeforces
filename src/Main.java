import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        List<Long> prime = new ArrayList<>(Collections.nCopies(1000000, 0L));
        List<Long> p = new ArrayList<>();

        for (int i = 2; i < 1000000; i++) {
            if (prime.get(i) != 0) {
                continue;
            }
            p.add(i*1L);

            for (int j = i + i; j < 1000000; j += i) {
                prime.set(j, 1L);
            }
        }

        while(testCases>0) {

            int n = sc.nextInt();
            List<Long> a = new ArrayList<>();


            for (int i = 0; i < n; i++) {
                a.add(sc.nextLong());
            }

            boolean found = false;

            for (int i = 0; i < p.size(); i++) {

                for (int j = 0; j < n; j++) {
                    if (a.get(j) % p.get(i) != 0) {
                        System.out.println(p.get(i));
                        found = true;
                        break;
                    }
                }

                if(found) {
                    break;
                }

            }
            testCases--;
        }


    }
}