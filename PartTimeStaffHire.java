// PartTimeStaffHire class which inherits the staffHire class
public class PartTimeStaffHire extends StaffHire
 {
// additional variable for part time employees
 private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;
    
    // Constructor
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, 
                           String staffName, String joiningDate, String qualification, 
                           String appointedBy, boolean joined, int workingHour, 
                           double wagesPerHour, String shifts)

 {
        //call parent constructor for common attributtes
        super(vacancyNumber, designation, jobType, staffName, joiningDate, 
              qualification, appointedBy, joined);
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }
    
    // Accessor method(Getters) and Mutator method(Setters) for the class
    public int getWorkingHour() 
{
        return workingHour;
    }
    
    public void setWorkingHour(int workingHour) 
{
        this.workingHour = workingHour;
    }
    
    public double getWagesPerHour() 
{
        return wagesPerHour;
    }
    
    public void setWagesPerHour(double wagesPerHour)
 {
        this.wagesPerHour = wagesPerHour;
    }
    
    public String getShifts()
 {
        return shifts;
    }
    
    public boolean isTerminated()
 {
        return terminated;
    }
    
    public void setTerminated(boolean terminated)
 {
        this.terminated = terminated;
    }
    
    // Method to set shifts if the staff has joined
    public void setShifts(String newShifts)
 {
        if (isJoined())
 {
            this.shifts = newShifts;
        } else
 {
            System.out.println("Cannot set shifts as no staff is appointed yet.");
        }
    }
    
    // Method to terminate staff
    public void terminateStaff() 
{
        if (isTerminated())
 {
            System.out.println("Staff is already terminated.");
        } else
       
        //Clear staff details and mark as terminated
        {
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            this.terminated = true;
        }
    }
    
    // Override display method of staffHire class
    @Override
    public void display() 
{
        super.display();
        // If the staff has joined and is not terminated, display the working hours, wages per hour, shifts, and income per day
        if (isJoined() && !isTerminated())
 {
            System.out.println("Working Hours: " + workingHour);
            System.out.println("Wages Per Hour: " + wagesPerHour);
            System.out.println("Shifts: " + shifts);
            System.out.println("Income Per Day: " + (workingHour * wagesPerHour));
        }
        //Display termination status
        System.out.println("Terminated: " + (terminated ? "Yes" : "No"));
    }
}
