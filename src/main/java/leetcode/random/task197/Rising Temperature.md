https://leetcode.com/problems/rising-temperature

```postgresql
-- Write your PostgreSQL query statement below
SELECT
    w.id
FROM
    Weather w
        JOIN
    Weather wE ON w.recordDate = wE.recordDate + INTERVAL '1 DAY'
WHERE
    w.temperature > wE.temperature
```