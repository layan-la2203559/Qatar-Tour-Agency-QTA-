import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The DeleteReservation class provides a GUI for deleting a reservation record from the database.
 * It allows the user to enter a Reservation ID, check its existence, and delete the record if found.
 */
public class DeleteReservation extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField reserveIDTF;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteReservation frame = new DeleteReservation();
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
    public DeleteReservation() {
        AgencyDbase d = new AgencyDbase();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Reservation ID:");
        lblNewLabel.setBounds(48, 80, 163, 14);
        contentPane.add(lblNewLabel);

        reserveIDTF = new JTextField();
        reserveIDTF.setBounds(256, 77, 96, 20);
        contentPane.add(reserveIDTF);
        reserveIDTF.setColumns(10);

        JButton btnNewButton = new JButton("Delete");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int reserveID = Integer.parseInt(reserveIDTF.getText());
                    boolean found = d.searchReserveID(reserveID);

                    if (found) {
                        d.deleteReserve(reserveID);
                    } else {
                        JOptionPane.showMessageDialog(null, "Reservation not found!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Reservation ID!");
                }
            }
        });
        btnNewButton.setBounds(263, 128, 89, 23);
        contentPane.add(btnNewButton);
    }
}
