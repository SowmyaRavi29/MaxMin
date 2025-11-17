package myApplication;

import java.util.*;

public class empWagrCompany {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter company name: ");
        String company = sc.nextLine();

        WageCalculator wc = new WageCalculator();
        wc.calculate(company);
    }
}

class WageCalculator {

    public void calculate(String companyName) {

        System.out.println("Calculating wage for: " + companyName);


        int fullDayHour = 8;
        int wagePerHour = 20;
        int partTimeHr = 8;
        int wageDaysMonth = 20;
        int amntchk = 0;
        Scanner sc = new Scanner(System.in);
        HashSet<String> attendanceSet = new HashSet<>();
        System.out.println("WELCOME TO EMPLOYEE WAGE COMPUTATION PROGRAM ON MASTER BRANCH");
 while(true){
     System.out.println("Enter Employee Status ");
     System.out.println("1.Full Time");
     System.out.println("2.Part Time");
    // System.out.println("3.Mark Attendance");
     System.out.println("3.Check Attendance");
     System.out.println("4.Monthly Wage Calculation");
     System.out.println("5. Exit");
     int empstatus = sc.nextInt();

     switch(empstatus){
         case 1:
             System.out.println("FULL TIME EMPLOYMENT");
             sc.nextLine();
             System.out.println("Mark Attendance");
             System.out.println("Enter employee name : ");
             String name = sc.nextLine();

             if(attendanceSet.contains(name)){
                 System.out.println(name + " is already marked Present.");
             }else{
                 attendanceSet.add(name);
                 System.out.println(name + " marked as Present successfully!");
             }
             System.out.println("Enter login time : ");
             int logInHr = sc.nextInt();
             System.out.println("Enter logout time : ");
             int logOutHr = sc.nextInt();
             int totalHours;

             if (logOutHr < logInHr) {
                 totalHours = (24 - logInHr) + logOutHr;
                 int totalHours1 = totalHours % 12;
                 System.out.println("Total Hours : "+totalHours1);
             } else {
                 totalHours = logOutHr - logInHr;
                 System.out.println("Total Hours : "+totalHours);
             }
             if(totalHours < fullDayHour){
                 amntchk = totalHours * wagePerHour;
                 System.out.println("Your today wage is "+amntchk);

             }else{
                 amntchk = fullDayHour * wagePerHour;
                 System.out.println("Your today wage is "+amntchk);
             }
             break;

         case 2:
             System.out.println("PART TIME EMPLOYMENT");
             sc.nextLine();
             System.out.println("Mark Attendance");
             System.out.println("Enter employee name : ");
             String name1 = sc.nextLine();

             if(attendanceSet.contains(name1)){
                 System.out.println(name1 + " is already marked Present.");
             }else{
                 attendanceSet.add(name1);
                 System.out.println(name1    + " marked as Present successfully!");
             }
             System.out.println("Enter login time : ");
             int logPTInHr = sc.nextInt();
             System.out.println("Enter logout time : ");
             int logPTOutHr = sc.nextInt();
             int totalHoursPT;

             if (logPTOutHr < logPTInHr) {
                 totalHoursPT = (24 - logPTInHr) + logPTOutHr;
                 int totalHours1 = totalHoursPT % 12;
                 System.out.println("Total Hours : "+totalHours1);
             } else {
                 totalHoursPT = logPTOutHr - logPTInHr;
                 System.out.println("Total Hours : "+totalHoursPT);
             }
             if(totalHoursPT < fullDayHour){
                 amntchk = totalHoursPT * wagePerHour;
                 System.out.println("Your today wage is "+amntchk);

             }else{
                 amntchk = fullDayHour * wagePerHour;
                 System.out.println("Your today wage is "+amntchk);
             }
             break;
        /* case 3:
               *//* System.out.println("Enter attendance P/A: ");
                String check = sc.nextLine();*//*
                *//*Random random = new Random();
                 int attendance = random.nextInt(2);
                if (*//**//*Objects.equals(check, "P") &&*//**//* attendance == 1) {
                    System.out.println("Employee is Present");
                } else {
                    System.out.println("Employee is Absent");
                }
                break;*//*
             sc.nextLine();
             System.out.println("Mark Attendance");
             System.out.println("Enter employee name : ");
             String name = sc.nextLine();

             if(attendanceSet.contains(name)){
                 System.out.println(name + " is already marked Present.");
             }else{
                 attendanceSet.add(name);
                 System.out.println(name + " marked as Present successfully!");
             }
             break;*/

         case 3:
             System.out.println("Check Attendance");
             sc.nextLine();
             System.out.println("Enter employee name : ");
             String nameChk = sc.nextLine();

             if(attendanceSet.contains(nameChk)){
                 System.out.println(nameChk+" is Present");
             }else{
                 System.out.println(nameChk+" is Absent");
             }
             break;

         /*case 5:
             System.out.println("MONTHLY WAGE CALCULATION");
             Random random = new Random();
             int totalWage = 0;
             int presentDays = 0;

             for (int day = 1; day <= wageDaysMonth; day++) {
                 int attendance = random.nextInt(2); // 0 = Absent, 1 = Present
                 if (attendance == 1) {
                     presentDays++;
                     int dailyWage = fullDayHour * wagePerHour;
                     totalWage += dailyWage;
                 }
             }

             System.out.println("Total Working Days: " + wageDaysMonth);
             System.out.println("Days Present: " + presentDays);
             System.out.println("Days Absent: " + (wageDaysMonth - presentDays));
             System.out.println("Total Monthly Wage: ₹" + totalWage);
             break;*/
			/*
			 * case 4:
			 * System.out.println("MONTHLY WAGE CALCULATION (Till 100 Hrs or 20 Days)");
			 * Random random = new Random();
			 * 
			 * int totalWorkingDays = 0; int totalWorkingHours = 0; int totalWage = 0;
			 * 
			 * // Continue till either condition is reached while (totalWorkingDays < 20 &&
			 * totalWorkingHours < 100) { totalWorkingDays++; int attendance =
			 * random.nextInt(3); // 0=Absent, 1=Part-time, 2=Full-time
			 * 
			 * int dailyHours = 0; int dailyWage = 0;
			 * 
			 * switch (attendance) { case 0: dailyHours = 0; break; case 1: dailyHours = 4;
			 * break; case 2: dailyHours = 8; break; }
			 * 
			 * totalWorkingHours += dailyHours; dailyWage = dailyHours * wagePerHour;
			 * totalWage += dailyWage;
			 * 
			 * System.out.println("Day " + totalWorkingDays + ": Worked " + dailyHours +
			 * " hrs, Earned ₹" + dailyWage + ", Total Hours = " + totalWorkingHours); }
			 * 
			 * System.out.println(" MONTH SUMMARY ");
			 * System.out.println("Total Working Days : " + totalWorkingDays);
			 * System.out.println("Total Working Hours: " + totalWorkingHours);
			 * System.out.println("Total Monthly Wage : ₹" + totalWage); break;
			 */
             
         case 4:
        	    System.out.println("MONTHLY WAGE CALCULATION");

        	    System.out.println("Enter total working days: ");
        	    int days = sc.nextInt();

        	    System.out.println("Enter total working hours: ");
        	    int hours = sc.nextInt();

        	    if (days > 20 || hours > 100) {
        	        System.out.println("Invalid Entry! Limit exceeded.");
        	        System.out.println("Days should be <= 20 and Hours <= 100.");
        	        System.out.println("Consider this as NEXT month.");
        	    } else {
        	        int monthlyWage = hours * wagePerHour;
        	        System.out.println("Total Working Days : " + days);
        	        System.out.println("Total Working Hours: " + hours);
        	        System.out.println("Monthly Wage       : ₹" + monthlyWage);
        	    }
        	    break;

         case 5:
             System.out.println("Exiting the program");
             sc.close();
             return;

         default:
             System.out.println("Invalid choice! Please select 1 to 5.");

     }
 }

    
    }
}
