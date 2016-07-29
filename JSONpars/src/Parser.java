/**
 * Created by root on 29.07.16.
 */

import com.google.gson.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class MyClass<K, V> extends HashMap<K, V>
{
    //http://stackoverflow.com/questions/1066589/iterate-through-a-hashmap

    public void printMap() {
        Iterator it = this.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove();
        }
    }
}

public class Parser {

    public static String loadJSONfile(String filename)
    {
        int chr;
        StringBuffer jsonStr = new StringBuffer("");
        try
        {
            FileInputStream file = new FileInputStream(filename);
            while ((chr = file.read()) != -1)
            {
                jsonStr.append((char)chr);
            }
        }
        catch (IOException e) {}
        return jsonStr.toString();
    }

    public static Map<String, String> desToMap(String jsonstr)
    {
        Map<String, String> map = new MyClass<String, String>();
        Gson gson = new Gson();

        map = (Map<String,String>)gson.fromJson(jsonstr, map.getClass());

        //System.out.println("Maped...");

        return map;
    }

    public static void main(String args[])
    {
        String strJSON = new String(loadJSONfile("example.json"));

        System.out.println("JSON file:");
        System.out.println(strJSON);

        MyClass<String, String> result = new MyClass<String, String>();

        System.out.println("MyClass:");
        result = (MyClass)desToMap(strJSON);

        result.printMap();
    }
}
