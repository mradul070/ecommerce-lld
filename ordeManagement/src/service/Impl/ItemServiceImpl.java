package ordeManagement.src.service.Impl;

import ordeManagement.src.Model.Item;
import ordeManagement.src.service.ItemService;
import ordeManagement.src.Model.Database;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    private final Database db;
    static {
        Database.getInstance().createCollection("items");
    }

    public ItemServiceImpl() {
        db = Database.getInstance();
    }

    @Override
    public void createItem(Item category) {
        db.insert("items", (Item) category);
    }

    @Override
    public Item getItemById(int id) {
        List<Object> items =  db.getCollection("items");
        for (Object item: items) {
            Item itemObject = (Item) item;
            if (itemObject.getId() == id) {
                return itemObject;
            }
        }
        return null;
    }
    
    @Override
    public List<Object> getItems() {
        return db.getCollection("items");
    }
}
