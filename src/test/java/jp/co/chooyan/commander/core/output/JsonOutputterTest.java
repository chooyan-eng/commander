/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.core.output;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author chooyan_eng
 */
public class JsonOutputterTest {
    @Test
    public void JsonOutputter_implements_Outputter() {
        Assert.assertTrue(new JsonOutputter() instanceof Outputter);
    }
}
