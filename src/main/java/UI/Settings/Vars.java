package UI.Settings;

import java.io.File;

public class Vars {

    private static String fs = File.separator;
    private static String resourcesPath = fs+"src"+fs+"main"+fs+"resources"+fs;

    /*--------------------------------   FOLDER PATH   --------------------------------*/

    public static final String PROJECT_SCREENSHOT_PATH = System.getProperty("user.dir")+resourcesPath+"Screenshots"+fs;

    /*--------------------------------   PAUSE OPTIONS   --------------------------------*/

    public static final int SHORTER_SLEEP = 1000;
    public static final int SHORT_SLEEP = 2000;
    public static final int NORMAL_SLEEP = 3000;
}
