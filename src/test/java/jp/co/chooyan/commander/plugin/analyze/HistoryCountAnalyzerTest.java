/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.plugin.analyze;

import java.nio.file.Paths;
import java.util.Map;
import jp.co.chooyan.commander.core.analyze.Analyzer;
import jp.co.chooyan.commander.core.parse.Parser;
import jp.co.chooyan.commander.plugin.parse.SimpleCommandParser;
import static org.hamcrest.CoreMatchers.*; 
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author chooyan_eng
 */
public class HistoryCountAnalyzerTest {

    private Object commandList;

    @Before
    public void init() {
        SimpleCommandParser parser = new SimpleCommandParser();
        commandList = parser.parse(Paths.get("src", "test", "resources", "test_command.txt").toString());        
    }
    
    @Test
    public void HistoryCountAnalyzer_implements_Analyzer() {
        assertTrue(new HistoryCountAnalyzer() instanceof Analyzer);
    }
    
    @Test
    public void count_command_properly() {
        Analyzer analyzer = new HistoryCountAnalyzer();
        Object o = analyzer.analyze(commandList);
        
        assertTrue(o instanceof Map);
        
        Map<String, Integer> commandCountMap = (Map<String, Integer>) o;
        
        assertThat(commandCountMap.get("open"), is(2));
        assertThat(commandCountMap.get("ll"), is(118));
        assertThat(commandCountMap.get("cd"), is(54));
    }
    
    public Object getAnalyzedData() {
        Parser parser = new SimpleCommandParser();
        commandList = parser.parse(Paths.get("src", "test", "resources", "test_command.txt").toString());        
        Analyzer analyzer = new HistoryCountAnalyzer();
        return analyzer.analyze(commandList);
    }
}
