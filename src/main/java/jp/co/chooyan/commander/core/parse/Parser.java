/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander.core.parse;

/**
 *
 * @author chooyan_eng
 * @param <T>
 */
public interface Parser <T> {
    public T parse(String fileName);    
}
