import java.util.*;

//https://codeforces.com/problemset/problem/2184/D

public class UnfairGame {

    static class Pair {
        long first;
        long second;

        Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return first == p.first && second == p.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    public static Map<Pair,Long> storedAns = new HashMap<>();

    public static void solve(Scanner sc){
        long n = sc.nextLong();
        long k = sc.nextLong(), num=1L;

        int pow = 0;
        while(num<n){
            pow++; num=num*2; }

        if( k>= pow + pow ){
            System.out.println(0);
            return;
        }

        Pair pairKey = new Pair(n,k);
        if(storedAns.containsKey(pairKey)){
            long ans = storedAns.get(pairKey);
            System.out.println(ans);
            return;
        }

        long ans =1L;
        int size =1;
        List<Long> zeroArr = new ArrayList<>();
        List<Long> oneArr = new ArrayList<>();
        zeroArr.add(0L);
        oneArr.add(1L);

        for(long i=1L;i<k;i++){
            List<Long> zeroArr1 = new ArrayList<>();
            List<Long> oneArr1 = new ArrayList<>();

            for (int j = 0; j < size + 1; j++) {
                zeroArr1.add(0L);
                oneArr1.add(0L);}

            for(int count=0;count<size;count++){
                long zero = zeroArr.get(count);
                long one = oneArr.get(count);

                long new_zero = 0L , new_one = 0L;

                if(count+1 < pow){
                    new_zero = zero + one;
                }
                new_one = zero;
                ans =  ans + new_zero + new_one;

                zeroArr1.set(count+1, zeroArr1.get(count+1) + new_zero);
                oneArr1.set(count, oneArr1.get(count) + new_one);
            }

            zeroArr = zeroArr1;
            oneArr = oneArr1;
            size++;
        }

        if(k>= pow+1){ans++;}
        System.out.println( n - Math.min(n,ans));

        storedAns.put(pairKey,n - Math.min(n,ans));
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
