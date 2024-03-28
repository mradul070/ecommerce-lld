package ordeManagement.src.service.AddItemToCartResponsiblity;

import ordeManagement.src.Model.Cart;
import ordeManagement.src.Model.User;

public class AddItem {
    private AddItem nextAddItem;

    public AddItem(AddItem nextAddItem) {
        this.nextAddItem = nextAddItem;
    }
    public void addItem(Cart cartObject, User user) {
        if (nextAddItem != null)
            nextAddItem.addItem(cartObject, user);
    }
}
