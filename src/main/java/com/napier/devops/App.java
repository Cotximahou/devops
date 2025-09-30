package com.napier.devops;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App
{
    // Connection to the database
    private Connection con = null;

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Get Employee
        Employee emp = a.getEmployee(255530);
        a.displayEmployee(emp);

        // Example: Get all Engineers and their salaries
        List<Employee> engineers = a.getSalariesByRole("Engineer");
        a.displaySalariesByRole(engineers);

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                Thread.sleep(30000);
                con = DriverManager.getConnection(
                        "jdbc:mysql://db:3306/employees?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                        "appuser",
                        "apppass"
                );
                System.out.println("Successfully connected");
                Thread.sleep(10000);
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Get a single employee by ID
     */
    public Employee getEmployee(int ID)
    {
        try
        {
            String strSelect =
                    "SELECT e.emp_no, e.first_name, e.last_name, " +
                            "       t.title, s.salary, d.dept_name, " +
                            "       CONCAT(m.first_name, ' ', m.last_name) AS manager " +
                            "FROM employees e " +
                            "JOIN dept_emp de ON e.emp_no = de.emp_no " +
                            "JOIN departments d ON de.dept_no = d.dept_no " +
                            "JOIN titles t ON e.emp_no = t.emp_no " +
                            "JOIN salaries s ON e.emp_no = s.emp_no " +
                            "JOIN dept_manager dm ON d.dept_no = dm.dept_no " +
                            "JOIN employees m ON dm.emp_no = m.emp_no " +
                            "WHERE e.emp_no = ? " +
                            "  AND de.to_date = '9999-01-01' " +
                            "  AND t.to_date = '9999-01-01' " +
                            "  AND s.to_date = '9999-01-01' " +
                            "  AND dm.to_date = '9999-01-01'";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setInt(1, ID);

            ResultSet rset = pstmt.executeQuery();

            if (rset.next())
            {
                Employee emp = new Employee();
                emp.emp_no = rset.getInt("emp_no");
                emp.first_name = rset.getString("first_name");
                emp.last_name = rset.getString("last_name");
                emp.title = rset.getString("title");
                emp.salary = rset.getInt("salary");
                emp.dept_name = rset.getString("dept_name");
                emp.manager = rset.getString("manager");
                return emp;
            }
            else
                return null;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }

    /**
     * Display a single employee
     */
    public void displayEmployee(Employee emp)
    {
        if (emp != null)
        {
            System.out.println(
                    emp.emp_no + " " +
                            emp.first_name + " " +
                            emp.last_name + "\n" +
                            emp.title + "\n" +
                            "Salary: " + emp.salary + "\n" +
                            emp.dept_name + "\n" +
                            "Manager: " + emp.manager + "\n");
        }
    }

    /**
     * Get all employees and salaries for a given role
     */
    public List<Employee> getSalariesByRole(String roleTitle)
    {
        List<Employee> employees = new ArrayList<>();
        try
        {
            String sql =
                    "SELECT e.emp_no, e.first_name, e.last_name, s.salary " +
                            "FROM employees e " +
                            "JOIN salaries s ON e.emp_no = s.emp_no " +
                            "JOIN titles t ON e.emp_no = t.emp_no " +
                            "WHERE s.to_date = '9999-01-01' " +
                            "AND t.to_date = '9999-01-01' " +
                            "AND t.title = ? " +
                            "ORDER BY e.emp_no ASC";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, roleTitle);

            ResultSet rset = pstmt.executeQuery();

            while (rset.next())
            {
                Employee emp = new Employee();
                emp.emp_no = rset.getInt("emp_no");
                emp.first_name = rset.getString("first_name");
                emp.last_name = rset.getString("last_name");
                emp.salary = rset.getInt("salary");
                employees.add(emp);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error fetching salaries by role: " + e.getMessage());
        }

        return employees;
    }

    /**
     * Display a list of employees and salaries
     */
    public void displaySalariesByRole(List<Employee> employees)
    {
        if (employees == null || employees.isEmpty()) {
            System.out.println("No employees found for this role.");
            return;
        }

        System.out.println("EmpNo\tFirst Name\tLast Name\tSalary");

        int totalSalary = 0;
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;

        for (Employee e : employees)
        {
            System.out.printf("%d\t%s\t%s\t%d%n", e.emp_no, e.first_name, e.last_name, e.salary);
            totalSalary += e.salary;
            if (e.salary < minSalary) minSalary = e.salary;
            if (e.salary > maxSalary) maxSalary = e.salary;
        }

        double avgSalary = totalSalary / (double) employees.size();

        System.out.println("\n--- Summary ---");
        System.out.println("Total employees: " + employees.size());
        System.out.println("Total salary: " + totalSalary);
        System.out.println("Average salary: " + String.format("%.2f", avgSalary));
        System.out.println("Minimum salary: " + minSalary);
        System.out.println("Maximum salary: " + maxSalary);
    }
}
