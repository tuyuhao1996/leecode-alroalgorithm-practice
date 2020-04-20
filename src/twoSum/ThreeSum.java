package twoSum;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3) return result;
        for (int i = 1; i < len - 1; i++) {
            int m = nums[i];
            int j = i - 1, k = i + 1;
            while (j >= 0 && k < len) {
                if (nums[j] + nums[k] == -m) {
                    if (!map.containsKey(nums[j]) || map.get(nums[j])!=m) {
                        List<Integer> list2 = new ArrayList<>();
                        list2.add(nums[j]);
                        list2.add(m);
                        list2.add(nums[k]);
                        result.add(list2);
                        map.put(nums[j], m);
                    }
                    j--;
                } else if (nums[j] + m < -nums[k]) {
                    k++;
                } else {
                    j--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0};
        System.out.println(threeSum2(arr));
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if(nums.length<3) return ans;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;
            int m = i+1;
            int l = nums.length-1;
            while (l>m){
                int sum = nums[i]+nums[m]+nums[l];
                if(sum==0) {
                    ans.add(Arrays.asList(nums[i],nums[m],nums[l]));
                    while (l>m && nums[m]==nums[m+1]) m++;
                    while (l>m && nums[l]==nums[l-1]) l--;
                    m++;l--;
                }else if(sum<0){
                    m++;
                }else{
                    l--;
                }
            }
        }
        return ans;
    }

}
