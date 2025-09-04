https://leetcode.com/problems/biggest-single-number

```postgresql
-- Write your PostgreSQL query statement below

SELECT
    MAX(num) AS num
FROM
    (
        SELECT
            num
        FROM
            MyNumbers
        GROUP BY
            num
        HAVING
            COUNT(*) = 1
    ) AS sub
```