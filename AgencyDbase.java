import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AgencyDbase {
	Connection conn;
	PreparedStatement stmt;
	static int agentID;

	public AgencyDbase() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa", "si2108365",
					"si2108365");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean login(String username, String password) {
		boolean found = false;
		try {
			String sql = "select AgentID from Login natural join TourAgent where Username=? and Password=?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				agentID = rs.getInt(1);
				found = true;
			}
			rs.close();
			// conn.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return found;
	}

	public void insertIntoCust(String custName, String custAddress) {
		try {
			conn.setAutoCommit(false);
			String sql = "insert into Customer values(CustID_seq.nextval,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, custName);
			stmt.setString(2, custAddress);

			stmt.executeUpdate();

			int answer = JOptionPane.showConfirmDialog(null, "Add Customer?", "", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				conn.commit();
				JOptionPane.showMessageDialog(null, "Customer added!");
			} else {
				conn.rollback();
				JOptionPane.showMessageDialog(null, "Customer was not added!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateIntoCust(int custID, String custAddress) {
		try {
			conn.setAutoCommit(false);
			String sql = "update Customer set Address=? where CustID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, custAddress);
			stmt.setInt(2, custID);

			stmt.executeUpdate();

			int answer = JOptionPane.showConfirmDialog(null, "Update Customer?", "", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				conn.commit();
				JOptionPane.showMessageDialog(null, "Customer Updated1");
			} else {
				conn.rollback();
				JOptionPane.showMessageDialog(null, "Customer was not Updated!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteCust(int custID) {
		try {
			conn.setAutoCommit(false);
			String sql = "delete from Customer where CustID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, custID);

			stmt.executeUpdate();

			int answer = JOptionPane.showConfirmDialog(null, "Delete Customer", "", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				conn.commit();
				JOptionPane.showMessageDialog(null, "Customer deleted");
			} else {
				conn.rollback();
				JOptionPane.showMessageDialog(null, "No record deleted");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean searchCustID(int custID) {
		boolean found = false;
		String sql = "select * from Customer where CustID = ?";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, custID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				found = true;
			} else {
				JOptionPane.showMessageDialog(null, "Customer ID not found!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}
//	public void updateReservationID(int custID) {
//		try {
//			conn.setAutoCommit(false);
//			
//			String sql = "select ReservationID_seq.nextval from dual";
//			Statement stmt = conn.prepareStatement(sql);
//
//			stmt.setInt(1, custID);
//			stmt.setInt(2, agentID);
//
//			stmt.executeUpdate();
//
//			int answer = JOptionPane.showConfirmDialog(null, "Make Reservation?", "", JOptionPane.YES_NO_OPTION);
//
//			if (answer == JOptionPane.YES_OPTION) {
//				conn.commit();
//				JOptionPane.showMessageDialog(null, "Reservation added!");
//			} else {
//				conn.rollback();
//				JOptionPane.showMessageDialog(null, "Reservation was not added!");
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public void insertIntoReserve(int custID) {
		try {
			conn.setAutoCommit(false);

			String sql = "insert into Reservation values(ReservationID_seq.nextval,sysdate,'CONFIRMED',?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, custID);
			stmt.setInt(2, agentID);

			stmt.executeUpdate();

			int answer = JOptionPane.showConfirmDialog(null, "Make Reservation?", "", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				conn.commit();
				JOptionPane.showMessageDialog(null, "Reservation added!");
			} else {
				conn.rollback();
				JOptionPane.showMessageDialog(null, "Reservation was not added!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteReserve(int reserveID) {
		try {
			conn.setAutoCommit(false);
			String sql = "update Reservation set Status='CANCELED' where ReserveID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, reserveID);

			stmt.executeUpdate();

			int answer = JOptionPane.showConfirmDialog(null, "Cancel Reservation?", "", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				conn.commit();
				JOptionPane.showMessageDialog(null, "Reservation canceled!");
			} else {
				conn.rollback();
				JOptionPane.showMessageDialog(null, "Reservation was not canceled!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean searchReserveID(int reserveID) {
		boolean found = false;
		String sql = "select * from Reservation where ReserveID = ?";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, reserveID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				found = true;
			} else {
				JOptionPane.showMessageDialog(null, "Reservation ID not found!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}

	public void insertIntoTrip(String dest, double price, String tourDate, String startTime, double duration,
			String loc, int packID, int siteID, int guideID) {
		try {
			conn.setAutoCommit(false);
			String sql = "insert into TourTrip values(TripID_seq.nextval ,?,?,to_date(?,'DD-MM-YYYY'),to_date(?,'HH:MI:SS'),?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, dest);
			stmt.setDouble(2, price);
			stmt.setString(3, tourDate);
			stmt.setString(4, startTime);
			stmt.setDouble(5, duration);
			stmt.setString(6, loc);
			stmt.setInt(7, packID);
			stmt.setInt(8, siteID);
			stmt.setInt(9, guideID);

			stmt.executeUpdate();

			int answer = JOptionPane.showConfirmDialog(null, "Add Tour Trip?", "", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				conn.commit();
				JOptionPane.showMessageDialog(null, "Tour Trip added!");
			} else {
				conn.rollback();
				JOptionPane.showMessageDialog(null, "Tour Trip was not added!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean searchPackageID(int packID) {
		boolean found = false;
		String sql = "select * from TourPackage where PackageID = ?";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, packID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				found = true;
			} else {
				JOptionPane.showMessageDialog(null, "Tour Package ID not found!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}

	public boolean searchSiteID(int siteID) {
		boolean found = false;
		String sql = "select * from TourSite where SiteID = ?";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, siteID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				found = true;
			}else {
				JOptionPane.showMessageDialog(null, "Site ID not found!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}

	public boolean searchGuideID(int guideID) {
		boolean found = false;
		String sql = "select * from TourGuide where GuideID = ?";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, guideID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				found = true;
			}else {
				JOptionPane.showMessageDialog(null, "Guide ID not found!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}

	public boolean searchTripID(int tripID) {
		boolean found = false;
		String sql = "select * from TourTrip where TripID = ?";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, tripID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				found = true;
			}else {
				JOptionPane.showMessageDialog(null, "Trip ID not found!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}

	public void updateTrip(int tripID, String dest, double price, String tourDate, String startTime, double duration,
			String loc, int packID, int siteID, int guideID) {
		try {
			conn.setAutoCommit(false);
			String sql = "update TourTrip set Destination=?, Price=?, TourDate=to_date(?,'DD-MM-YYYY'), StartTime=to_date(?,'HH:MI:SS'), Duration=?, Location=?, packageID=?, siteID=?, guideID=? where TripID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, dest);
			stmt.setDouble(2, price);
			stmt.setString(3, tourDate);
			stmt.setString(4, startTime);
			stmt.setDouble(5, duration);
			stmt.setString(6, loc);
			stmt.setInt(7, packID);
			stmt.setInt(8, siteID);
			stmt.setInt(9, guideID);
			stmt.setInt(10, tripID);

			stmt.executeUpdate();

			int answer = JOptionPane.showConfirmDialog(null, "Update Tour Trip?", "", JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				conn.commit();
				JOptionPane.showMessageDialog(null, "Tour Trip updated!");
			} else {
				conn.rollback();
				JOptionPane.showMessageDialog(null, "Tou Trip was not updated!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet searchCust(int customerID) {
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);
			String sql = "select reserveID, reserveDate, status from reservation natural join customer where custID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, customerID);

			rs = stmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}

	public ArrayList<Integer> returnTourTrips() {
		ArrayList<Integer> tourTrips = new ArrayList<Integer>();
		try {
			conn.setAutoCommit(false);
			String sql = "select TripID from TourTrip";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				tourTrips.add(rs.getInt(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tourTrips;

	}

	public void insertIntoReservationFor(int[] tripIDList) {
		try {
			conn.setAutoCommit(false);
			for (int tripID : tripIDList) {
				String sql = "insert into ReservationFor values(?, ReservationID_seq.currval)";
				PreparedStatement stmt = conn.prepareStatement(sql);

				stmt.setInt(1, tripID);

				stmt.executeUpdate();
				conn.commit();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultSet reserveReport() {
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);
			String sql = "select * from reserve_view";
			Statement stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}

	public ResultSet tripReport() {
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);
			String sql = "select * from trip_view";
			Statement stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public boolean speaks2Lang(int guideID) {
		boolean speaks = false;
		try {
			String sql = "select count(*) from Speaks where GuideID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, guideID);

			ResultSet rs = stmt.executeQuery(sql);
			int count = rs.getInt(1);
			System.out.println(count);
			
			if (count >= 2) {
				speaks = true;
			} else {
				JOptionPane.showMessageDialog(null, "Tour Guide does not speak two languages!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return speaks;

	}
}
