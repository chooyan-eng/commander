package jp.co.chooyan.commander.plugin.output;

import com.google.gson.Gson;
import jp.co.chooyan.commander.core.output.Outputter;

/**
 *
 * @author chooyan_eng
 */
public class JsonOutputter implements Outputter<Object> {

    @Override
    public void output(Object analyzedObject) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(analyzedObject));
    }
}
