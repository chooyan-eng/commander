package jp.co.chooyan.commander.core;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.chooyan.commander.core.analyze.Analyzer;
import jp.co.chooyan.commander.core.output.Outputter;
import jp.co.chooyan.commander.core.parse.Parser;

/**
 *
 * @author chooyan_eng
 */
public class ModuleCompatibilityChecker {

    private Parser parser;
    private Analyzer analyzer;
    private Outputter outputter;

    public ModuleCompatibilityChecker(Parser parser, Analyzer analyzer, Outputter outputter) {
        this.parser = parser;
        this.analyzer = analyzer;
        this.outputter = outputter;
    }

    public boolean isAnalyzerCompatible() {
        Class parserReturnClass = getReturnClass(parser, "parse");
        Class analyzerArgumentClass = getArgumentClass(analyzer, "analyze");
        return analyzerArgumentClass.isAssignableFrom(parserReturnClass);
    }

    public boolean isOutputterCompatible() {
        Class analyzerReturnClass = getReturnClass(analyzer, "analyze");
        Class outputterArgumentClass = getArgumentClass(outputter, "output");
        return outputterArgumentClass.isAssignableFrom(analyzerReturnClass);
    }
    
    private Class getArgumentClass(Object moduleObject, String methodName) {
        try {
            Method method = getTargetMethod(moduleObject, methodName);
            if (method == null) {
                return null;
            }

            return Class.forName(method.getGenericParameterTypes()[0].getTypeName().replaceFirst("<.*", ""));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModuleCompatibilityChecker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private Class getReturnClass(Object moduleObject, String methodName) {
        try {
            Method method = getTargetMethod(moduleObject, methodName);
            if (method == null) {
                return null;
            }

            return Class.forName(method.getGenericReturnType().getTypeName().replaceFirst("<.*", ""));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModuleCompatibilityChecker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private Method getTargetMethod(Object moduleObject, String methodName) {
        Method targetMethod = null;
        for (Method m : moduleObject.getClass().getMethods()) {
            if (methodName.equals(m.getName()) && !m.isBridge()) {
                targetMethod = m;
                break;
            }
        }

        return targetMethod;
    }
}
