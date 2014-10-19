import java.util.Timer;

/**
 * Created by James on 10/19/2014.
 */
public class SecondaryVariant extends Thread
{
    int[] values;
    Timer t;
    String fout;
    double failure;

    public SecondaryVariant(String fileInput, String fileOutput, double failure, int timeLimit)
    {
        fout = fileOutput;
        this.failure = failure;
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

            int[] actual = new int[result.length-1];
            for (int i=0; i<actual.length; i++) actual[i] = result[i];

            double error = Math.random();
            if (error > 0.5 && error < .5 + result[result.length-1] * failure)
            {
                t.cancel();
            }

            FileManager.writeFile(fout, actual);

            t.cancel();
        }
        catch (Error e)
        {
            t.cancel();
            throw e;
        }
    }
}
