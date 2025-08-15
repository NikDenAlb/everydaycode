https://leetcode.com/problems/department-top-three-salaries

```postgresql
-- Write your PostgreSQL query statement below
WITH ranked AS (
    SELECT
        *,
        DENSE_RANK() OVER (
            PARTITION BY departmentId
            ORDER BY salary DESC
        ) AS rnk
    FROM
        Employee
)
SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM
    ranked e
JOIN
    Department d ON e.departmentId = d.id
WHERE
    e.rnk <= 3
```