https://leetcode.com/problems/investments-in-2016

```postgresql
-- Write your PostgreSQL query statement below

SELECT
    ROUND(SUM(tiv_2016)::numeric, 2) AS tiv_2016
FROM
    (
        SELECT
            tiv_2016,
            COUNT(*) OVER (PARTITION BY tiv_2015) AS tiv_count,
            COUNT(*) OVER (PARTITION BY lat, lon) AS loc_count
        FROM
            Insurance
    )
WHERE
    tiv_count > 1
  AND loc_count = 1
```