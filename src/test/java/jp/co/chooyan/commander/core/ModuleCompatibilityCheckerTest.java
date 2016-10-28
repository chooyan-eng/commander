package jp.co.chooyan.commander.core;

import jp.co.chooyan.commander.core.analyze.Analyzer;
import jp.co.chooyan.commander.core.output.Outputter;
import jp.co.chooyan.commander.core.parse.Parser;
import jp.co.chooyan.commander.plugin.analyze.HistoryCountAnalyzer;
import jp.co.chooyan.commander.plugin.output.JsonOutputter;
import jp.co.chooyan.commander.plugin.parse.SimpleCommandParser;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*; 
import static org.junit.Assert.*;

/**
 *
 * @author chooyan_eng
 */
public class ModuleCompatibilityCheckerTest {
    @Test
    public void appropreate_classes_compatible() {
        Parser parser = new SimpleCommandParser();
        Analyzer analyzer = new HistoryCountAnalyzer();
        Outputter outputter = new JsonOutputter();
        
        ModuleCompatibilityChecker checker = new ModuleCompatibilityChecker(parser, analyzer, outputter);
        
        assertTrue(checker.isAnalyzerCompatible());
        assertTrue(checker.isOutputterCompatible());
    }
}
