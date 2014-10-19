/**
 * Created by James on 10/19/2014.
 */

import java.util.TimerTask;

public class Watchdog extends TimerTask
{

    Thread watched;

    public Watchdog(Thread target)
    {
        watched = target;
    }

    public void run()
    {
        watched.stop();
    }
}
