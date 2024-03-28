package ordeManagement.src.service.AddItemToCartResponsiblity;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.crypto.Data;

import ordeManagement.src.Model.Cart;
import ordeManagement.src.Model.Database;
import ordeManagement.src.Model.User;

public class CreateNewOneAndAdd extends AddItem {
    public CreateNewOneAndAdd(AddItem addItemNext) {
        super(addItemNext);
    }
    @Override
    public void addItem(Cart cartObject, User user) {
        HashMap<User, ArrayList<Cart>> cartMap = new HashMap<>();
        ArrayList<Cart> al = new ArrayList<>();
        al.add((Cart) cartObject);
        cartMap.put(user, al);
        Database.getInstance().insert("carts", cartMap);
    }
}
