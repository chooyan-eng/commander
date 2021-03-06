package jp.co.chooyan.commander.core;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chooyan_eng
 */
public class ClassInstanciator {
    public static Object instanciate(String className) {
        try {
            Class clazz = Class.forName(className);
            return clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ClassInstanciator.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
