package com.testing.webautomation.base;

import java.util.Arrays;
import java.util.List;

public class TestData {


    //TEST DATA
public static List<String> invalidNameList = Arrays.asList(
            " ",
            "    ",
            "\t",
            //multiple TABs
            "\t\t",
            //return
            "\r",
            //multiple returns
            "\n\n",
            //new line
            "\n",
            //multiple new lines
            "\n\n"
    );

    public static List<String> taskNameList = Arrays.asList(
            //<editor-fold desc="Invalid passwords validation list">
            //Different languages chars
            "тест",
            "test",
            "اختبار",
            "测试",
            "ทดสอบ",
            //Special chars
            "`~!@#$%^&*()-_=+?<>:;\".,№\\/[]{}",
            "\u1F44"
            //</editor-fold>
    );

    static List<String> criticalConsoleErrorsList = Arrays.asList(
            //<editor-fold desc="criticalConsoleErrorsList">
            "undefined",
            "404",
            "EXCEPTION",
            "not defined",
            "unknown",
            "server error",
            "uncaught",
            "'null' is not",
            "doesn’t support property",
            "Cannot read property 'length'"
            //</editor-fold>
    );
}
