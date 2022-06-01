//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class OrderSystem {
//
//    static List<Food> item = new ArrayList<>();
//    static List<Food> ordered = new ArrayList<>();
//
//    public static void initialMainMenu() {
//        System.out.println("-------Welcome to the Yuan Restaurant--------");
//        System.out.println("Please select your next service");
//        System.out.println("1  Order");
//        System.out.println("2  Placed Item");
//        System.out.println("3  Pay");
//        System.out.println("---------------------------------------------");
//    }
//    //initialize food menu
//    public static void initFoodMenu() {
//        item.add(new Food(1, "Cold Cucumber Dish", 7.50));
//        item.add(new Food(2, "Fried Chicken", 6.25));
//        item.add(new Food(3, "Fresh Sashimi", 15.50));
//        item.add(new Food(4, "Shrimp Fried Rice", 12.50));
//        item.add(new Food(5, "Beef Noodle Soup", 17.75));
//        item.add(new Food(6, "Sour and Spicy Soup", 10.25));
//    }
//
//    //Build a list to add all menu details in it
//    public static void foodMenu() {
//        for (Food food : item) {
//            System.out.println(food.id +"\t"+ food.name + "\t" +food.price);
//        }
//        System.out.println("-------------------------");
//        System.out.println("Please place your order and press 0 back to the main menu");
//    }
//
//    //check the ordered list
//    public static void checkMyOrder() {
//        for (Food food : ordered) {
//            System.out.println(food.id + "\t" + food.name + "\t" + food.price);
//        }
//    }
//
//    //get total
//    public static void getTotal(){
//        int sum = 0;
//        for (int i = 0; i < ordered.size(); i++) {
//            sum += ordered.get(i).price;
//        }
//        System.out.println("Your total today is" + sum + "\t" + "dollars, thanks!");
//    }
//
//    public static void main(String[] args) {
//        initFoodMenu();
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            //Start from the main menu
//            initialMainMenu();
//
//            int input = sc.nextInt();
//
//            if (input == 1) {
//                while (true) {
//                    foodMenu();
//                    int order = sc.nextInt();
//                    if (order == 0) {
//                        break;
//                    }
//                    Food dish = item.get(order - 1);
//                    System.out.println("Your order is " + dish.name);
//                    ordered.add(item.get(order - 1));
//                }
//            } else if (input == 2) {
//                while (true) {
//                    checkMyOrder();
//                    System.out.println("Please press 0 back to main menu");
//                    int num = sc.nextInt();
//                    if (num == 0) {
//                        break;
//                    } else {
//                        continue;
//                    }
//                }
//            } else if (input == 3) {
//                getTotal();
//                return;
//            } else {
//                continue;
//            }
//        }
//    }
//}
