/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.helper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * helper class for accessing files in src/test/resources/ directory
 * @author chooyan_eng
 */
public class FileHelper {
    public static byte[] readAllBytes(String resourceName) {
        try {
            URI uri = FileHelper.class.getClassLoader().getResource(resourceName).toURI();
            return Files.readAllBytes(Paths.get(uri));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE, null, ex);
            return new byte[]{};
        }
    }
}
