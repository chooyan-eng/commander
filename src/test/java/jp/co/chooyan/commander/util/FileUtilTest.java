package jp.co.chooyan.commander.util;

import java.nio.file.Paths;
import static org.hamcrest.CoreMatchers.*; 
import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author chooyan_eng
 */
public class FileUtilTest {
    @Test
    public void can_get_accurate_pathstr() {
        assertThat(FileUtil.toResourcePath("config.yml"), is(
            Paths.get("src", "main", "resources", "config.yml").toString()));
    }
}
