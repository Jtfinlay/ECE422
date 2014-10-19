import java.util.Timer;

/**
 * Created by James on 10/19/2014.
 */
public class PrimaryVariant extends Thread
{
    int[] values;
    Timer t;
    String fout;

    public PrimaryVariant(String fileInput, String fileOutput, double HAZARD, int timeLimit)
    {
        values = FileManager.readFile(fileInput);
        fout = fileOutput;

        t = new Timer();
        Watchdog w = new Watchdog(this);
        t.schedule(w, timeLimit);

        start();
    }

    @Override
    public void run()
    {
        try
        {
            HeapSort sorter = new HeapSort();
            int[] result = sorter.sort(values);

            FileManager.writeFile(fout, result);
            t.cancel();

        }
        catch (ThreadDeath td)
        {
            t.cancel();
            throw new ThreadDeath();
        }
    }
}
