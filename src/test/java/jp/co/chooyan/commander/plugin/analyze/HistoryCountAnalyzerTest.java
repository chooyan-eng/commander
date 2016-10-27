/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.plugin.analyze;

import jp.co.chooyan.commander.core.analyze.Analyzer;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author chooyan_eng
 */
public class HistoryCountAnalyzerTest {
    @Test
    public void HistoryCountAnalyzer_implements_Analyzer() {
        Assert.assertTrue(new HistoryCountAnalyzer() instanceof Analyzer);
    }
}
