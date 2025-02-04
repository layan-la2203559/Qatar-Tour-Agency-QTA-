# Qatar Tour Agency (QTA) Database Project

## Project Overview

This project involves designing and implementing a database system for Qatar Tour Agency (QTA). The database is intended to manage reservations, tour packages, customer details, and tour guides. The system ensures smooth reservation processes, tour guide assignments, and efficient handling of tour trips for QTA. The project was carried out as part of the Database Systems Lab (CMPS 351) course at Qatar University.

## Group Members

- Fatima Ahmed (202008039)
- Shada Ibrahim (202108365)
- Layan Alwattar (202203559)
- Noor Ahmed (201905802)

## Project Objectives

The main objectives of this project include:

- Designing an Entity-Relationship Diagram (ERD) for the QTA database.
- Mapping the ERD to a relational schema.
- Implementing the database using SQL.
- Developing a Java-based GUI for interacting with the database.
- Ensuring data integrity using primary keys, foreign keys, and constraints.

## System Features

The QTA database system supports the following functionalities:

1. **User Authentication**: Tour agents log in using a username and password.
2. **Customer Management**:
   - Add a new customer.
   - Update customer information.
   - Remove a customer along with their reservations.
3. **Tour Reservation**:
   - Reserve multiple tour trips (reservations must be made 7 days in advance).
   - View reservation status (Confirmed or Cancelled).
4. **Tour Management**:
   - Add and update tour trip details.
   - Assign a tour guide who speaks at least two languages.
5. **Transaction Logging**:
   - Track additions, updates, and deletions in the system.
   - Store transaction details including timestamp, agent ID, and username.
6. **Report Generation**:
   - View all reservations and their statuses.
   - List all tour trips and assigned guides.

## Database Design

### Entities and Attributes

The database consists of the following key entities:

- **Customer** (CustomerID, CustName, Address)
- **Reservation** (ReservationID, ReservationDate, Status, CustomerID, AgentID)
- **TourAgent** (AgentID, AgentName, Username)
- **Login** (Username, Password)
- **Transaction** (TransactionID, Time, TransactionDate, Type, AgentID, Username)
- **TourSite** (SiteID, NearLandmark, SiteName)
- **TourPackage** (PackageID, PackName)
- **TourTrip** (TripID, Destination, Price, TourDate, StartTime, Duration, Location, PackageID, SiteID, GuideID)
- **TourGuide** (GuideID, GuideName)
- **Language** (LanguageID, LanguageName)

### Relationships

- Customers can make multiple reservations.
- Reservations are handled by tour agents.
- Each tour trip is associated with a tour package and tour site.
- Tour guides are assigned to tour trips.
- Tour guides speak multiple languages.

## Implementation Details

### Technology Stack

- **Database Management System**: Oracle SQL
- **Programming Language**: Java
- **GUI Development**: Java Swing / JavaFX
- **ERD Modeling**: ERDPlus, Draw\.io, or SmartDraw

### SQL Features Implemented

- SQL script for creating tables and inserting sample data.
- Constraints such as Primary Keys, Foreign Keys, and Check Constraints.
- SQL Triggers for logging transactions.
- SQL Views for generating reports.

### Graphical User Interface (GUI)

- User-friendly interface for managing customers, reservations, and tours.
- Integrated login authentication for tour agents.

##

## Submission Details

- Due Date: **Phase 1 - March 9, 2024 | Phase 2 - April 27, 2024**
- All project files are submitted in a ZIP file named in the format:
  ```
  Fatima_Shada_Layan_Noor.zip
  ```

## Notes

- The project follows Qatar University’s academic integrity policy.

## Contact

For any queries regarding the project, please reach out to **Fatima Hamza**.

