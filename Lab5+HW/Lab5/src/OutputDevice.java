import java.io.IOException;
import java.io.OutputStream;

public class OutputDevice {
    private OutputStream outputStream;

    public OutputDevice(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    void writeMessage(String mess) {
        try
        {
            outputStream.write(mess.getBytes());
//        outputStream.flush();
            outputStream.write('\n');
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}