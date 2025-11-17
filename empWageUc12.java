package myApplication;

import java.util.*;

interface IComputeEmpWage {
    void addCompanyEmpWage(String companyName, int wagePerHour, int fullDayHours, int workingDaysPerMonth);
    void calculateWage();
    void displayAllCompanyWages();
    int getTotalWageByCompany(String companyName);
}

class CompanyEmpWage {
    String companyName;
    int wagePerHour;
    int fullDayHours;
    int workingDaysPerMonth;
    int totalWage;
    ArrayList<Integer> dailyWages;

    CompanyEmpWage(String companyName, int wagePerHour, int fullDayHours, int workingDaysPerMonth) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.fullDayHours = fullDayHours;
        this.workingDaysPerMonth = workingDaysPerMonth;
        this.totalWage = 0;
        this.dailyWages = new ArrayList<>();
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    @Override
    public String toString() {
        return "\nCompany: " + companyName +
                " | Wage/Hour: ₹" + wagePerHour +
                " | Working Days: " + workingDaysPerMonth +
                " | Total Wage: ₹" + totalWage +
                "\nDaily Wages: " + dailyWages;
    }
}

class EmpWageBuilder implements IComputeEmpWage {

    private ArrayList<CompanyEmpWage> companyList;
    private Map<String, CompanyEmpWage> companyMap;

    EmpWageBuilder() {
        companyList = new ArrayList<>();
        companyMap = new HashMap<>();
    }

    @Override
    public void addCompanyEmpWage(String companyName, int wagePerHour, int fullDayHours, int workingDaysPerMonth) {
        CompanyEmpWage company = new CompanyEmpWage(companyName, wagePerHour, fullDayHours, workingDaysPerMonth);
        companyList.add(company);
        companyMap.put(companyName, company);
    }

    @Override
    public void calculateWage() {
        Scanner sc = new Scanner(System.in);
        for (CompanyEmpWage company : companyList) {
            System.out.println("\n===============================");
            System.out.println("Calculating wage for: " + company.companyName);
            System.out.println("===============================");

            HashSet<String> attendanceSet = new HashSet<>();
            int totalHours = 0;
            int totalDays = 0;

            while (totalDays < company.workingDaysPerMonth && totalHours < 100) {
                System.out.println("\n1. Mark Full-time Attendance");
                System.out.println("2. Mark Part-time Attendance");
                System.out.println("3. Check Attendance");
                System.out.println("4. Next Day");
                System.out.println("5. Stop for this company");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                    case 2:
                        System.out.print("Enter employee name: ");
                        String name = sc.nextLine();
                        if (attendanceSet.contains(name)) {
                            System.out.println(name + " is already marked Present today.");
                            break;
                        }
                        attendanceSet.add(name);
                        System.out.print("Enter login time (0–23): ");
                        int login = sc.nextInt();
                        System.out.print("Enter logout time (0–23): ");
                        int logout = sc.nextInt();

                        int workedHrs = (logout >= login) ? logout - login : (24 - login) + logout;
                        if (workedHrs > company.fullDayHours) workedHrs = company.fullDayHours;

                        int dailyWage = workedHrs * company.wagePerHour;
                        company.dailyWages.add(dailyWage);
                        totalHours += workedHrs;

                        System.out.println("Employee " + name + " worked " + workedHrs + " hours, earned ₹" + dailyWage);
                        break;

                    case 3:
                        System.out.print("Enter employee name to check: ");
                        String chk = sc.nextLine();
                        if (attendanceSet.contains(chk))
                            System.out.println(chk + " is Present today.");
                        else
                            System.out.println(chk + " is Absent.");
                        break;

                    case 4:
                        // Move to next working day
                        totalDays++;
                        attendanceSet.clear();
                        System.out.println("Moved to Day " + totalDays + ". Attendance reset.");
                        break;

                    case 5:
                        totalDays = company.workingDaysPerMonth; // Exit loop
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

            int monthlyWage = totalHours * company.wagePerHour;
            company.setTotalWage(monthlyWage);
            System.out.println("\nTotal Hours Worked: " + totalHours);
            System.out.println("Total Monthly Wage for " + company.companyName + ": ₹" + monthlyWage);
        }
    }

    @Override
    public void displayAllCompanyWages() {
        System.out.println("\n======= ALL COMPANY WAGE DETAILS =======");
        for (CompanyEmpWage company : companyList) {
            System.out.println(company);
        }
    }

    @Override
    public int getTotalWageByCompany(String companyName) {
        if (companyMap.containsKey(companyName)) {
            return companyMap.get(companyName).totalWage;
        } else {
            System.out.println("Company not found!");
            return -1;
        }
    }
}

public class empWageUc12 {
    public static void main(String[] args) {
        IComputeEmpWage empWageBuilder = new EmpWageBuilder();

        // Add multiple companies
        empWageBuilder.addCompanyEmpWage("TCS", 20, 8, 20);
        empWageBuilder.addCompanyEmpWage("Infosys", 25, 8, 22);
        empWageBuilder.addCompanyEmpWage("HCL", 30, 8, 18);

        // Calculate wages interactively (with login/logout)
        empWageBuilder.calculateWage();

        // Display wages summary
        empWageBuilder.displayAllCompanyWages();

        // Check total wage by company
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter company name to view total wage: ");
        String query = sc.nextLine();
        int total = empWageBuilder.getTotalWageByCompany(query);
        if (total != -1)
            System.out.println("Total wage for " + query + " is ₹" + total);
    }
}
