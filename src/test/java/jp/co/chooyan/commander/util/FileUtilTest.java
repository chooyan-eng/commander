/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.util;

import java.nio.file.Paths;
import static org.hamcrest.CoreMatchers.*; 
import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author tsuyoshi-chujo
 */
public class FileUtilTest {
    @Test
    public void can_get_accurate_pathstr() {
        assertThat(FileUtil.toResourcePath("config.yml"), is(
            Paths.get("src", "main", "resources", "config.yml").toString()));
    }
}
