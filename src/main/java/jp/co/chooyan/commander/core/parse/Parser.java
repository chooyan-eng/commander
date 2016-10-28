package jp.co.chooyan.commander.core.parse;

/**
 *
 * @author chooyan_eng
 * @param <T>
 */
public interface Parser <T> {
    public T parse(String fileName);    
}
