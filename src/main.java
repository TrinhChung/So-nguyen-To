import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static int sumNumber(int n) {
        int t = 0;
        int k = n;
        while(k > 0) {
            t += k%10;
            k= k/10;

        }
        return t;
    }

    public static boolean checkSnt(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n);i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void toHop(int k, List<Integer> arr, int[] d) {
        for (int i = 0; i < arr.size(); i++) {
            if (k == 0) {
                d[k] = arr.get(i);
                toHop(1, arr,d);
            } else {
                if (arr.get(i) >= d[0]) {
                    d[k] = arr.get(i);
                    if (checkSnt(sumNumber(d[0]*d[1]))) {
                        d[2] += 1;
                    }
                }
            }
        }
    }

    static int primesReversion(int a, int b) {
        List<Integer> arr = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            if (checkSnt(i)) {
                arr.add(i);
            }
        }
        int[] d = new int[3];
        d[2] = 0;
        toHop(0,arr,d);
        return d[2];
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(primesReversion(0,10));
    }
}
