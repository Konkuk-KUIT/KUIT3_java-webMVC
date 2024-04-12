package core.mvc;

import java.util.HashMap;
import java.util.Map;

public class Model {
    private Map<String, Object> map = new HashMap<>();
    public void put (String key, Object val) {
        map.put(key, val);
    }

    public Map<String, Object> getMap() {
        return map;
    }
}
