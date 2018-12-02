package com.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class houses few utilities required for the report
 */
public class Reporter {
    private static Map<String, Boolean> systemInfoKeyMap = new HashMap<>();

    private Reporter() {
        // Defeat instantiation
    }

    /**
     * Gets the {@link ExtentHtmlReporter} instance created through listener
     *
     * @return The {@link ExtentHtmlReporter} instance
     */
    public static ExtentHtmlReporter getExtentHtmlReport() {
        return ExtentCucumberFormatter.getExtentHtmlReport();
    }

    /**
     * Gets the {@link ExtentReports} instance created through the listener
     *
     * @return The {@link ExtentReports} instance
     */
    public static ExtentReports getExtentReport() {
        return ExtentCucumberFormatter.getExtentReport();
    }

    /**
     * Loads the XML config file
     *
     * @param xmlPath The xml path in string
     */
    public static void loadXMLConfig(String xmlPath) {
        getExtentHtmlReport().loadXMLConfig(xmlPath);
    }

    /**
     * Loads the XML config file
     *
     * @param file The file path of the XML
     */
    public static void loadXMLConfig(File file) {
        getExtentHtmlReport().loadXMLConfig(file);
    }

    /**
     * Adds an info message to the current step
     *
     * @param message The message to be logged to the current step
     */
    public static void addStepLogInfo(String iMessage) {
        getCurrentStep().info(iMessage);
    }

    /**
     * Adds an info message to the current scenario
     *
     * @param message The message to be logged to the current scenario
     */
    public static void addScenarioLogInfo(String iMessage) {
        getCurrentScenario().info(iMessage);
    }
    
    public static void addStepLogPass(String iMessage) {
    	System.out.println(getCurrentStep()+"step");
    	getCurrentStep().pass(iMessage);
    }
    
    public static void addStepLogError(String eMessage) {
        getCurrentStep().error(eMessage);
    }

    /**
     * Adds an info message to the current scenario
     *
     * @param message The message to be logged to the current scenario
     */
    public static void addScenarioLogError(String eMessage) {
        getCurrentScenario().info(eMessage);
    }
    public static void addStepLogWarning(String wMessage) {
        getCurrentStep().error(wMessage);
    }

    /**
     * Adds an info message to the current scenario
     *
     * @param message The message to be logged to the current scenario
     */
    public static void addScenarioLogWarning(String wMessage) {
        getCurrentScenario().info(wMessage);
    }

    /**
     * Adds the screenshot from the given path to the current step
     *
     * @param imagePath The image path
     * @throws IOException Exception if imagePath is erroneous
     */
    public static void addScreenCaptureFromPath(String imagePath) throws IOException {
        getCurrentStep().addScreenCaptureFromPath(imagePath);
    }

    /**
     * Adds the screenshot from the given path with the given title to the current step
     *
     * @param imagePath The image path
     * @param title     The title for the image
     * @throws IOException Exception if imagePath is erroneous
     */
    public static void addScreenCaptureFromPath(String imagePath, String title) throws IOException {
        getCurrentStep().addScreenCaptureFromPath(imagePath, title);
    }

    /**
     * Adds the screen cast from the given path to the current step
     *
     * @param screenCastPath The screen cast path
     * @throws IOException Exception if imagePath is erroneous
     */
    public static void addScreenCast(String screenCastPath) throws IOException {
        getCurrentStep().addScreencastFromPath(screenCastPath);
    }

    /**
     * Sets the system information with the given key value pair
     *
     * @param key   The name of the key
     * @param value The value of the given key
     */
    public static void setSystemInfo(String key, String value) {
        if (systemInfoKeyMap.isEmpty() || !systemInfoKeyMap.containsKey(key)) {
            systemInfoKeyMap.put(key, false);
        }
        if (systemInfoKeyMap.get(key)) {
            return;
        }
        getExtentReport().setSystemInfo(key, value);
        systemInfoKeyMap.put(key, true);
    }

    /**
     * Sets the test runner output with the given list of strings
     *
     * @param log The list of string messages
     */
    public static void setTestRunnerOutput(List<String> log) {
        getExtentReport().setTestRunnerOutput(log);
    }

    /**
     * Sets the test runner output with the given string
     *
     * @param outputMessage The message to be shown in the test runner output screen
     */
    public static void setTestRunnerOutput(String outputMessage) {
        getExtentReport().setTestRunnerOutput(outputMessage);
    }

    private static ExtentTest getCurrentStep() {
    	System.out.println(ExtentCucumberFormatter.stepTestThreadLocal.get());
        return ExtentCucumberFormatter.stepTestThreadLocal.get();
    }

    private static ExtentTest getCurrentScenario() {
        return ExtentCucumberFormatter.scenarioThreadLocal.get();
    }
}
