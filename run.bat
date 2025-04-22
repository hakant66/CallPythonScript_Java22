@echo off
setlocal
set SCRIPT_DIR=%~dp0
echo Running Java program...
java -cp "%SCRIPT_DIR%/target/classes;%SCRIPT_DIR%/target/dependency/*" com.example.demo.CallPythonScript
pause
