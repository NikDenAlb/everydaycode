https://leetcode.com/problems/managers-with-at-least-5-direct-reports

```postgresql
-- Write your PostgreSQL query statement below
SELECT 
    e.name
FROM 
    Employee e
JOIN (
    SELECT 
        managerId
    FROM 
        Employee
    WHERE 
        managerId IS NOT NULL
    GROUP BY 
        managerId
    HAVING 
        COUNT(*) >= 5
) m ON e.id = m.managerId
```