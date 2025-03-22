// FullTimeStaffHire.java
public class FullTimeStaffHire extends StaffHire {
    private double salary;
    private int weeklyFractionalHours;
    
    // Constructor
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, 
                           String staffName, String joiningDate, String qualification, 
                           String appointedBy, boolean joined, double salary, 
                           int weeklyFractionalHours) {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, 
              qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }
    
    // Getters and Setters
    public double getSalary() {
        return salary;
    }
    
    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }
    
    // Method to set salary
    public void setSalary(double newSalary) {
        if (isJoined()) {
            this.salary = newSalary;
        } else {
            System.out.println("Cannot set salary as no staff is appointed yet.");
        }
    }
    
    // Method to set weekly fractional hours
    public void setWeeklyFractionalHours(int newWeeklyFractionalHours) {
        this.weeklyFractionalHours = newWeeklyFractionalHours;
    }
    
    // Override display method
    @Override
    public void display() {
        super.display();
        if (isJoined()) {
            System.out.println("Salary: " + salary);
            System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
        }
    }
}
