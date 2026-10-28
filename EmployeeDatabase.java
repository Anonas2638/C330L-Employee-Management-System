
import java.sql.*;
import java.util.ArrayList;

public class EmployeeDatabase {

    private static final String DB_URL =
            "jdbc:sqlite:EmployeeManagement.db";

    // Connect to the SQLite database.
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // CREATE TABLE
    public void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS employees (
                employee_id INTEGER PRIMARY KEY,
                first_name TEXT NOT NULL,
                last_name TEXT NOT NULL,
                department TEXT NOT NULL,
                street TEXT NOT NULL,
                city TEXT NOT NULL,
                state TEXT NOT NULL,
                zip_code TEXT NOT NULL,
                employee_type TEXT NOT NULL,
                hourly_rate REAL,
                hours_worked REAL,
                annual_salary REAL,
                base_salary REAL,
                total_sales REAL,
                commission_rate REAL
            )
            """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Employee database ready.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // CREATE: Add an employee.
    public boolean addEmployee(Employee employee) {
        String sql = """
            INSERT INTO employees (
                employee_id, first_name, last_name,
                department, street, city, state, zip_code,
                employee_type, hourly_rate, hours_worked,
                annual_salary, base_salary, total_sales,
                commission_rate
            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employee.getEmployeeId());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getLastName());
            stmt.setString(4, employee.getDepartment());

            Address address = employee.getAddress();
            stmt.setString(5, address.getStreet());
            stmt.setString(6, address.getCity());
            stmt.setString(7, address.getState());
            stmt.setString(8, address.getZipCode());

            if (employee instanceof HourlyEmployee hourly) {
                stmt.setString(9, "Hourly");
                stmt.setDouble(10, hourly.getHourlyRate());
                stmt.setDouble(11, hourly.getHoursWorked());
            } else if (employee instanceof SalariedEmployee salaried) {
                stmt.setString(9, "Salaried");
                stmt.setDouble(12, salaried.getAnnualSalary());
            } else if (employee instanceof CommissionEmployee commission) {
                stmt.setString(9, "Commission");
                stmt.setDouble(13, commission.getBaseSalary());
                stmt.setDouble(14, commission.getTotalSales());
                stmt.setDouble(15, commission.getCommissionRate());
            } else {
                throw new IllegalArgumentException(
                        "Unsupported employee type.");
            }

            
            // Set unused compensation fields to SQL NULL.
            if (employee instanceof HourlyEmployee) {
                stmt.setNull(12, Types.REAL);
                stmt.setNull(13, Types.REAL);
                stmt.setNull(14, Types.REAL);
                stmt.setNull(15, Types.REAL);
            } else if (employee instanceof SalariedEmployee) {
                stmt.setNull(10, Types.REAL);
                stmt.setNull(11, Types.REAL);
                stmt.setNull(13, Types.REAL);
                stmt.setNull(14, Types.REAL);
                stmt.setNull(15, Types.REAL);
            } else if (employee instanceof CommissionEmployee) {
                stmt.setNull(10, Types.REAL);
                stmt.setNull(11, Types.REAL);
                stmt.setNull(12, Types.REAL);
            }


            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Unable to add employee: "
                    + e.getMessage());
            return false;
        }
    }

    // READ: Retrieve all employees.
    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employees ORDER BY employee_id";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employee employee = buildEmployee(rs);

                if (employee != null) {
                    employees.add(employee);
                }
            }

        } catch (SQLException e) {
            System.out.println("Unable to retrieve employees: "
                    + e.getMessage());
        }

        return employees;
    }

    // READ: Find an employee by ID.
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE employee_id = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return buildEmployee(rs);
                }
            }

        } catch (SQLException e) {
            System.out.println("Unable to find employee: "
                    + e.getMessage());
        }

        return null;
    }

    // UPDATE: Save changes to an existing employee.
    public boolean updateEmployee(Employee employee) {
        String sql = """
            UPDATE employees SET
                first_name = ?, last_name = ?, department = ?,
                street = ?, city = ?, state = ?, zip_code = ?,
                employee_type = ?, hourly_rate = ?,
                hours_worked = ?, annual_salary = ?,
                base_salary = ?, total_sales = ?,
                commission_rate = ?
            WHERE employee_id = ?
            """;

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getDepartment());

            Address address = employee.getAddress();
            stmt.setString(4, address.getStreet());
            stmt.setString(5, address.getCity());
            stmt.setString(6, address.getState());
            stmt.setString(7, address.getZipCode());

            if (employee instanceof HourlyEmployee hourly) {
                stmt.setString(8, "Hourly");
                stmt.setDouble(9, hourly.getHourlyRate());
                stmt.setDouble(10, hourly.getHoursWorked());
                stmt.setNull(11, Types.REAL);
                stmt.setNull(12, Types.REAL);
                stmt.setNull(13, Types.REAL);
                stmt.setNull(14, Types.REAL);
            } else if (employee instanceof SalariedEmployee salaried) {
                stmt.setString(8, "Salaried");
                stmt.setNull(9, Types.REAL);
                stmt.setNull(10, Types.REAL);
                stmt.setDouble(11, salaried.getAnnualSalary());
                stmt.setNull(12, Types.REAL);
                stmt.setNull(13, Types.REAL);
                stmt.setNull(14, Types.REAL);
            } else if (employee instanceof CommissionEmployee commission) {
                stmt.setString(8, "Commission");
                stmt.setNull(9, Types.REAL);
                stmt.setNull(10, Types.REAL);
                stmt.setNull(11, Types.REAL);
                stmt.setDouble(12, commission.getBaseSalary());
                stmt.setDouble(13, commission.getTotalSales());
                stmt.setDouble(14, commission.getCommissionRate());
            } else {
                throw new IllegalArgumentException(
                        "Unsupported employee type.");
            }

            stmt.setInt(15, employee.getEmployeeId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Unable to update employee: "
                    + e.getMessage());
            return false;
        }
    }

    // DELETE: Remove an employee.
    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE employee_id = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Unable to delete employee: "
                    + e.getMessage());
            return false;
        }
    }

    // POLYMORPHISM:
    // Rebuild the appropriate employee subclass from SQLite.
    private Employee buildEmployee(ResultSet rs) throws SQLException {

        Address address = new Address(
                rs.getString("street"),
                rs.getString("city"),
                rs.getString("state"),
                rs.getString("zip_code")
        );

        int id = rs.getInt("employee_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String department = rs.getString("department");

        String type = rs.getString("employee_type");

        switch (type) {
            case "Hourly":
                return new HourlyEmployee(
                        id, firstName, lastName, department,
                        address,
                        rs.getDouble("hourly_rate"),
                        rs.getDouble("hours_worked"));

            case "Salaried":
                return new SalariedEmployee(
                        id, firstName, lastName, department,
                        address,
                        rs.getDouble("annual_salary"));

            case "Commission":
                return new CommissionEmployee(
                        id, firstName, lastName, department,
                        address,
                        rs.getDouble("base_salary"),
                        rs.getDouble("total_sales"),
                        rs.getDouble("commission_rate"));

            default:
                System.out.println("Unknown employee type: " + type);
                return null;
        }
    }
}
