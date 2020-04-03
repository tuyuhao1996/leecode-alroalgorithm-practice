import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            for (int i=0;i<sc.nextInt();i++){
                String str = sc.nextLine();
                String[] strings = str.split(" ");
                int length = Integer.parseInt(strings[0]);
                int[] nums = new int[length];
                for (int j = 0; j< nums.length; j++) {
                    nums[i] = Integer.parseInt(strings[i + 1]);
                }
            }
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
