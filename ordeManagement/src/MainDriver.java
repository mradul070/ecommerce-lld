package ordeManagement.src;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import ordeManagement.src.Model.User;
import ordeManagement.src.service.Impl.CartServiceImpl;
import ordeManagement.src.service.Impl.ItemServiceImpl;
import ordeManagement.src.service.Impl.UserServiceImpl;
import ordeManagement.src.service.UserService;
import ordeManagement.src.service.CartService;
import ordeManagement.src.service.ItemService;
import ordeManagement.src.Enum.CategoryType;
import ordeManagement.src.Enum.UserType;
import ordeManagement.src.Model.Cart;
import ordeManagement.src.Model.Item;

public class MainDriver {
    public static void main(String[] args) throws Exception {
        fillDummyRecord(10);
        displayRecord();
        UserService userService = new UserServiceImpl();
        ItemService itemService = new ItemServiceImpl();
        User user =  userService.loginUser("xyz17@gamil.com");
        System.out.println(user);
        if (user != null) {
            CartService cartService = new CartServiceImpl();
            cartService.addItem(itemService.getItemById(10), user, 2);
            List<Cart> item = (List<Cart>) cartService.getUserCart(user);
            cartService.displayCart(item);
            cartService.addItem(itemService.getItemById(8), user, 2);
            item = (List<Cart>) cartService.getUserCart(user);
            cartService.displayCart(item);
            cartService.removeItem(8, user);
            item = (List<Cart>) cartService.getUserCart(user);
            cartService.displayCart(item);
        } else {
            System.out.println("Unauthorized user");
        }
    }

    
    public static void fillDummyRecord(int n) {
        for (int i = 1; i <= n; i++) {
            int random = new Random().nextInt(20);
            String value = String.valueOf(random);
            User user = new User.CreateUser()
            .setId(i+1)
            .setEmail("xyz" + value + "@gamil.com")
            .setFirstName("xyz" + value)
            .setLastName(value)
            .setUserType(UserType.CUSTOMER)
            .build();
            UserService userService = new UserServiceImpl();
            userService.createUser(user);
        }
        ordeManagement.src.service.ItemService itemService = new ItemServiceImpl();
        CategoryType[] category = CategoryType.values();
        for (int i = 1; i<= n; i++) {
            int random = new Random().nextInt(100);
            double price = new Random().nextDouble() * 1000;
            DecimalFormat df = new DecimalFormat("#.##"); 
            Item item = new Item(i,"zyz" + random , category[i%category.length],Double.parseDouble(df.format(price)), new Random().nextInt(10));
            itemService.createItem(item);
        }
    }
    public static void displayRecord() {
        ItemService itemService = new ItemServiceImpl();
        UserService userService = new UserServiceImpl();
        List<Object> users = userService.getUsers();
        for (Object user: users) {
            User userRecord = (User) user;
            System.out.println(userRecord.getId() + "  " + userRecord.getFirstName() + "   "+ userRecord.getLastName() + "   "+ userRecord.getEmail() +"   " + userRecord.getUserType());
        }
        System.out.println("_____________________________________________________");
        List<Object> items = itemService.getItems();
        for (Object item: items) {
            Item itemRecord = (Item) item;
            System.out.println(itemRecord.getId() + "  " + itemRecord.getName() + "   "+ itemRecord.getPrice() + "   "+ itemRecord.getQuantity() +"   " + itemRecord.getCategoryType());
        }
        System.out.println("_____________________________________________________");
    }
}
