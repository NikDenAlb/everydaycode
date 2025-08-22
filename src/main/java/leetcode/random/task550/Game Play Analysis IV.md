https://leetcode.com/problems/game-play-analysis-iv

```postgresql
-- Write your PostgreSQL query statement below
WITH first_logins AS (
    SELECT 
        player_id, 
        MIN(event_date) AS first_date
    FROM 
        Activity
    GROUP BY 
        player_id
)
SELECT 
    ROUND(
        COUNT(CASE WHEN a.event_date IS NOT NULL THEN 1 END)::numeric / COUNT(*), 
        2
    ) AS fraction
FROM 
    first_logins fl
LEFT JOIN 
    Activity a ON fl.player_id = a.player_id AND a.event_date = fl.first_date + INTERVAL '1 DAY'
```