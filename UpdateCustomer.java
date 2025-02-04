import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCustomer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField custAddressTF;
	private JTextField custIDTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomer frame = new UpdateCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateCustomer() {
		AgencyDbase d = new AgencyDbase();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Customer");
		lblNewLabel.setBounds(59, 40, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Address: ");
		lblNewLabel_1.setBounds(59, 129, 134, 14);
		contentPane.add(lblNewLabel_1);

		custAddressTF = new JTextField();
		custAddressTF.setBounds(203, 126, 96, 20);
		contentPane.add(custAddressTF);
		custAddressTF.setColumns(10);

		custIDTF = new JTextField();
		custIDTF.setBounds(203, 90, 96, 20);
		contentPane.add(custIDTF);
		custIDTF.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Customer ID:");
		lblNewLabel_2.setBounds(59, 93, 115, 14);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int custID = Integer.parseInt(custIDTF.getText());
				boolean found = d.searchCustID(custID);

				if (found) {
					String custAddress = custAddressTF.getText();
					d.updateIntoCust(custID, custAddress);
				} else {
					JOptionPane.showMessageDialog(null, "Customer not found");
				}
			}
		});
		btnNewButton_1.setBounds(210, 181, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
