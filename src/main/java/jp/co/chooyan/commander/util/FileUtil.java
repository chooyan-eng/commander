/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.util;

import java.nio.file.Paths;

/**
 *
 * @author chooyan_eng
 */
public class FileUtil {
    public static String toResourcePath(String fileName) {
        return Paths.get("src", "main", "resources", fileName).toString();
    }
}
