package jp.co.chooyan.commander.plugin.parse;

import java.nio.file.Paths;
import java.util.List;
import jp.co.chooyan.commander.core.parse.Parser;

import static org.hamcrest.CoreMatchers.*; 
import static org.junit.Assert.*;
import org.junit.Test;


/**
 *
 * @author chooyan_eng
 */
public class SimpleCommandParserTest {
    @Test
    public void SimpleCommandParserTest_implements_Parser() {
        assertTrue(new SimpleCommandParser() instanceof Parser);
    }
    
    @Test
    public void can_get_500_command_list() {
        Object o = parseTestFile();
        assertTrue(o instanceof List);
        
        List<String> commandList = (List<String>) o;
        assertThat(commandList.size(), is(500));
    }
    
    @Test
    public void can_get_499_command_list_from_brokenfile() {
        List<String> commandList = (List<String>) parseBrokenFile();
        assertThat(commandList.size(), is(499));
    }

    @Test
    public void history_num_is_removed() {
        List<String> commandList = (List<String>) parseTestFile();
        commandList.forEach(command -> {
            assertFalse(command.trim().matches("[0-9]+ .*"));
        });
    }

    private Object parseTestFile() {
        SimpleCommandParser parser = new SimpleCommandParser();
        return parser.parse(Paths.get("src", "test", "resources", "test_command.txt").toString());
    }
    
        private Object parseBrokenFile() {
        SimpleCommandParser parser = new SimpleCommandParser();
        return parser.parse(Paths.get("src", "test", "resources", "test_command_broken.txt").toString());
    }

}
