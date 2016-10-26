/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.core.config;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chooyan_eng
 */
public class Config {
    
    private String mAnalyzerName;
    private String mParserName;
    private String mOutputterName;
    
    private Config(){}
    
    public static Config parse(String fileName) {
        Config config = new Config();
        try {
            YamlReader yamlReader = new YamlReader(new FileReader(fileName));
            Map yamlMap = (Map) yamlReader.read();
            config.mAnalyzerName = (String) yamlMap.get("analyzer");
            config.mParserName = (String) yamlMap.get("parser");
            config.mOutputterName = (String) yamlMap.get("outputter");

            return config;

        } catch (YamlException | FileNotFoundException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
            return config;
        }
    }
    
    public String getAnalyzerName() {
        return mAnalyzerName;
    }
    
    public String getParserName() {
        return mParserName;
    }

    public String getOutputterName() {
        return mOutputterName;
    }
}
