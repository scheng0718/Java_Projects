import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** food ordering main function
 *  1. find a data structure to store the menu information
 *  2. Use array or list in this use case? Use List interface and Use arraylist to implement
 *  3. How to add the menu? We can save the menu info in the list by adding them in a set
 */

public class FoodOrder {
    //define a set to represent the list of the food at the restaurant
    static List<Dish> dishList = new ArrayList<>();
    //save the customer's orders
    static List<Dish> customerDishList = new ArrayList<>();

    //initialize the menu
    public static void initDish() {
        Dish dish = new Dish(1, "Mapo Tofu", 12.5);
        dishList.add(dish);
        Dish dish2 = new Dish(2, "Vegetables", 10.5);
        dishList.add(dish2);
        dishList.add(new Dish(3, "Fried Chicken", 7.5));
        dishList.add(new Dish(4, "Stir Pork Belly", 16.5));
        dishList.add(new Dish(5, "Seafood soup", 21.5));
    }
    //demo main menu
    public static void showMenu() {
        System.out.println("---------------Main Menu-----------------");
        System.out.println("Menu\t\t 1");
        System.out.println("Items\t\t 2");
        System.out.println("Pay\t\t\t 3");
        System.out.println("--------Please select your service--------");
    }
    //show food menu
    public static void showFoodMenu() {
        System.out.println("----Please place your order-----");
        for (int i = 0; i < dishList.size(); i++) {
            Dish dish = dishList.get(i);
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }
        System.out.println("---Please enter the number to order, press 0 back to main menu");
    }
    //show ordered items
    public static void showOrderedItems() {
        System.out.println("----Show your ordered items--------");
        for (Dish dish : customerDishList) {
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }
    }
    //pay the check
    public static void pay() {
        System.out.println("Thanks for shopping with us today!");
        //define the total
        double total = 0;
        for (Dish dish : customerDishList) {
            total += dish.price;
        }
        System.out.println("Total amount is " + total + ", thanks!");
    }

    //prepare the food in advance to display to the usersm and customers can order too
    public static void main(String[] args) {
        //initialize the menu
        initDish();

        //Scanner class
        Scanner s = new Scanner(System.in);

        //Main menu should be displayed repeatedly, adding while loop
        while (true) {
            //Show the main menu to user: order, order details, and pay the check
            showMenu();
            //Get the content
            int num = s.nextInt();
            switch (num) {
                case 1:
                    while (true) {
                        //show the menu
                        showFoodMenu();
                        //Get the content from the customer's input
                        int id = s.nextInt();
                        //if enter 0 back to main menu
                        if (id == 0) {
                            break;
                        }
                        //if enter 1 - 5, return the details of the menu
                        Dish dish = dishList.get(id - 1);
                        //Show customers what food do you order
                        System.out.println("Your order is " + dish.name);
                        customerDishList.add(dish);
                    }
                case 2:
                    //show your ordered items
                    showOrderedItems();
                    break;
                case 3:
                    //pay the check and return (jump out the while loop)
                    pay();
                    return;
            }
        }
    }
}
