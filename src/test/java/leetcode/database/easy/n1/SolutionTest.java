package leetcode.database.easy.n1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clean GPT test
 */
public class SolutionTest {
    private Connection connection;

    @BeforeEach
    public void setUp() throws Exception {
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        initializeDatabase();
    }

    private void initializeDatabase() throws Exception {
        Statement stmt = connection.createStatement();

        // Создание таблиц
        stmt.execute("CREATE TABLE IF NOT EXISTS Visits(visit_id INTEGER, customer_id INTEGER)");
        stmt.execute("CREATE TABLE IF NOT EXISTS Transactions(transaction_id INTEGER, visit_id INTEGER, amount INTEGER)");

        // Вставка данных
        stmt.execute("INSERT INTO Visits (visit_id, customer_id) VALUES (1, 23)");
        stmt.execute("INSERT INTO Visits (visit_id, customer_id) VALUES (2, 9)");
        stmt.execute("INSERT INTO Visits (visit_id, customer_id) VALUES (4, 30)");
        stmt.execute("INSERT INTO Visits (visit_id, customer_id) VALUES (5, 54)");
        stmt.execute("INSERT INTO Visits (visit_id, customer_id) VALUES (6, 96)");
        stmt.execute("INSERT INTO Visits (visit_id, customer_id) VALUES (7, 54)");
        stmt.execute("INSERT INTO Visits (visit_id, customer_id) VALUES (8, 54)");

        stmt.execute("INSERT INTO Transactions (transaction_id, visit_id, amount) VALUES (2, 5, 310)");
        stmt.execute("INSERT INTO Transactions (transaction_id, visit_id, amount) VALUES (3, 5, 300)");
        stmt.execute("INSERT INTO Transactions (transaction_id, visit_id, amount) VALUES (9, 5, 200)");
        stmt.execute("INSERT INTO Transactions (transaction_id, visit_id, amount) VALUES (12, 1, 910)");
        stmt.execute("INSERT INTO Transactions (transaction_id, visit_id, amount) VALUES (13, 2, 970)");

        stmt.close();
    }

    @Test
    public void testVisitsNoTransactions() throws Exception {
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery(
                "SELECT v.customer_id, COUNT(v.visit_id) AS count_no_trans " +
                        "FROM Visits v " +
                        "LEFT JOIN Transactions t ON v.visit_id = t.visit_id " +
                        "WHERE t.visit_id IS NULL " +
                        "GROUP BY v.customer_id;"
        );

        int totalResults = 0;
        while (rs.next()) {
            totalResults++;
            int customerId = rs.getInt("customer_id");
            int countNoTrans = rs.getInt("count_no_trans");

            if (customerId == 30) {
                assertEquals(1, countNoTrans);
            } else if (customerId == 54) {
                assertEquals(2, countNoTrans);
            } else if (customerId == 96) {
                assertEquals(1, countNoTrans);
            }
        }

        assertEquals(3, totalResults);

        rs.close();
        stmt.close();
    }

    @AfterEach
    public void tearDown() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
