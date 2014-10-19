import java.util.Timer;

/**
 * Created by James on 10/19/2014.
 */
public class SecondaryVariant extends Thread
{
    int[] values;
    Timer t;
    String fout;

    public SecondaryVariant(String fileInput, String fileOutput, double HAZARD, int timeLimit)
    {
        fout = fileOutput;
        values = FileManager.readFile(fileInput);

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

            InsertionSort sorter = new InsertionSort();
	        System.loadLibrary("insertionsort");
            int[] result = sorter.insertsort(values);

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
