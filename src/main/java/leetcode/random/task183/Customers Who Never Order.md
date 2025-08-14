https://leetcode.com/problems/customers-who-never-order

```postgresql
-- Write your PostgreSQL query statement below
SELECT
    name AS Customers
FROM
    Customers
WHERE
    id NOT IN (SELECT customerId FROM Orders)
```