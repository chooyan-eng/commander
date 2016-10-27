/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.plugin.output;

import com.google.gson.Gson;
import jp.co.chooyan.commander.core.output.Outputter;

/**
 *
 * @author chooyan_eng
 */
public class JsonOutputter implements Outputter {

    @Override
    public void output(Object o) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(o));
    }
}
