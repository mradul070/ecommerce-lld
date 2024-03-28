package ordeManagement.src.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static Database db;
    Map<String ,List<Object>> hs;
    private Database() {
        hs = new HashMap<>();
    }
    public static Database getInstance() {
        if (db == null) {
            db = new Database();
        }
        return db;
    }
    public void createCollection(String collectionName) {
        hs.put(collectionName, new ArrayList<>());
    }

    public void insert(String collectionName, Object item) {
        if (hs.containsKey(collectionName)) {
            List<Object> collection = hs.get(collectionName);
            collection.add(item);
        } else {
            System.out.println("Collection '" + collectionName + "' does not exist.");
        }
    }

    public List<Object> getCollection(String collectionName) {
        return  hs.get(collectionName);
    }

}
