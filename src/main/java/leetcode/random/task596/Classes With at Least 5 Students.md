https://leetcode.com/problems/classes-with-at-least-5-students

```postgresql
-- Write your PostgreSQL query statement below

SELECT
    class
FROM
    Courses
GROUP BY
    class
HAVING
    COUNT(student) >= 5
```