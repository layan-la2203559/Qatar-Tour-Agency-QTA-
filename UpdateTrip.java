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

public class UpdateTrip extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField destinationTF;
	private JTextField priceTF;
	private JTextField dateTF;
	private JTextField timeTF;
	private JTextField durationTF;
	private JTextField locTF;
	private JTextField tripIDTF;
	private JTextField guideIDTF;
	private JTextField siteIDTF;
	private JTextField packIDTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateTrip frame = new UpdateTrip();
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
	public UpdateTrip() {
		AgencyDbase d = new AgencyDbase();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Destination");
		lblNewLabel.setBounds(33, 29, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(33, 54, 49, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("TourDate");
		lblNewLabel_2.setBounds(33, 90, 49, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Start Time");
		lblNewLabel_3.setBounds(33, 130, 49, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Duration");
		lblNewLabel_4.setBounds(33, 164, 49, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Location");
		lblNewLabel_5.setBounds(33, 199, 49, 14);
		contentPane.add(lblNewLabel_5);

		destinationTF = new JTextField();
		destinationTF.setBounds(113, 26, 96, 20);
		contentPane.add(destinationTF);
		destinationTF.setColumns(10);

		priceTF = new JTextField();
		priceTF.setBounds(113, 51, 96, 20);
		contentPane.add(priceTF);
		priceTF.setColumns(10);

		dateTF = new JTextField();
		dateTF.setBounds(113, 87, 96, 20);
		contentPane.add(dateTF);
		dateTF.setColumns(10);

		timeTF = new JTextField();
		timeTF.setBounds(113, 127, 96, 20);
		contentPane.add(timeTF);
		timeTF.setColumns(10);

		durationTF = new JTextField();
		durationTF.setBounds(113, 161, 96, 20);
		contentPane.add(durationTF);
		durationTF.setColumns(10);

		locTF = new JTextField();
		locTF.setBounds(113, 196, 96, 20);
		contentPane.add(locTF);
		locTF.setColumns(10);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tripID = Integer.parseInt(tripIDTF.getText());
				int packID = Integer.parseInt(packIDTF.getText());
				int siteID = Integer.parseInt(siteIDTF.getText());
				int guideID = Integer.parseInt(guideIDTF.getText());

				if (d.searchTripID(tripID) && d.searchPackageID(packID) && d.searchSiteID(siteID)
						&& d.searchGuideID(guideID)) {
					double price = Double.parseDouble(priceTF.getText());
					double duration = Double.parseDouble(durationTF.getText());

					d.updateTrip(tripID, destinationTF.getText(), price, dateTF.getText(), timeTF.getText(), duration,
							locTF.getText(),packID, siteID, guideID);
				} else {
					JOptionPane.showMessageDialog(null, "Customer not found");
				}

			}
		});
		btnNewButton.setBounds(293, 206, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_6 = new JLabel("Trip ID");
		lblNewLabel_6.setBounds(33, 4, 49, 14);
		contentPane.add(lblNewLabel_6);

		tripIDTF = new JTextField();
		tripIDTF.setBounds(113, 1, 96, 20);
		contentPane.add(tripIDTF);
		tripIDTF.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Guide ID");
		lblNewLabel_7.setBounds(33, 238, 49, 14);
		contentPane.add(lblNewLabel_7);

		guideIDTF = new JTextField();
		guideIDTF.setBounds(113, 235, 96, 20);
		contentPane.add(guideIDTF);
		guideIDTF.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Site ID");
		lblNewLabel_8.setBounds(231, 29, 49, 14);
		contentPane.add(lblNewLabel_8);

		siteIDTF = new JTextField();
		siteIDTF.setBounds(286, 26, 96, 20);
		contentPane.add(siteIDTF);
		siteIDTF.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Package ID");
		lblNewLabel_9.setBounds(231, 74, 49, 14);
		contentPane.add(lblNewLabel_9);

		packIDTF = new JTextField();
		packIDTF.setBounds(286, 71, 96, 20);
		contentPane.add(packIDTF);
		packIDTF.setColumns(10);
	}

}
