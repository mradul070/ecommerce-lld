package ordeManagement.src.service;

import java.util.List;

import ordeManagement.src.Model.Item;

public interface ItemService {
    public void createItem(Item category);
    public Item getItemById(int id);
    public List<Object> getItems();
}