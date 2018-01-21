package utils.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {

    private static ExtentReports extent;
    public static String reportPath;
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            DateFormat dateFormat = new SimpleDateFormat("DD-MMM-YYYY");
            DateFormat timeFormat = new SimpleDateFormat("hh-mm-ss");
            Date date = new Date();
            String workingDir = System.getProperty("user.dir");
            reportPath = workingDir + "\\ExecutionReport\\" + dateFormat.format(date) + "\\" + timeFormat.format(date) + "\\" + Instant.now().toEpochMilli() + ".html";
            //Set HTML reporting file location
            extent = new ExtentReports(reportPath, true);
        }
        return extent;
    }
}
