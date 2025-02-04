import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Customer");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Add Customer");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertCustomer i = new InsertCustomer();
				i.setVisible(true);
				i.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Update Customer");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCustomer u = new UpdateCustomer();
				u.setVisible(true);
				u.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Remove Customer");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCustomer d = new DeleteCustomer();
				d.setVisible(true);
				d.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_1 = new JMenu("Reservation");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Make Reservation");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertReservation r = new InsertReservation();
				r.setVisible(true);
				r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Remove Reservation");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteReservation cr = new DeleteReservation();
				cr.setVisible(true);
				cr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);

		JMenu mnNewMenu_2 = new JMenu("TourTrip");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Add Tour Trip");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertTrip t = new InsertTrip();
				t.setVisible(true);
				t.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Update Tour Trip");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTrip ut = new UpdateTrip();
				ut.setVisible(true);
				ut.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);

		JMenu mnNewMenu_3 = new JMenu("Reports");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Reservations");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationReport rr = new ReservationReport();
				rr.setVisible(true);
				rr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Trips");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TripReport tr = new TripReport();
				tr.setVisible(true);
				tr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_8);

		JMenu mnNewMenu_4 = new JMenu("Search");
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("By Customer ID");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCustomer s = new SearchCustomer();
				s.setVisible(true);
				s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
