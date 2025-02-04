import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.ScrollPane;

public class InsertReservation extends JFrame {

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
					InsertReservation frame = new InsertReservation();
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
	public InsertReservation() {
		AgencyDbase d = new AgencyDbase();
		Login l = new Login();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Reservation Details");
		lblNewLabel.setBounds(43, 28, 259, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Customer ID:");
		lblNewLabel_2.setBounds(43, 83, 100, 14);
		contentPane.add(lblNewLabel_2);

		custIDTF = new JTextField();
		custIDTF.setBounds(162, 83, 96, 20);
		contentPane.add(custIDTF);
		custIDTF.setColumns(10);

		DefaultListModel<String> contentAdded = new DefaultListModel<>();

		JList list = new JList(contentAdded);
		list.setBounds(46, 137, 343, 84);
		contentPane.add(list);

		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		String[] tourTrips = new String[d.returnTourTrips().size()];
		for (int i = 0; i < d.returnTourTrips().size(); i++) {
			tourTrips[i] = String.valueOf(d.returnTourTrips().get(i));
		}

		JComboBox comboBox = new JComboBox(tourTrips);
		comboBox.setBounds(43, 114, 276, 22);
		contentPane.add(comboBox);

		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedChoice = (String) comboBox.getSelectedItem();
				if (selectedChoice != null) {
					if (!contentAdded.contains(selectedChoice)) {
						contentAdded.addElement(selectedChoice);
					}
				}
			}
		});
		btnNewButton_1.setBounds(329, 114, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selectedIndices = list.getSelectedIndices();
				for (int i = selectedIndices.length - 1; i >= 0; i--) {
					contentAdded.removeElementAt(selectedIndices[i]);
				}
			}
		});
		btnNewButton_2.setBounds(329, 79, 89, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int custID = Integer.parseInt(custIDTF.getText());
				boolean found = d.searchCustID(custID);
				if (found) {
					int[] tripIDList = new int[contentAdded.size()];
					for (int i = 0; i < contentAdded.size(); i++) {
						tripIDList[i] = Integer.parseInt(contentAdded.getElementAt(i));
					}
					d.insertIntoReserve(custID);
					d.insertIntoReservationFor(tripIDList);
				} else {
					JOptionPane.showMessageDialog(null, "Customer not found!");
				}
			}
		});
		btnNewButton.setBounds(300, 233, 89, 23);
		contentPane.add(btnNewButton);
	}
}
