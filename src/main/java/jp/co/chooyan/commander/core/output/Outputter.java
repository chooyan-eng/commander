package jp.co.chooyan.commander.core.output;

/**
 *
 * @author chooyan_eng
 * @param <S>
 */
public interface Outputter<S> {
    public void output(S analyzedObject);
}
