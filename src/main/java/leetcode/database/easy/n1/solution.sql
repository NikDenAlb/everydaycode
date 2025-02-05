-- My 1st solution
SELECT v.customer_id, COUNT(v.visit_id) AS count_no_trans
FROM Visits v
         LEFT JOIN Transactions t ON v.visit_id = t.visit_id
WHERE t.visit_id IS NULL
GROUP BY v.customer_id
ORDER BY count_no_trans;

--Editorial solutions

--Approach 1: Removing Records Using NOT IN/EXISTS
SELECT customer_id,
       COUNT(visit_id) AS count_no_trans
FROM Visits
WHERE visit_id NOT IN (SELECT visit_id
                       FROM Transactions)
GROUP BY customer_id;

--Approach 2: Removing Records Using LEFT JOIN and IS NULL
SELECT customer_id,
       COUNT(*) AS count_no_trans
FROM Visits AS v
         LEFT JOIN Transactions AS t ON v.visit_id = t.visit_id
WHERE t.visit_id IS NULL
GROUP BY customer_id;
