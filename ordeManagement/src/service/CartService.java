package ordeManagement.src.service;

import java.util.List;

import ordeManagement.src.Model.Cart;
import ordeManagement.src.Model.Item;
import ordeManagement.src.Model.User;

public interface CartService {
    public void addItem(Item item, User user, int quantity) throws Exception;
    public List<Cart> getUserCart(User user);
    public void displayCart(List<Cart> carts);
    public void removeItem(int itemId, User user);
}
