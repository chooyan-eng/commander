/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.plugin.parse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import jp.co.chooyan.commander.core.config.Config;
import jp.co.chooyan.commander.core.parse.Parser;

/**
 *
 * @author chooyan_eng
 */
public class SimpleCommandParser implements Parser {
    
    @Override
    public Object parse(String fileName) {
        List<String> commandList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) { 
            stream.map(line -> line.replaceFirst("^ +[0-9]+ +", "")) // remove history number
                  .filter(line -> !line.isEmpty())
                  .forEach(line -> commandList.add(line));
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
        return commandList;
    }
}
