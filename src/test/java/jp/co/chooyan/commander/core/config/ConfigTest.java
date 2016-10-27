/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.core.config;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.*; 
import static org.junit.Assert.*;

/**
 *
 * @author chooyan_eng
 */
public class ConfigTest {
    
    Config mConfig;
    
    @Before
    public void init() throws IOException, URISyntaxException {
        mConfig = Config.parse(Paths.get("src", "test", "resources", "test_config.yml").toString());
    }
    
    @Test
    public void canGetAnalyzerName() {
        assertThat(mConfig.getAnalyzerName(), not(nullValue()));
        assertThat(mConfig.getAnalyzerName(), is("SimpleHistoryAnalyzer"));
        assertThat(mConfig.getParserName(), is("SimpleCommandParser"));
        assertThat(mConfig.getOutputterName(), is("JsonOutputter"));
    }    
}
