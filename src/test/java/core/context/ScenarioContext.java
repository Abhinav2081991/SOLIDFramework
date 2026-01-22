package core.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private final Map<String, Object> context= new HashMap<>();

    public void setContext(String key, Object value){
        context.put(key, value);
    }

    public <T> T getContext(String key) {
        return (T) context.get(key);
    }
    public boolean containsKey(String key){
        return context.containsKey(key);
    }
}
