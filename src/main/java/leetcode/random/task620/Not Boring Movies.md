https://leetcode.com/problems/not-boring-movies

```postgresql
-- Write your PostgreSQL query statement below

SELECT
    id,
    movie,
    description,
    rating
FROM
    Cinema
WHERE
    id % 2 = 1
  AND description != 'boring'
ORDER BY
    rating DESC
```