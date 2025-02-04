import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * The InsertCustomer class provides a GUI for adding a new customer to the database.
 * It allows the user to enter a customer's name and address and insert the record into the database.
 */
public class InsertCustomer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField custNameTF;
    private JTextField custAddressTF;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertCustomer frame = new InsertCustomer();
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
    public InsertCustomer() {
        AgencyDbase d = new AgencyDbase();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Name:");
        lblNewLabel.setBounds(52, 77, 83, 25);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Customer Information");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(52, 28, 308, 25);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Address:");
        lblNewLabel_2.setBounds(52, 123, 156, 14);
        contentPane.add(lblNewLabel_2);

        custNameTF = new JTextField();
        custNameTF.setBounds(243, 79, 96, 20);
        contentPane.add(custNameTF);
        custNameTF.setColumns(10);

        custAddressTF = new JTextField();
        custAddressTF.setBounds(243, 120, 96, 20);
        contentPane.add(custAddressTF);
        custAddressTF.setColumns(10);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String custName = custNameTF.getText();
                String custAddress = custAddressTF.getText();
                d.insertIntoCust(custName, custAddress);
            }
        });
        btnNewButton.setBounds(243, 172, 96, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Clear");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                custNameTF.setText("");
                custAddressTF.setText("");
            }
        });
        btnNewButton_1.setBounds(87, 172, 89, 23);
        contentPane.add(btnNewButton_1);
    }
}
