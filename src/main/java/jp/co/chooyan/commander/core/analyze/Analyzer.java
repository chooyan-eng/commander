package jp.co.chooyan.commander.core.analyze;

/**
 *
 * @author chooyan_eng
 * @param <T, S>
 */
public interface Analyzer<T, S> {
    public S analyze(T parsedObject);
}
