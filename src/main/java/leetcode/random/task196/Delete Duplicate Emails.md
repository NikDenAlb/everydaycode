https://leetcode.com/problems/delete-duplicate-emails

```postgresql
-- Write your PostgreSQL query statement below
DELETE FROM Person p2
    USING Person p1
WHERE p1.email = p2.email AND p2.id > p1.id;
```