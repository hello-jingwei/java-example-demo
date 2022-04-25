package com.algorithm.list;

public class CheckRepeatNo {
    public static void main(String[] args) {
        int[] iarr = {2, 1, 0, 4, 2};
        System.out.println(new CheckRepeatNo().duplicate(iarr));
    }

    public int duplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return  nums[i];
                }
                swap(nums, i, nums[i]);
            }
            swap(nums, i, nums[i]);
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
