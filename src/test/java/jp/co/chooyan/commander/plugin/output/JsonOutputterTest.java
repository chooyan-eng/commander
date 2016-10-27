/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.plugin.output;

import jp.co.chooyan.commander.core.output.Outputter;
import jp.co.chooyan.commander.plugin.analyze.HistoryCountAnalyzerTest;

import static org.hamcrest.CoreMatchers.*; 
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author chooyan_eng
 */
public class JsonOutputterTest {
    @Test
    public void JsonOutputter_implements_Outputter() {
        assertTrue(new JsonOutputter() instanceof Outputter);
    }
    
    @Test
    public void can_output_properly() {
        new JsonOutputter().output(new HistoryCountAnalyzerTest().getAnalyzedData());
    }
}
