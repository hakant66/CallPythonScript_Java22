
# 🐍 CallPythonScript Java 22 App

**Author**: Hakan Taskin  
**Version**: 1.0  
**Description**: A simple Java 22 project that uses Maven to run a class which calls a Python script via `ProcessBuilder`.

## 📁 Project Structure

```
CallPythonScript_Java22_Portable/
├── pom.xml
├── run.bat
├── run.sh
├── scripts/
│   └── sample_script.py
└── src/
    └── main/
        └── java/
            └── com/example/demo/
                └── CallPythonScript.java
```

## ⚙️ Requirements

- ✅ Java JDK 22
- ✅ Maven (`mvn -v`)
- ✅ Python (`python --version`)

## 🚀 How to Run

### 🪟 On Windows
```
run.bat
```

### 🐧 On Linux / macOS
```
chmod +x run.sh
./run.sh
```

## ✅ Expected Output

```
📦 Java app running. Calling Python script...
🧪 Python script output:
  > Hello from Python script!
✅ Python script exited with code: 0
```
