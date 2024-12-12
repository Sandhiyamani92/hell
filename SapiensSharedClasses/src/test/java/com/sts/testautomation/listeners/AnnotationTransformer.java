package com.sts.testautomation.listeners;

import com.sts.testautomation.utilities.RunStatusUtil;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
 
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
 
public class AnnotationTransformer implements IAnnotationTransformer {

    int count = 0;

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        try {
            if (count == 0) {
                RunStatusUtil.getRunStatus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < RunStatusUtil.testCases.size(); i++) {
            if (testMethod.getName()
                    .equalsIgnoreCase(RunStatusUtil.testCases.get(i))) {

                annotation.setRetryAnalyzer(Retry.class); // sets the retry analyser for all the test cases

                if (RunStatusUtil.runStatus.get(i).equalsIgnoreCase("No")) {
                    annotation.setEnabled(false); // sets the enabled parameter for all the test cases based on the
                    // excel sheet input

                    break;
                }
            }
        }

        count++;

    }
}