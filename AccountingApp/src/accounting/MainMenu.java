package accounting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMenu {

    //Create a set to store
    static List<Bills> billsList = new ArrayList<>();

    //initialize bill objects and added them to the list
    static {
        billsList.add(new Bills("Food", "Card", "Cost", 30.00, "2022-05-02", "Family Gathering"));
        billsList.add(new Bills("Cloth", "Card", "Cost", 130.00, "2022-04-12", "Valley Fair Mall"));
        billsList.add(new Bills("Salary", "Cash", "Earn", 4000.00, "2022-06-01", "Bi-weekly Salary"));
        billsList.add(new Bills("Food", "Card", "Cost", 26.00, "2022-05-08", "Coworkers"));
        billsList.add(new Bills("Stock", "Cash", "Earn", 20.00, "2022-04-04", "Apple's Stock"));
        billsList.add(new Bills("Stock", "Cash", "Earn", 130.00, "2022-05-04", "Amazon's Stock"));
        billsList.add(new Bills("Gift", "Card", "Cost", 40.00, "2022-06-02", "Baby Shower"));
        billsList.add(new Bills("Travel", "Card", "Cost", 50.00, "2022-04-21", "Personal vehicle"));
        billsList.add(new Bills("Grocery", "Card", "Cost", 65.50, "2022-06-04", "Trader Joes"));
        billsList.add(new Bills("Food", "Card", "Cost", 20.00, "2022-05-25", "BBQ with Friends"));
        billsList.add(new Bills("Travel", "Card", "Cost", 10.00, "2022-04-13", "Bart to Berkeley"));
        billsList.add(new Bills("Salary", "Cash", "Earn", 4200.00, "2022-05-01", "Bi-weekly Salary"));
        billsList.add(new Bills("Travel", "Card", "Cost", 200.00, "2022-06-01", "LA Trip"));
        billsList.add(new Bills("Food", "Cash", "Cost", 50.00, "2022-05-22", "Beef noodle soup"));
        billsList.add(new Bills("Salary", "Cash", "Earn", 4000.00, "2022-04-01", "Bi-weekly Salary"));
    }

    public static void showMain() {
        System.out.println("--------------Main Menu: Accounting App--------------");
        System.out.println("1. Add New Items 2. Delete Items 3. Account History 4. Exit");
        System.out.println("Please enter [1-4]: ");
    }

    public static void run() {
        showMain();
        //create flag
        boolean flag = true;

        //Create scanner
        Scanner scanner = new Scanner(System.in);
        //put into the while true
        while (flag) {
            //Get the input from the users
            int op = scanner.nextInt();
            //Determine if 1 or 2 or 3 or 4, use
            switch (op) {
                case 1:
                    addBills();
                    break;
                case 2:
                    removeBills();
                    break;
                case 3:
                    select();
                    break;
                case 4:
                    //Use a flag to exit the while loop
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter again");
            }
        }
        System.out.println("Exit the System, See you again!");
    }

    private static void addBills() {
        System.out.println("Main Menu >> Add New Items");
        Scanner inScanner = new Scanner(System.in);
        Bills bills = new Bills();

        System.out.println("Please enter name");
        bills.setName(inScanner.next());

        System.out.println("Please enter account");
        bills.setAccount(inScanner.next());

        System.out.println("Please enter type");
        bills.setType(inScanner.next());

        System.out.println("Please enter total");
        bills.setTotal(inScanner.nextDouble());

        System.out.println("Please enter time");
        bills.setTime(inScanner.next());

        System.out.println("Please enter note");
        bills.setDesc(inScanner.next());

        billsList.add(bills);
        System.out.println("Updated Success!");

        showMain();
    }

    private static void removeBills() {
        System.out.println("Main Menu >> Delete Items");
        System.out.println("Please enter the ID you want to remove");

        Scanner inScanner = new Scanner(System.in);
        int id = inScanner.nextInt();

        billsList.remove(id - 1);
        System.out.println("Delete Success");
        showMain();
    }
    /** Three options
     * 1. Return all
     * 2. Query by Date
     * 3. Query by type of expenses and revenues
     */
    private static void select() {
        System.out.println("Main Menu >> Account History");
        System.out.println("1. Return All, 2. Query by Date, 3. Query by Cost or Earn");
        Scanner scanner = new Scanner(System.in);
        int op = scanner.nextInt();
        switch(op) {
            case 1:
                selectAll();
                break;
            case 2:
                selectByDate();
                break;
            case 3:
                selectByType();
                break;
        }
        //return and show the main menu
        showMain();
    }

    private static void selectAll() {
        print(billsList);
    }

    private static void selectByDate() {
        //Create an object with time format
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Main Menu >> Account History >> Query by Date");
        Scanner scanner = new Scanner(System.in);
        //Enter start date
        System.out.println("Please enter: Start Date");
        String start = scanner.next();
        //Enter end date
        System.out.println("Please enter: End Date");
        String end = scanner.next();
        List<Bills> newList = billsList.stream().filter(bills -> {
            String time = bills.getTime();
            //convert string to specific time
            try {
                Date startDate = format.parse(start);
                Date endDate = format.parse(end);
                Date timeDate = format.parse(time);
                if (timeDate.before(endDate) && timeDate.after(startDate)) {
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());

        print(newList);
    }

    private static void selectByType() {
        System.out.println("Main Menu >> Account History >> Query by Cost or Earn");
        System.out.println("Please enter: Cost or Earn");

        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();

        Predicate<Bills> byType = bills -> bills.getType().equals(type);
        List<Bills> filteredList = billsList.stream().filter(byType).collect(Collectors.toList());
        print(filteredList);

//        Filter by type, after version 1.8, we can filter using stream and convert back to List<Bills>
//        List<Bills> newList = billsList.stream().filter(bills -> {
//            String type1 = bills.getType();
//            return type1.equals(type);
//        }).collect(Collectors.toList());

//        print(newList);
    }

    public static void print(List<Bills> bills) {
        System.out.println("ID\t\tName\t\t\tAccount\t\t\tType\t\tTotal\t\tDate\t\t\t\tNotes");
        for (int i = 0; i < bills.size(); i++) {
            Bills bills1 = bills.get(i);
            System.out.println(i + 1 + "\t\t" + bills1.getName() + "\t\t\t" + bills1.getAccount() + "\t\t\t" + bills1.getType() + "\t\t" + bills1.getTotal() + "\t\t" + bills1.getTime() + "\t\t\t" + bills1.getDesc());
        }
    }
    public static void main(String[] args) {
        run();
    }
}
