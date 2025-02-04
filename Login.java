import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTF;
	private JPasswordField passwordTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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

	public Login() {
		AgencyDbase d = new AgencyDbase();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(42, 79, 74, 21);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(42, 111, 74, 21);
		contentPane.add(lblNewLabel_1);

		usernameTF = new JTextField();
		usernameTF.setBounds(119, 79, 96, 20);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Login to the System");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(119, 11, 236, 35);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTF.getText();
				String password = passwordTF.getText();
				boolean found = d.login(username, password);
				if (found) {
					//d.setTrigger(username);
					MainMenu m = new MainMenu();
					m.setVisible(true);
					m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid username/ Password");
				}
			}
		});

		btnNewButton.setBounds(126, 154, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Shada\\OneDrive\\Desktop\\istockphoto-936681148-612x612.jpg"));
		lblNewLabel_3.setBounds(248, 57, 164, 181);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameTF.setText("");
				passwordTF.setText("");
			}
		});
		btnNewButton_1.setBounds(24, 154, 89, 23);
		contentPane.add(btnNewButton_1);

		passwordTF = new JPasswordField();
		passwordTF.setBounds(119, 111, 96, 20);
		contentPane.add(passwordTF);
	}
}
