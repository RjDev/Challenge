import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {

/**
* @param args
 * @throws JSONException 
*/
public static void main(String[] args) throws JSONException {
String jsonString = "{\"a\":{\"b\":{\"c\":\"d\"}}}";
String keyToFind = "c";
System.out.println(getValueFromJsonStringByKey(jsonString, keyToFind));

}

private static Object getValueFromJsonStringByKey(String jsonString, String keyToFind) throws JSONException {
JSONObject jsonObject = new JSONObject(jsonString);
Iterator<String> keys = jsonObject.keys();
boolean keyFound = false;
Object result = "No Key Found!!";
try {
while (!keyFound && keys.hasNext()) {
String key = keys.next();
if (keyToFind.equalsIgnoreCase(key)) {
keyFound = true;
result = jsonObject.get(key);
} else if (jsonObject.getJSONObject(key) instanceof JSONObject) {
jsonObject = jsonObject.getJSONObject(key);
keys = jsonObject.keys();
}
}
}catch(Exception ex) {
System.out.println(ex.getMessage());
}
return result;
}

}
