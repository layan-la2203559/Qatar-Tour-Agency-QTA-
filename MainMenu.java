import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The MainMenu class provides a GUI for navigating different functionalities of the tour agency system.
 * It includes options for managing customers, reservations, tour trips, reports, and searches.
 */
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
     * Constructor - Creates the frame and initializes the menu bar with different functionalities.
     */
    public MainMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Customer Menu
        JMenu mnCustomer = new JMenu("Customer");
        menuBar.add(mnCustomer);
        addMenuItem(mnCustomer, "Add Customer", new InsertCustomer());
        addMenuItem(mnCustomer, "Update Customer", new UpdateCustomer());
        addMenuItem(mnCustomer, "Remove Customer", new DeleteCustomer());

        // Reservation Menu
        JMenu mnReservation = new JMenu("Reservation");
        menuBar.add(mnReservation);
        addMenuItem(mnReservation, "Make Reservation", new InsertReservation());
        addMenuItem(mnReservation, "Remove Reservation", new DeleteReservation());

        // TourTrip Menu
        JMenu mnTourTrip = new JMenu("TourTrip");
        menuBar.add(mnTourTrip);
        addMenuItem(mnTourTrip, "Add Tour Trip", new InsertTrip());
        addMenuItem(mnTourTrip, "Update Tour Trip", new UpdateTrip());

        // Reports Menu
        JMenu mnReports = new JMenu("Reports");
        menuBar.add(mnReports);
        addMenuItem(mnReports, "Reservations", new ReservationReport());
        addMenuItem(mnReports, "Trips", new TripReport());

        // Search Menu
        JMenu mnSearch = new JMenu("Search");
        menuBar.add(mnSearch);
        addMenuItem(mnSearch, "By Customer ID", new SearchCustomer());

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    /**
     * Helper method to add menu items to the menu bar.
     * @param menu The menu to which the item is added.
     * @param title The title of the menu item.
     * @param frame The corresponding frame that opens when the menu item is selected.
     */
    private void addMenuItem(JMenu menu, String title, JFrame frame) {
        JMenuItem menuItem = new JMenuItem(title);
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        menu.add(menuItem);
    }
}
