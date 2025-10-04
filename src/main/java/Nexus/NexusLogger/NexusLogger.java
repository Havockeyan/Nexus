package Nexus.NexusLogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NexusLogger {
    private static NexusLogger nexusLogger = null;
    private String fileLocation;
    private File logFileObject;

    private NexusLogger() {
        this(System.getProperty("user.dir") + "/nexus.txt");
    }

    private NexusLogger(String fileLocation) {
        this.fileLocation = fileLocation;
        File logFile = new File(this.fileLocation);
        try {
            logFile.createNewFile();
            this.logFileObject = logFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static NexusLogger getNexusLogger()  {
        if (nexusLogger == null) {
            nexusLogger = new NexusLogger();
        }
        return nexusLogger;
    }

    public void log(String message) {
        try {
            FileWriter fileWriter = new FileWriter(this.logFileObject, true);
            fileWriter.append(message).append(System.lineSeparator());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
