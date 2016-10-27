/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.plugin.analyze;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jp.co.chooyan.commander.core.analyze.Analyzer;

/**
 *
 * @author chooyan_eng
 */
public class HistoryCountAnalyzer implements Analyzer {

    @Override
    public Object analyze(Object parsedObject) {
        Map<String, Integer> result = new HashMap<>();
        List<String> commandList = (List<String>) parsedObject;
        commandList.stream()
                   .map(line -> pickCommand(line))
                   .sorted()
                   .forEach(command -> { 
                       int count = result.containsKey(command) ? result.get(command) : 0;
                       count++;
                       result.put(command, count);
                    });
        return result;
    }
    
    private String pickCommand(String commandWithOption) {
        String command = "";
        
        Pattern p = Pattern.compile("^[a-zA-Z0-9]+");
        Matcher m = p.matcher(commandWithOption);
        if (m.find()) {
            command = m.group();
        }
        return command;
    }
}