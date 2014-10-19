import java.util.Timer;

/**
 * Created by James on 10/19/2014.
 */
public class PrimaryVariant extends Thread
{
    int[] values;
    Timer t;
    String fout;
    double failure;

    public PrimaryVariant(String fileInput, String fileOutput, double failure, int timeLimit)
    {
        values = FileManager.readFile(fileInput);
        fout = fileOutput;
        this.failure = failure;

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

            // Error check
            double error = Math.random();
            if (error > 0.5 && error < .5 + sorter.mem * failure) {
                t.cancel();
                return;
            }

            FileManager.writeFile(fout, result);
            t.cancel();

        }
        catch (ThreadDeath td)
        {
            t.cancel();
            throw new ThreadDeath();
        }
    }

    public void cancel()
    {
        t.cancel();
    }
}
