
/*
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
通过次数159,042提交次数428,456
 */

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        if (sum % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, sum / 2) + findKth(nums1, 0, nums2, 0, sum / 2 + 1)) / 2;
        }
        return findKth(nums1, 0, nums2, 0, sum / 2 + 1);
    }

    public int findKth(int[] arr1, int left1, int[] arr2, int left2, int k) {
        if (left1 >= arr1.length) return arr2[left2 + k - 1];//第一个数组长度不够，取第二个数组的
        if (left2 >= arr2.length) return arr1[left1 + k - 1];
        if (k == 1) return Math.min(arr1[left1], arr2[left2]);
        int mid1 = left1 + k / 2 - 1 < arr1.length ? arr1[left1 + k / 2 - 1] : Integer.MAX_VALUE;//取移动k/2所在值
        int mid2 = left2 + k / 2 - 1 < arr2.length ? arr2[left2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 <= mid2) {
            return findKth(arr1, left1 + k / 2, arr2, left2, k - k / 2);//m1小，m1指针移动k/2,m2的范围也缩小k/2
        }
        return findKth(arr1, left1, arr2, left2 + k / 2, k - k / 2);
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {2};
    }

}
