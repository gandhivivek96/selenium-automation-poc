package io.github.gandhivivek96.listeners;

import io.github.gandhivivek96.constants.Env;
import io.github.gandhivivek96.utils.JSONUtility;
import io.github.gandhivivek96.utils.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

//    private static final int MAX_NUMBER_OF_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(Env.QA,"MAX_NUMBER_OF_ATTEMPTS"));

    private static final int MAX_NUMBER_OF_ATTEMPTS= JSONUtility.readJson(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();

    private static int  currentAttempt=1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentAttempt<=MAX_NUMBER_OF_ATTEMPTS)
        {
            currentAttempt++;
            return true;
        }
        return false;
    }
}
