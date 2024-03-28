package ordeManagement.src.service.Impl;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.text.DecimalFormat;
import ordeManagement.src.Model.Cart;
import ordeManagement.src.Model.Database;
import ordeManagement.src.Model.Item;
import ordeManagement.src.Model.User;
import ordeManagement.src.service.CartService;
import ordeManagement.src.service.AddItemToCartResponsiblity.AddItem;
import ordeManagement.src.service.AddItemToCartResponsiblity.AddItemToExisting;
import ordeManagement.src.service.AddItemToCartResponsiblity.CreateNewOneAndAdd;

public class CartServiceImpl implements CartService {
    private final Database db;
    static {
        Database.getInstance().createCollection("carts");
    }
    
    public CartServiceImpl(){
        db = Database.getInstance();
    }

    @Override
    public void addItem(Item item, User user, int quantity) throws Exception {
        if (item.getQuantity() < quantity) throw new Exception("Inventory is out of stock");
        Cart cartData = new Cart();
        cartData.setItemId(item.getId());
        cartData.setQuantity(quantity);
        AddItem addItem = new AddItemToExisting(new CreateNewOneAndAdd(null));
        addItem.addItem(cartData, user);
        System.out.println("Item added successfull");
    }

    @Override
    public List<Cart> getUserCart(User user) {
        List<Object> cart = db.getCollection("carts");
            for(Object o: cart) {
                HashMap<User, Cart> ls = (HashMap<User, Cart>) o;
                for (Map.Entry<User, Cart> carts: ls.entrySet()) {
                    return (List<Cart>) carts.getValue();
                }
            }
        return null;
    }

    @Override
    public void displayCart(List<Cart> carts) {
        double totalPrice = 0.0;
        DecimalFormat df = new DecimalFormat("#.##"); 
        for (Cart cart: carts) {
            int itemId = cart.getItemId();
            Item item = new ItemServiceImpl().getItemById(itemId);
            totalPrice += item.getPrice() * cart.getQuantity();
            System.out.println( itemId + "  " + item.getName() +"   " + item.getPrice() + "   " +item.getCategoryType() + "    "  +cart.getQuantity());
        }
        System.out.println("Total Cart value: " + df.format(totalPrice));
    }

    @Override
    public void removeItem(int itemId, User user) {
        List<Object> carts = db.getCollection("carts");
        ArrayList<Cart> userCarts = new ArrayList<>();
        for(Object o: carts) {
            HashMap<User, ArrayList<Cart>> ls = (HashMap<User, ArrayList<Cart>>) o;
            for (Map.Entry<User,  ArrayList<Cart>> cart: ls.entrySet()) {
                if (cart.getKey().equals(user)) {
                    userCarts.addAll(cart.getValue());
                    break;
                }
            }
        }
        System.out.println(userCarts.size());
        for (int i = 0; i < userCarts.size(); i++) {
            Cart cart = userCarts.get(i);
            System.out.println(cart.getItemId() + "     " + cart.getQuantity());
            if (cart.getItemId() == itemId) {
                System.out.println(userCarts.get(i).getQuantity());
                userCarts.remove(i);
                break;
            }
        }
        System.out.println(userCarts.size());
    }
}
