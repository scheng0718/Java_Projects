import java.util.*;

public class OnlineOrderSystem {
    //use a list to save the info
    static List<Menu> appetizerMenu = new ArrayList<>();
    static List<Menu> entreeMenu = new ArrayList<>();
    static List<Menu> soupMenu = new ArrayList<>();
//    static List<Menu> orderedList = new ArrayList<>();
    static Set<Menu> orderedList = new HashSet<>();

    public static void initializeFoodMenu() {
        //Appetizer
        appetizerMenu.add(new Menu(1, "Cold Cucumber", 7.50, 1));
        appetizerMenu.add(new Menu(2, "Fried Chicken", 6.25, 1));
        appetizerMenu.add(new Menu(3, "Small Sashimi", 15.50, 1));
        //Entree
        entreeMenu.add(new Menu(4, "Shrimp Fried Rice", 12.50, 1));
        entreeMenu.add(new Menu(5, "Pork Chop Rice", 15.35, 1));
        //Soup
        soupMenu.add(new Menu(6, "Sour and Spicy Soup", 10.25, 1));
        soupMenu.add(new Menu(7, "Beef Noodle Soup", 10.25, 1));
    }
    //Main Menu
    public static void mainMenu() {
        System.out.println("------Welcome to Yuan's Restaurant------");
        System.out.println("1." + "\t" + "Order");
        System.out.println("2." + "\t" + "Placed Items");
        System.out.println("3." + "\t" + "Pay");
        System.out.println("----------------------------------------");
        System.out.println("Please select your next step");
    }
    //Food Menu
    public static void foodMenu() {
        System.out.println("-----------------Appetizer--------------");
        for (Menu menu : appetizerMenu) {
            System.out.println(menu.id + "\t" + menu.name + "\t" + menu.price);
        }
        System.out.println("-----------------Entree-----------------");
        for (Menu menu : entreeMenu) {
            System.out.println(menu.id + "\t" + menu.name + "\t" + menu.price);
        }
        System.out.println("-----------------Soup-------------------");
        for (Menu menu : soupMenu) {
            System.out.println(menu.id + "\t" + menu.name + "\t" + menu.price);
        }
        System.out.println("----------------------------------------");
        System.out.println("Please place your order and press 0 back to the main menu");
    }
    //check placed items
    public static void checkPlacedItems() {
        for (Menu menu : orderedList) {
            System.out.println("Your order is " + menu.name + ". You have " + menu.count + " order");
        }
    }
    //Check out
    public static void checkOut() {
        double sum = 0;
        for (Menu menu : orderedList) {
            sum += menu.price * menu.count;
        }
        System.out.println("Your total is " + sum +" dollars. Thanks!");
    }
    public static void main(String[] args) {
        //Initialize the food menu, and added to the list based on the category
        initializeFoodMenu();
        //Scanner class
        Scanner sc = new Scanner(System.in);
        while (true) {
            //Main menu
            mainMenu();
            int input = sc.nextInt();
            if (input == 1) {
                while (true) {
                    foodMenu();
                    int order = sc.nextInt();
                    if (order == 0) {
                        break;
                    } else if (order >= 1 && order <= 3) {
                        Menu item = appetizerMenu.get(order - 1);
                        if (orderedList.contains(item)) {
                            item.count++;
                        }
                        orderedList.add(item);
                        System.out.println("Your order is " + item.name);
                    } else if (order >= 4 && order <= 5) {
                        Menu item = entreeMenu.get(order - 4);
                        if (orderedList.contains(item)) {
                            item.count++;
                        }
                        orderedList.add(item);
                        System.out.println("Your order is " + item.name);
                    } else if (order >= 6 && order <= 7) {
                        Menu item = soupMenu.get(order - 6);
                        if (orderedList.contains(item)) {
                            item.count++;
                        }
                        orderedList.add(item);
                        System.out.println("Your order is " + item.name);
                    }
                }
            } else if (input == 2) {
                checkPlacedItems();
                System.out.println("Please press 0 back to main menu");
                int input1 = sc.nextInt();
            } else if (input == 3) {
                checkOut();
                break;
            }
        }
    }
}
