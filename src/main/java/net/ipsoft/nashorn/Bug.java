package net.ipsoft.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Bug {
    public static void main(String[] args) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");

        Number result = (Number) engine.eval("var imports = new JavaImporter(java.lang.Long);\n" +
            "\n" +
            "with (imports) {\n" +
            "    function test1() {\n" +
            "        var result = new Long(1);\n" +
            "\n" +
            "        var test2 = function() {\n" +
            "            return result;\n" +
            "        };\n" +
            "\n" +
            "        return test2();\n" +
            "    }\n" +
            "    \n" +
            "    test1();\n" +
            "}\n" +
            "\n");

        System.out.println(result);
    }
}
