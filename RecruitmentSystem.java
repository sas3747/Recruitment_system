// RecruitmentSystem.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class RecruitmentSystem extends JFrame 
{
    private ArrayList<StaffHire> staffList;
    
    // Text fields for input
    private JTextField txtVacancyNumber;
    private JTextField txtDesignation;
    private JTextField txtJobType;
    private JTextField txtStaffName;
    private JTextField txtJoiningDate;
    private JTextField txtQualification;
    private JTextField txtAppointedBy;
    private JCheckBox chkJoined;
    private JTextField txtSalary;
    private JTextField txtWeeklyFractionalHours;
    private JTextField txtWorkingHour;
    private JTextField txtWagesPerHour;
    private JTextField txtShifts;
    private JTextField txtDisplayNumber;
    
    // Buttons
    private JButton btnAddFullTimeStaff;
    private JButton btnAddPartTimeStaff;
    private JButton btnSetSalary;
    private JButton btnSetShifts;
    private JButton btnTerminate;
    private JButton btnDisplay;
    private JButton btnClear;
    
    // Main method - entry point of the application
    public static void main(String[] args) 
{
        // Use SwingUtilities.invokeLater to ensure GUI is created on Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() 
{
            public void run()
 {
                RecruitmentSystem app = new RecruitmentSystem();
                app.setVisible(true);
            }
        });
    }
    
    // Constructor
    public RecruitmentSystem() 
{
        staffList = new ArrayList<>();
        
        // Set up the frame
        setTitle("Staff Recruitment System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        

        
        // Create panels
        JPanel inputPanel = new JPanel(new GridLayout(14, 2, 5, 5));
        JPanel buttonPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        
        // Create labels and text fields

        
        inputPanel.add(new JLabel("Vacancy Number:"));
        txtVacancyNumber = new JTextField(10);
        inputPanel.add(txtVacancyNumber);
        
        inputPanel.add(new JLabel("Designation:"));
        txtDesignation = new JTextField(20);
        inputPanel.add(txtDesignation);
        
        inputPanel.add(new JLabel("Job Type:"));
        txtJobType = new JTextField(20);
        inputPanel.add(txtJobType);
        
        inputPanel.add(new JLabel("Staff Name:"));
        txtStaffName = new JTextField(20);
        inputPanel.add(txtStaffName);
        
        inputPanel.add(new JLabel("Joining Date:"));
        txtJoiningDate = new JTextField(20);
        inputPanel.add(txtJoiningDate);
        
        inputPanel.add(new JLabel("Qualification:"));
        txtQualification = new JTextField(20);
        inputPanel.add(txtQualification);
        
        inputPanel.add(new JLabel("Appointed By:"));
        txtAppointedBy = new JTextField(20);
        inputPanel.add(txtAppointedBy);
        
        inputPanel.add(new JLabel("Joined:"));
        chkJoined = new JCheckBox();
        inputPanel.add(chkJoined);
        
        inputPanel.add(new JLabel("Salary:"));
        txtSalary = new JTextField(10);
        inputPanel.add(txtSalary);
        
        inputPanel.add(new JLabel("Weekly Fractional Hours:"));
        txtWeeklyFractionalHours = new JTextField(10);
        inputPanel.add(txtWeeklyFractionalHours);
        
        inputPanel.add(new JLabel("Working Hour:"));
        txtWorkingHour = new JTextField(10);
        inputPanel.add(txtWorkingHour);
        
        inputPanel.add(new JLabel("Wages Per Hour:"));
        txtWagesPerHour = new JTextField(10);
        inputPanel.add(txtWagesPerHour);
        
        inputPanel.add(new JLabel("Shifts:"));
        txtShifts = new JTextField(20);
        inputPanel.add(txtShifts);
        
       
        // Create buttons
        btnAddFullTimeStaff = new JButton("Add Full Time Staff");
        buttonPanel.add(btnAddFullTimeStaff);
        
        btnAddPartTimeStaff = new JButton("Add Part Time Staff");
        buttonPanel.add(btnAddPartTimeStaff);
        
        btnSetSalary = new JButton("Set Salary");
        buttonPanel.add(btnSetSalary);
        
        btnSetShifts = new JButton("Set Working Shifts");
        buttonPanel.add(btnSetShifts);
        
        btnTerminate = new JButton("Terminate Part Time Staff");
        buttonPanel.add(btnTerminate);

        btnClear = new JButton("Clear");
        buttonPanel.add(btnClear);
        
        
       
        
        buttonPanel.add(new JLabel("Display Number:"));
        txtDisplayNumber = new JTextField(10);
        buttonPanel.add(txtDisplayNumber);
        
        btnDisplay = new JButton("Display");
        buttonPanel.add(btnDisplay);
        // Add panels to frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Add action listeners
        btnAddFullTimeStaff.addActionListener(new ActionListener() 
{
            public void actionPerformed(ActionEvent e) 
{
                addFullTimeStaff();
            }
        });
        btnAddPartTimeStaff.addActionListener(new ActionListener() 
{
            public void actionPerformed(ActionEvent e)
 {
                addPartTimeStaff();
            }
        });
        btnSetSalary.addActionListener(new ActionListener() 
{
            public void actionPerformed(ActionEvent e)
 {
                setSalary();
            }
        });
        btnSetShifts.addActionListener(new ActionListener() 
{
            public void actionPerformed(ActionEvent e)

 {
                setShifts();
            }
        });
        btnTerminate.addActionListener(new ActionListener() 
{
            public void actionPerformed(ActionEvent e) 
{
                terminateStaff();
            }
        });
        
        btnDisplay.addActionListener(new ActionListener() 

{
            public void actionPerformed(ActionEvent e) 
{
                displayStaff();
            }
        });
        
        btnClear.addActionListener(new ActionListener() 
{
            public void actionPerformed(ActionEvent e) 
{
                clearFields();
            }
        });
    }
    
    // Method to add full time staff
    private void addFullTimeStaff()
 {
        try 
{
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());
            String designation = txtDesignation.getText();
            String jobType = txtJobType.getText();
            String staffName = txtStaffName.getText();
            String joiningDate = txtJoiningDate.getText();
            String qualification = txtQualification.getText();
            String appointedBy = txtAppointedBy.getText();
            boolean joined = chkJoined.isSelected();
            double salary = Double.parseDouble(txtSalary.getText());
            int weeklyFractionalHours = Integer.parseInt(txtWeeklyFractionalHours.getText());
            
            FullTimeStaffHire fullTimeStaff = new FullTimeStaffHire(
                vacancyNumber, designation, jobType, staffName, joiningDate,
                qualification, appointedBy, joined, salary, weeklyFractionalHours
            );
            
            staffList.add(fullTimeStaff);
            JOptionPane.showMessageDialog(this, "Full Time Staff added successfully!");
            clearFields();
        } catch (NumberFormatException ex)
 {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for numeric fields.");
        }
    }
    
    // Method to add part time staff
    private void addPartTimeStaff() 
{
        try
 {
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());
            String designation = txtDesignation.getText();
            String jobType = txtJobType.getText();
            String staffName = txtStaffName.getText();
            String joiningDate = txtJoiningDate.getText();
            String qualification = txtQualification.getText();
            String appointedBy = txtAppointedBy.getText();
            boolean joined = chkJoined.isSelected();
            int workingHour = Integer.parseInt(txtWorkingHour.getText());
            double wagesPerHour = Double.parseDouble(txtWagesPerHour.getText());
            String shifts = txtShifts.getText();
            
            PartTimeStaffHire partTimeStaff = new PartTimeStaffHire(
                vacancyNumber, designation, jobType, staffName, joiningDate,
                qualification, appointedBy, joined, workingHour, wagesPerHour, shifts
            );
            
            staffList.add(partTimeStaff);
            JOptionPane.showMessageDialog(this, "Part Time Staff added successfully!");
            clearFields();
        } catch (NumberFormatException ex)
 {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for numeric fields.");
        }
    }
    
    // Method to set salary for full time staff
    private void setSalary()
 {
        try 
{
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());
            double newSalary = Double.parseDouble(txtSalary.getText());
            
            boolean found = false;
            for (StaffHire staff : staffList) 
{
                if (staff.getVacancyNumber() == vacancyNumber) 
{
                    if (staff instanceof FullTimeStaffHire)
 {
                        FullTimeStaffHire fullTimeStaff = (FullTimeStaffHire) staff;
                        fullTimeStaff.setSalary(newSalary);
                        found = true;
                        JOptionPane.showMessageDialog(this, "Salary updated successfully!");
                        break;
                    } else
 {
                        JOptionPane.showMessageDialog(this, "This vacancy is not for a full-time staff.");
                    }
                }
            }
            if (!found) 
{
                JOptionPane.showMessageDialog(this, "Vacancy number not found.");
            }
        } catch (NumberFormatException ex)
 {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for numeric fields.");
        }
    }
    
    // Method to set shifts for part time staff
    private void setShifts() 
{
        try
 {
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());
            String newShifts = txtShifts.getText();
            
            boolean found = false;
            for (StaffHire staff : staffList)
 {
                if (staff.getVacancyNumber() == vacancyNumber) 
{
                    if (staff instanceof PartTimeStaffHire)
 {
                        PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                        partTimeStaff.setShifts(newShifts);
                        found = true;
                        JOptionPane.showMessageDialog(this, "Shifts updated successfully!");
                        break;
                    } else
 {
                        JOptionPane.showMessageDialog(this, "This vacancy is not for a part-time staff.");
                    }
                }
            }
            if (!found) 
{
                JOptionPane.showMessageDialog(this, "Vacancy number not found.");
            }
        } catch (NumberFormatException ex) 
{
            JOptionPane.showMessageDialog(this, "Please enter a valid vacancy number.");
        }
    }
    
    // Method to terminate part time staff
    private void terminateStaff()
 {
        try 
{
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());
            
            boolean found = false;
            for (StaffHire staff : staffList)
 {
                if (staff.getVacancyNumber() == vacancyNumber) 
{
                    if (staff instanceof PartTimeStaffHire)
 {
                        PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                        partTimeStaff.terminateStaff();
                        found = true;
                        JOptionPane.showMessageDialog(this, "Staff terminated successfully!");
                        break;
                    } else
 {
                        JOptionPane.showMessageDialog(this, "This vacancy is not for a part-time staff.");
                    }
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Vacancy number not found.");
            }
        } catch (NumberFormatException ex)
 {
            JOptionPane.showMessageDialog(this, "Please enter a valid vacancy number.");
        }
    }
    
    // Method to display staff information
    private void displayStaff()
 {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1) {
            if (displayNumber < staffList.size())
 {
                StaffHire staff = staffList.get(displayNumber);
                // Create a custom dialog to display staff information
                JFrame displayFrame = new JFrame("Staff Information");
                JTextArea textArea = new JTextArea(20, 40);
                textArea.setEditable(false);
                
                // Create a custom output stream to capture the output
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                PrintStream old = System.out;
                System.setOut(ps);
                
                // Call display method
                staff.display();
                
                // Reset System.out and get the captured output
                System.out.flush();
                System.setOut(old);
                textArea.setText(baos.toString());
                
                JScrollPane scrollPane = new JScrollPane(textArea);
                displayFrame.add(scrollPane);
                displayFrame.pack();
                displayFrame.setVisible(true);
            } else 
{
                JOptionPane.showMessageDialog(this, "Invalid display number. Number exceeds list size.");
            }
        }
    }
    
    // Method to get display number
    private int getDisplayNumber()
 {
        try {
            int displayNumber = Integer.parseInt(txtDisplayNumber.getText());
            if (displayNumber >= 0 && displayNumber < staffList.size())
 {
                return displayNumber;
            } else
 {
                JOptionPane.showMessageDialog(this, "Display number out of range. Valid range: 0 to " + (staffList.size() - 1));
                return -1;
            }
        } catch (NumberFormatException ex) 
{
            JOptionPane.showMessageDialog(this, "Please enter a valid integer for display number.");
            return -1;
        }
    }
    
    // Method to clear input fields
    private void clearFields() 
{
        txtVacancyNumber.setText("");
        txtDesignation.setText("");
        txtJobType.setText("");
        txtStaffName.setText("");
        txtJoiningDate.setText("");
        txtQualification.setText("");
        txtAppointedBy.setText("");
        chkJoined.setSelected(false);
        txtSalary.setText("");
        txtWeeklyFractionalHours.setText("");
        txtWorkingHour.setText("");
        txtWagesPerHour.setText("");
        txtShifts.setText("");
        txtDisplayNumber.setText("");
    }
}

