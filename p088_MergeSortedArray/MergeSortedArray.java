package p088_MergeSortedArray;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pAns = m + n - 1;
        int pNums1 = m - 1;
        int pNums2 = n - 1;
        for(;pNums1 >= 0 && pNums2 >= 0; pAns--)
        {
        	if(nums1[pNums1] >= nums2[pNums2])
        	{
        		nums1[pAns] = nums1[pNums1];
        		pNums1--;
        	}
        	else
        	{
        		nums1[pAns] = nums2[pNums2];
        		pNums2--;
        	}
        }
        for(;pNums2 >= 0; pAns--, pNums2--)
        	nums1[pAns] = nums2[pNums2];
    }
}
