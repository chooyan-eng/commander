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
public class HistoryCountAnalyzer implements Analyzer<List<String>, Map<String, Integer>> {

    @Override
    public Map<String, Integer> analyze(List<String> parsedObject) {
        Map<String, Integer> result = new HashMap<>();
        parsedObject.stream()
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
        
        Pattern p = Pattern.compile("^[a-zA-Z0-9\\./]+");
        Matcher m = p.matcher(commandWithOption);
        if (m.find()) {
            command = m.group();
        }
        return command;
    }
}
