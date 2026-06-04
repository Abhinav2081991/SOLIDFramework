package reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    public static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    public static void setExtent(ExtentTest extentTest){
        extentTestThreadLocal.set(extentTest);
    }

    public static ExtentTest getExtent(){
        return extentTestThreadLocal.get();
    }

    public static void unload(){
        extentTestThreadLocal.remove();
    }

    // Now next implementation is Hooks.
}
