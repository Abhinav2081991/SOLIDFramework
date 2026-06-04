package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extentReports;

    private ExtentManager(){

    }

    public static ExtentReports getExtent(){
        if(extentReports==null){
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-report/ExtentReport.html");
            sparkReporter.config().setReportName("SOLODFramework" + System.currentTimeMillis());
            sparkReporter.config().setDocumentTitle("Execution Preport" + System.currentTimeMillis());
            sparkReporter.config().setTimelineEnabled(true);

            extentReports.setSystemInfo("OS", System.getProperty("os.name"));
            extentReports.setSystemInfo("Java", System.getProperty("java.version"));
        }

        return extentReports;
    }

}
