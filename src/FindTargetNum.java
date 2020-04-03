import java.util.Scanner;

// 求对称数eg：103，输出：101
public class FindTargetNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            int n = s.length();
            int n2 = 0;
            int count = 0;
            if(n==1)
            {
                System.out.println("ERROR");
                continue;
            }
            if (n % 2 == 1) {
                n2 = n / 2 + 1;
            } else {
                n2 = n / 2;
            }

            int[] arr = new int[n];
            for (int i = 0; i < n2; i++) {
                arr[count++] = Integer.parseInt(s.substring(i, i + 1));
            }

            for (int i = n2 - 2; i >= 0; i--) {
                arr[count++] = arr[i];
            }
            StringBuffer nums = new StringBuffer();
            for (int i = 0; i < n; i++) {
                nums.append(arr[i]);
            }
            System.out.println(nums.toString());
        }
    }
}
