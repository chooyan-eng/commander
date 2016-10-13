/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.core.config;

import java.io.InputStream;

/**
 *
 * @author chooyan_eng
 */
public class Config {
    
    private String mAnalyzerName;
    
    private Config(){}
    
    public static Config parse(InputStream in) {
        // TODO: implement
        Config config = new Config();
        config.mAnalyzerName = "SimpleHistoryAnalyzer";
        
        return config;
    }
    
    public String getAnalyzerName() {
        return mAnalyzerName;
    }
}
