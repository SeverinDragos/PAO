package cinema.tool;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvWriter {
    String fileName = "ServicesOutputFile.csv";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private static CsvWriter Instance = new CsvWriter();

    private CsvWriter() {
    }

    public static CsvWriter getInstance() {
        return Instance;
    }

    public void write(String output) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);

            byte[] outputBytes = output.getBytes();
            fileOutputStream.write(outputBytes);

            Date date = new Date();
            String timestamp = sdf.format(date.getTime());
            byte[] timestampBytes = timestamp.getBytes();
            fileOutputStream.write(timestampBytes);

            fileOutputStream.write("\n".getBytes());

            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Output file not found!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
