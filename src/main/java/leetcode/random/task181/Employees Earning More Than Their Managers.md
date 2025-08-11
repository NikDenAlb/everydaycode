https://leetcode.com/problems/employees-earning-more-than-their-managers

```postgresql
-- Write your PostgreSQL query statement below
SELECT a.name AS Employee
FROM Employee a
         JOIN Employee m
              ON m.id = a.managerId
WHERE a.salary > m.salary
```