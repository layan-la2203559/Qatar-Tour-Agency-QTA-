import java.sql.*;
import javax.swing.JOptionPane;

/**
 * The AgencyDbase class manages database operations for the Qatar Tour Agency system.
 * It supports user authentication, customer management, reservation handling, and tour trip management.
 */
public class AgencyDbase {
    private Connection conn;
    private PreparedStatement stmt;
    private static int agentID;

    /**
     * Constructor - Establishes a connection to the Oracle database.
     */
    public AgencyDbase() {
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa", "si2108365", "si2108365");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Authenticates a tour agent based on username and password.
     * @param username The username entered by the agent.
     * @param password The password entered by the agent.
     * @return true if credentials are valid, false otherwise.
     */
    public boolean login(String username, String password) {
        boolean found = false;
        try {
            String sql = "SELECT AgentID FROM Login NATURAL JOIN TourAgent WHERE Username=? AND Password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                agentID = rs.getInt(1);
                found = true;
            }
            rs.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return found;
    }

    /**
     * Inserts a new customer into the database.
     * @param custName Name of the customer.
     * @param custAddress Address of the customer.
     */
    public void insertIntoCust(String custName, String custAddress) {
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO Customer VALUES(CustID_seq.nextval,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, custName);
            stmt.setString(2, custAddress);
            stmt.executeUpdate();
            
            int answer = JOptionPane.showConfirmDialog(null, "Add Customer?", "", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Customer added!");
            } else {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Customer was not added!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the address of an existing customer.
     * @param custID The ID of the customer to be updated.
     * @param custAddress The new address of the customer.
     */
    public void updateIntoCust(int custID, String custAddress) {
        try {
            conn.setAutoCommit(false);
            String sql = "UPDATE Customer SET Address=? WHERE CustID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, custAddress);
            stmt.setInt(2, custID);
            stmt.executeUpdate();
            
            int answer = JOptionPane.showConfirmDialog(null, "Update Customer?", "", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Customer Updated!");
            } else {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Customer was not updated!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a customer record from the database.
     * @param custID The ID of the customer to be deleted.
     */
    public void deleteCust(int custID) {
        try {
            conn.setAutoCommit(false);
            String sql = "DELETE FROM Customer WHERE CustID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, custID);
            stmt.executeUpdate();
            
            int answer = JOptionPane.showConfirmDialog(null, "Delete Customer?", "", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Customer deleted!");
            } else {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "No record deleted!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if a given customer ID exists in the database.
     * @param custID The customer ID to search for.
     * @return true if the customer exists, false otherwise.
     */
    public boolean searchCustID(int custID) {
        boolean found = false;
        String sql = "SELECT * FROM Customer WHERE CustID = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, custID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                found = true;
            } else {
                JOptionPane.showMessageDialog(null, "Customer ID not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found;
    }
}
