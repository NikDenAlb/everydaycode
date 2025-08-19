https://leetcode.com/problems/find-customer-referee

```postgresql
-- Write your PostgreSQL query statement below
SELECT
    name
FROM
    Customer
WHERE
    referee_id != 2
   OR referee_id IS NULL
```