import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int index = nums[i] + nums[j];
                if (!map.containsKey(index)) {
                    map.put(index, nums[i] + "," + nums[j]);
                }
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (map.containsKey(-nums[k])) {
                List<Integer> list2 = new ArrayList<>();
                list2.add(-nums[k]);
                String[] indexs = map.get(nums[k]).split(",");
                if (indexs != null) {
                    for (String ins :
                            indexs) {
                        list2.add(Integer.parseInt(ins));
                    }
                }
                list.add(list2);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
}
