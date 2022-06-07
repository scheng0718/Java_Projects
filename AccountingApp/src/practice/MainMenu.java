package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainMenu {
    static List<Bills> billsList = new ArrayList<>();
    static {
        billsList.add(new Bills("Food", "Card", "Expense", 30.00, "2021-11-02", "Family Gathering"));
        billsList.add(new Bills("Movie", "Card", "Expense", 130.00, "2021-08-12", "Valley Fair Mall"));
        billsList.add(new Bills("Salary", "Cash", "Income", 4000.00, "2021-11-01", "Bi-weekly Salary"));
        billsList.add(new Bills("Food", "Card", "Expense", 26.00, "2021-01-08", "Coworkers"));
        billsList.add(new Bills("Stock", "Cash", "Income", 20.00, "2021-04-04", "Apple's Stock"));
        billsList.add(new Bills("Stock", "Cash", "Income", 130.00, "2020-05-04", "Amazon's Stock"));
        billsList.add(new Bills("Gift", "Card", "Expense", 40.00, "2020-06-02", "Baby Shower"));
        billsList.add(new Bills("Travel", "Card", "Expense", 50.00, "2021-09-21", "Personal vehicle"));
        billsList.add(new Bills("Grocery", "Card", "Expense", 65.50, "2020-06-04", "Trader Joes"));
        billsList.add(new Bills("Food", "Card", "Expense", 20.00, "2022-05-25", "BBQ with Friends"));
        billsList.add(new Bills("Travel", "Card", "Expense", 10.00, "2022-04-13", "Bart to Berkeley"));
        billsList.add(new Bills("Salary", "Cash", "Income", 4200.00, "2022-03-01", "Bi-weekly Salary"));
        billsList.add(new Bills("Travel", "Card", "Expense", 200.00, "2022-06-01", "LA Trip"));
        billsList.add(new Bills("Food", "Cash", "Expense", 50.00, "2022-05-22", "Beef noodle soup"));
        billsList.add(new Bills("Salary", "Cash", "Income", 4000.00, "2022-04-01", "Bi-weekly Salary"));
    }

    //Main logic
    public static void run() {
        showMenu();
        Scanner scanner = new Scanner(System.in);
        //Use a flag to exit the application
        boolean flag = true;
        while (flag) {
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    addNewItems();
                    break;
                case 2:
                    deleteItems();
                    break;
                case 3:
                    showHistoryMenu();
                    break;
                case 4:
                    System.out.println("Exit the application, and see you again!");
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter again!");
                    break;
            }
        }
    }
    //Show Main Menu
    public static void showMenu() {
        System.out.println("         Personal Account App");
        System.out.println("--------------Main Menu------------------");
        System.out.println("1. Add New Items");
        System.out.println("2. Delete Items");
        System.out.println("3. History");
        System.out.println("4. Exit");
        System.out.println("Please select [1-4]:");
    }
    //Case 1: Add new Items
    private static void addNewItems() {
        System.out.println("Main Menu >> Add New Items");
        Scanner scanner = new Scanner(System.in);
        //create a new object
        Bills bills = new Bills();

        System.out.println("Please enter the Category");
        bills.setCategory(scanner.next());

        System.out.println("Please enter the Account");
        bills.setAccount(scanner.next());

        System.out.println("Please enter the Type of Expense/Income");
        bills.setType(scanner.next());

        System.out.println("Please enter the Amount");
        bills.setTotal(scanner.nextDouble());

        System.out.println("Please enter the Date");
        bills.setDate(scanner.next());

        System.out.println("Please enter the Notes");
        bills.setNotes(scanner.next());

        //Add to the original list
        billsList.add(bills);
        System.out.println("The item has been added successfully!!");
        showMenu();
    }
    //Case 2: Delete Items
    private static void deleteItems() {
        System.out.println("Main Menu >> Delete Items");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide the ID that you would like to delete");
        int id = scanner.nextInt();

        billsList.remove(id - 1);
        System.out.println("The item has been deleted successfully!");
        showMenu();
    }
    //Case 3: Sub-Menu under History
    private static void showHistoryMenu() {
        System.out.println("Main Menu >> History");
        System.out.println("1. Show All Records");
        System.out.println("2. Filter By Date");
        System.out.println("3. Filter By Types");
        System.out.println("Please select to proceed");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println("All Records");
                showAll();
                break;
            case 2:
                System.out.println("Filter by Date");
                filterByDate();
                break;
            case 3:
                System.out.println("Filter by Types");
                filterByTypes();
                break;
        }
        showMenu();
    }
    //Case 3.1: Show all records
    private static void showAll() {
        System.out.println("Main Menu >> History >> All Records");
        print(billsList);

    }
    //Case 3.2 Filter By Date
    private static void filterByDate() {
        System.out.println("Main Menu >> History >> Filter By Date");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the start date");
        String start = scanner.next();
        System.out.println("Please enter the end date");
        String end = scanner.next();


        List<Bills> filteredList = billsList.stream().filter(bills -> {
            String date = bills.getDate();

            try {
                Date startDate = format.parse(start);
                Date endDate = format.parse(end);
                Date currDate = format.parse(date);
                if (currDate.after(startDate) && currDate.before(endDate)) {
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());

        print(filteredList);
    }
    //Case 3.3 Filter By Type
    private static void filterByTypes() {
        System.out.println("Main Menu >> History >> Filter By Types");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Expense or Income to filter");
        String input = scanner.next();

        List<Bills> filteredList = billsList.stream().filter(bills -> {
            String type1 = bills.getType();
            if (type1.equals(input)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());

        print(filteredList);
    }

    private static void print(List<Bills> billsList) {
        System.out.println("ID" + "\t\t" + "CATEGORY" + "\t\t" + "ACCOUNT" + "\t\t" + "TYPE" + "\t\t" + "AMOUNT" + "\t\t" + "DATE" + "\t\t\t" + "NOTES");
        for (int i = 0; i < billsList.size(); i++) {
            Bills bill = billsList.get(i);
            System.out.println(i + 1 + "\t\t" + bill.category + "\t\t\t" + bill.account + "\t\t" + bill.type + "\t\t" + bill.total + "\t\t" + bill.date + "\t\t" + bill.notes);
        }
    }

    public static void main(String[] args) {
        run();
    }
}




