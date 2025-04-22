package com.example.demo;

// Import classes for reading and handling process output
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CallPythonScript
 * ----------------
 * Java utility class to demonstrate how to call an external Python script
 * from within a Java application using ProcessBuilder.
 * Author        : Hakan Taskin
 * Version       : 1.0
 * Last Updated  : 2025-04-04
 * -----------------
 * Feature	Usage
 * ProcessBuilder	Run external programs/scripts
 * BufferedReader	Read real-time output from Python
 * waitFor()	Waits for the external script to finish
 * try-catch block	Handles I/O or interruption exceptions
 *
 * Technologies:
 * - Java 22
 * - Maven (SLF4J + Logger)
 * - Python (script called externally)
 */

public class CallPythonScript {
    // Logger for info, error, and debug messages
    private static final Logger logger = LoggerFactory.getLogger(CallPythonScript.class);

    public static void main(String[] args) {
        logger.info("📦 Java app running. Calling Python script...");
        runPythonScript(); // Trigger the Python script runner
    }

    /**
     * This method locates and runs a Python script using the system's Python interpreter.
     */
    public static void runPythonScript() {
        try {
            // Get absolute path to the sample Python script
            String projectDir = System.getProperty("user.dir");
            String scriptPath = Paths.get(projectDir, "scripts", "sample_script.py").toString();

            // Prepare process to execute the Python script
            ProcessBuilder processBuilder = new ProcessBuilder("python", scriptPath);
            processBuilder.redirectErrorStream(true); // Merge stderr with stdout
            Process process = processBuilder.start();

            // Read output from the Python process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                logger.info("🧪 Python script output:\n  > {}", line);
            }

            // Wait for the process to complete and log the exit status
            int exitCode = process.waitFor();
            if (logger.isInfoEnabled()) {
                logger.info("✅ Python script exited with code: {}");
            }

        } catch (IOException | InterruptedException e) {
            // ❌ Handle any exceptions thrown during script execution
            System.err.println("❌ Failed to execute Python script: " + e.getMessage());
            e.printStackTrace(); /* for debug */
            // logger.error("Unexpected error:", e); /* for production */
        }
    }
}
