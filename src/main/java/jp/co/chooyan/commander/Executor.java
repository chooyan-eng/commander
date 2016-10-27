/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander;

import java.nio.file.Paths;
import jp.co.chooyan.commander.core.ClassInstanciator;
import jp.co.chooyan.commander.core.analyze.Analyzer;
import jp.co.chooyan.commander.core.config.Config;
import jp.co.chooyan.commander.core.output.Outputter;
import jp.co.chooyan.commander.core.parse.Parser;

/**
 *
 * @author tsuyoshi-chujo
 */
class Executor {
    public static void main(String args[]) {
        Config config = Config.parse(Paths.get("src", "main", "resources", "config.yml").toString());

        Parser parser = (Parser) ClassInstanciator.instanciate(config.getParserName());
        Analyzer analyzer = (Analyzer) ClassInstanciator.instanciate(config.getAnalyzerName());
        Outputter outputter = (Outputter) ClassInstanciator.instanciate(config.getOutputterName());
        
        Object parsedObject = parser.parse(Paths.get("src", "test", "resources", "test_command.txt").toString());
        Object analyzedObject = analyzer.analyze(parsedObject);
        outputter.output(analyzedObject);
        
    }
}
