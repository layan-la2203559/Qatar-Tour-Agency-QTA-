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

public class InsertTrip extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField destinationTF;
	private JTextField priceTF;
	private JTextField dateTF;
	private JTextField timeTF;
	private JTextField durationTF;
	private JTextField packIDTF;
	private JTextField siteIDTF;
	private JTextField guideIDTF;
	private JTextField locTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertTrip frame = new InsertTrip();
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
	public InsertTrip() {
		AgencyDbase d = new AgencyDbase();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Destination");
		lblNewLabel_1.setBounds(44, 68, 49, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(44, 93, 49, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tour date");
		lblNewLabel_3.setBounds(44, 118, 49, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Start Time");
		lblNewLabel_4.setBounds(44, 151, 49, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Duration");
		lblNewLabel_5.setBounds(44, 176, 49, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("PackageID");
		lblNewLabel_6.setBounds(44, 201, 49, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Site ID");
		lblNewLabel_7.setBounds(44, 226, 49, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Guide ID");
		lblNewLabel_8.setBounds(44, 251, 49, 14);
		contentPane.add(lblNewLabel_8);

		destinationTF = new JTextField();
		destinationTF.setBounds(159, 65, 96, 20);
		contentPane.add(destinationTF);
		destinationTF.setColumns(10);

		priceTF = new JTextField();
		priceTF.setBounds(159, 90, 96, 20);
		contentPane.add(priceTF);
		priceTF.setColumns(10);

		dateTF = new JTextField();
		dateTF.setBounds(159, 115, 96, 20);
		contentPane.add(dateTF);
		dateTF.setColumns(10);

		timeTF = new JTextField();
		timeTF.setBounds(159, 148, 96, 20);
		contentPane.add(timeTF);
		timeTF.setColumns(10);

		durationTF = new JTextField();
		durationTF.setBounds(159, 173, 96, 20);
		contentPane.add(durationTF);
		durationTF.setColumns(10);

		packIDTF = new JTextField();
		packIDTF.setBounds(159, 198, 96, 20);
		contentPane.add(packIDTF);
		packIDTF.setColumns(10);

		siteIDTF = new JTextField();
		siteIDTF.setBounds(159, 223, 96, 20);
		contentPane.add(siteIDTF);
		siteIDTF.setColumns(10);

		guideIDTF = new JTextField();
		guideIDTF.setBounds(159, 248, 96, 20);
		contentPane.add(guideIDTF);
		guideIDTF.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Location");
		lblNewLabel_9.setBounds(283, 43, 49, 14);
		contentPane.add(lblNewLabel_9);

		locTF = new JTextField();
		locTF.setBounds(330, 40, 96, 20);
		contentPane.add(locTF);
		locTF.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int packageID = Integer.parseInt(packIDTF.getText());
				int siteID = Integer.parseInt(siteIDTF.getText());
				int guideID = Integer.parseInt(guideIDTF.getText());
				System.out.println(d.speaks2Lang(guideID));

				if (d.searchPackageID(packageID) && d.searchSiteID(siteID) && d.searchGuideID(guideID)
						&& d.speaks2Lang(guideID)) {

					double price = Double.parseDouble(priceTF.getText());
					double duration = Double.parseDouble(durationTF.getText());

					d.insertIntoTrip(destinationTF.getText(), price, dateTF.getText(), timeTF.getText(), duration,
							locTF.getText(), packageID, siteID, guideID);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid data!");
				}
			}
		});
		btnNewButton.setBounds(309, 226, 89, 23);
		contentPane.add(btnNewButton);
	}
}
