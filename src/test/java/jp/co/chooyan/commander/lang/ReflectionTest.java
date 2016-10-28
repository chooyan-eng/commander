/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.lang;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.chooyan.commander.core.analyze.Analyzer;
import jp.co.chooyan.commander.plugin.analyze.HistoryCountAnalyzer;
import jp.co.chooyan.commander.plugin.parse.SimpleCommandParser;
import static org.hamcrest.CoreMatchers.*; 
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author chooyan_eng
 */
public class ReflectionTest {
    @Test
    public void argment_of_analyze_of_HistoryCountAnalyzer_is_stringlist() {
        try {
            Analyzer analyzer = new HistoryCountAnalyzer();
            analyzer.getClass().getMethods();
            Method[] methods = HistoryCountAnalyzer.class.getMethods();
            for (Method m : methods) {
                if ("analyze".equals(m.getName()) && !m.isBridge()) {
                    assertThat(m.getGenericParameterTypes().length, is(1));
                    assertThat(m.getGenericParameterTypes()[0].getTypeName(), is("java.util.List<java.lang.String>"));
                }
            }
        } catch (SecurityException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    @Test
    public void SimpleCommandParser_is_available_for_HistoryCountAnalyzer() {
        try {
            Method parseMethod = null;
            for (Method m : SimpleCommandParser.class.getMethods()) { 
                if ("parse".equals(m.getName()) && !m.isBridge()) {
                    parseMethod = m;
                    break;
                }
            }
            assertTrue(parseMethod != null);
            
            Method analyzeMethod = null;
            for (Method m : HistoryCountAnalyzer.class.getMethods()) { 
                if ("analyze".equals(m.getName()) && !m.isBridge()) {
                    analyzeMethod = m;
                    break;
                }
            }
            assertTrue(analyzeMethod != null);

            Class parsedObject = Class.forName(parseMethod.getGenericReturnType().getTypeName().replaceFirst("<.*", ""));
            Class analyzeArgs = Class.forName(analyzeMethod.getGenericParameterTypes()[0].getTypeName().replaceFirst("<.*", ""));

            assertTrue(analyzeArgs.isAssignableFrom(parsedObject));
        } catch (SecurityException | ClassNotFoundException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
}
