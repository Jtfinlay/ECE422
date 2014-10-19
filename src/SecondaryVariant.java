import java.util.Timer;

/**
 * Created by James on 10/19/2014.
 */
public class SecondaryVariant extends Thread
{
    int[] values;

    public SecondaryVariant(String fileInput, String fileOutput, double HAZARD, int timeLimit)
    {
        // TODO: Load fileInput into array
        values = new int[]{1,4,-3,6,8,9,3};

        Timer t = new Timer();
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
            int[] result = sorter.sort(values);

            // TODO: Output array into fileOutput
        }
        catch (ThreadDeath td)
        {
            throw new ThreadDeath();
        }
    }
}
