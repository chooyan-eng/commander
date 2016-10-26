/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.plugin.parse;

import jp.co.chooyan.commander.core.parse.Parser;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author o_fcf_hpbt_vvcc_p
 */
public class SimpleCommandParserTest {
    @Test
    public void SimpleCommandParserTest_implements_Parser() {
        Assert.assertTrue(new SimpleCommandParser() instanceof Parser);
    }
}
