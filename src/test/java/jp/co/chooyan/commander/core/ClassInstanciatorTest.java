/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.core;

import jp.co.chooyan.commander.plugin.analyze.SimpleHistoryAnalyzer;
import jp.co.chooyan.commander.plugin.output.JsonOutputter;
import jp.co.chooyan.commander.plugin.parse.SimpleCommandParser;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*; 
import static org.junit.Assert.*;

/**
 *
 * @author chooyan_eng
 */
public class ClassInstanciatorTest {
    @Test
    public void test_can_instanciate_implementClasses() {
        assertTrue(ClassInstanciator.instanciate("jp.co.chooyan.commander.plugin.analyze.SimpleHistoryAnalyzer") instanceof SimpleHistoryAnalyzer);
        assertTrue(ClassInstanciator.instanciate("jp.co.chooyan.commander.plugin.parse.SimpleCommandParser") instanceof SimpleCommandParser);
        assertTrue(ClassInstanciator.instanciate("jp.co.chooyan.commander.plugin.output.JsonOutputter") instanceof JsonOutputter);
    }
    
        @Test
    public void test_CANNNOT_instanciate_dummyClasses() {
        assertThat(ClassInstanciator.instanciate("jp.co.chooyan.commander.xxxx.JsonOutputter"), is(nullValue()));
        assertThat(ClassInstanciator.instanciate("jp.co.chooyan.commander.pluging.parse.XXXXXXX"), is(nullValue()));
    }
}
