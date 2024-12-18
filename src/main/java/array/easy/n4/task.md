## 746. Min Cost Climbing Stairs

You are given an integer array `cost` where `cost[i]` is the cost of **i<sup>th</sup>** step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index `0`, or the step with index `1`.

Return _the minimum cost to reach the top of the floor_.

#### Example 1:

__Input:__ cost = [10,15,20]<br>
__Output:__ 15<br>
__Explanation:__ You will start at index 1.<br>
-Pay 15 and climb two steps to reach the top.<br>
The total cost is 15.

####  Example 2:

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