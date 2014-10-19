import java.util.Timer;

/**
 * Created by James on 10/19/2014.
 */
public class PrimaryVariant extends Thread
{
    int[] values;
    Timer t;

    public PrimaryVariant(String fileInput, String fileOutput, double HAZARD, int timeLimit)
    {
        // TODO: Load fileInput into array
        values = new int[]{1,4,-3,6,8,9,3};



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

            System.out.print("\nPrimary: ");
            for (int r : result)
                    System.out.print(r +",");

            // TODO: Output array into fileOutput
            t.cancel();

        }
        catch (ThreadDeath td)
        {
            t.cancel();
            throw new ThreadDeath();
        }
    }
}
