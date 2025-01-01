## 26. Remove Duplicates from Sorted Array

Given an integer array `nums` sorted in __non-decreasing order__, remove the duplicates _in-place_ such that each unique element
appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements
in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present
in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

#### Example 1:

__Input:__ cost = [10,15,20]<br>
__Output:__ 15<br>
__Explanation:__ You will start at index 1.<br>
-Pay 15 and climb two steps to reach the top.<br>
The total cost is 15.

#### Example 2:

__Input:__ cost = [1,100,1,1,1,100,1,1,100,1]<br>
__Output:__ 6<br>
__Explanation:__ You will start at index 0.<br>
-Pay 1 and climb two steps to reach index 2.<br>
-Pay 1 and climb two steps to reach index 4.<br>
-Pay 1 and climb two steps to reach index 6.<br>
-Pay 1 and climb one step to reach index 7.<br>
-Pay 1 and climb two steps to reach index 9.<br>
-Pay 1 and climb one step to reach the top.<br>
The total cost is 6.

#### Constraints:

- `2 <= cost.length <= 1000`
- `0 <= cost[i] <= 999`

#### https://leetcode.com/problems/min-cost-climbing-stairs/