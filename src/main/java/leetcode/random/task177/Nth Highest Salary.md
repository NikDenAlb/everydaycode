https://leetcode.com/problems/nth-highest-salary

```postgresql
CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  RETURN QUERY (
    -- Write your PostgreSQL query statement below.
    SELECT CASE WHEN N < 1 THEN NULL 
    ELSE (SELECT DISTINCT e.salary 
          FROM Employee e 
          ORDER BY e.salary DESC 
          LIMIT 1 OFFSET (N - 1)) 
    END AS Salary
  );
END;
$$ LANGUAGE plpgsql;
```