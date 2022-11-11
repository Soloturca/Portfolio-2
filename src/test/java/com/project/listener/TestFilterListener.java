package com.project.listener;

import com.project.listener.MyLocalVariables;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.TestNG;
import org.testng.xml.Parser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class TestFilterListener implements IMethodInterceptor {

    private static Set<Pattern> patterns;
    private static final boolean randomDeviceFlag =false;


    private boolean includeTest(String testsToInclude, String currentTestName) {
        boolean result = false;

        if (patterns == null) {
            patterns = new HashSet<>();
            String[] testPatterns = testsToInclude.split(",");
            for (String testPattern : testPatterns) {
                patterns.add(Pattern.compile(testPattern, Pattern.CASE_INSENSITIVE));
            }
        }

        for (Pattern pattern : patterns) {
            if (pattern.matcher(currentTestName).find()) {
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        String testNames = System.getProperty("testname");
        System.out.println(testNames);
        IMethodInstance e;
        String[] testNamesArray = testNames.split(",");
        System.out.println(testNamesArray.length);
        for (String testname:testNamesArray) {
            MyLocalVariables.addTestTagToList(testname);
        }

        MyLocalVariables.setActiveTestNumber(0);

        if (testNames == null || testNames.trim().isEmpty()) {

        } else {
            if (includeTest(testNames, context.getName())) {

            } else if (testNames.length() > 0) {


                TestNG tng = new TestNG();
                String runnerName = null;

                String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">" +
                        "<suite name=\"DefSuite\">"+
                        "<parameter name=\"browserName\" value=\"chrome\"/>";
                for (String testname : testNamesArray) {

                    xml+="<test name=\"Test\" enabled=\"true\">" +
                            "<classes>" +
                            "<class name=\"runners.TestRunnerXRay\"/>" +
                            "<parameter name=\"tagName\" value=\"" + testname + "\"/>" +
                            "</classes>" +
                            "</test>";
                }

                xml +="</suite>";
                System.out.println(xml);
                ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
                try {
                    tng.setXmlSuites(new Parser(is).parseToList());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    tng.run();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            } else {

            }
        }
        System.out.println("method size :"+methods.size());
        return new ArrayList<IMethodInstance>();
    }

}