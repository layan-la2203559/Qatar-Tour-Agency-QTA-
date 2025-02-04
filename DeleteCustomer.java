import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The DeleteCustomer class provides a GUI for deleting a customer record from the database.
 * It allows the user to enter a Customer ID, check its existence, and delete the record if found.
 */
public class DeleteCustomer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField custIDTF;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteCustomer frame = new DeleteCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructor - Creates the frame and initializes UI components.
     */
    public DeleteCustomer() {
        AgencyDbase d = new AgencyDbase();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Customer ID:");
        lblNewLabel.setBounds(55, 41, 183, 14);
        contentPane.add(lblNewLabel);

        custIDTF = new JTextField();
        custIDTF.setBounds(209, 38, 96, 20);
        contentPane.add(custIDTF);
        custIDTF.setColumns(10);

        JButton btnNewButton = new JButton("Delete");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int custID = Integer.parseInt(custIDTF.getText());
                    boolean found = d.searchCustID(custID);

                    if (found) {
                        d.deleteCust(custID);
                    } else {
                        JOptionPane.showMessageDialog(null, "Customer not found!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Customer ID!");
                }
            }
        });
        btnNewButton.setBounds(216, 87, 89, 23);
        contentPane.add(btnNewButton);
    }
}
