/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander;

import org.junit.Test;

/**
 *
 * @author chooyan_eng
 */
public class ExecutorTest {
    @Test
    public void testMain() {
        Executor.main(new String[]{"/usr/local/workdir/java/commander/src/test/resources/test_config.yml"});
    }
}
