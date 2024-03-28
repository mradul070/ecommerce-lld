package ordeManagement.src.service.AddItemToCartResponsiblity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ordeManagement.src.Model.Cart;
import ordeManagement.src.Model.Database;
import ordeManagement.src.Model.User;

public class AddItemToExisting extends AddItem {
    public AddItemToExisting(AddItem addItemNext) {
        super(addItemNext);
    }
    @Override
    public void addItem(Cart cartObject, User user) {
        List<Object> carts = Database.getInstance().getCollection("carts");
        if (carts.size() != 0) {
            for (Object o: carts) {
                HashMap<User, ArrayList<Cart>> cartMap = (HashMap<User, ArrayList<Cart>>) o;
                for (Map.Entry<User, ArrayList<Cart>> cart: cartMap.entrySet()) {
                    if (cart.getKey().equals(user)) {
                        List<Cart> addedItems = (List<Cart>) cart.getValue();
                        addedItems.add((Cart) cartObject);
                        break;
                    } else {
                        super.addItem(cartObject, user);
                    }
                }
            }
        }
        super.addItem(cartObject, user);
      
    }
}
