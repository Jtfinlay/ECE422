import java.security.InvalidParameterException;

/**
 * Created by James on 10/19/2014.
 */
public class Driver
{

    public static void main(String[] args)
    {
        if (args.length != 5)
            throw new InvalidParameterException("Arguments expected: File-in(string), File-out(string), Primary "
                    + "failure(double), Secondary Failure(double), Time limit (int)");
        String in = args[0];
        String out = args[1];
        double pFailure = Double.parseDouble(args[2]);
        double sFailure = Double.parseDouble(args[3]);
        int timeLimit = Integer.parseInt(args[4]);

        FileManager.deleteFile(out);

        // Execute primary
        PrimaryVariant primary = new PrimaryVariant(in, out, pFailure, timeLimit);

        try
        {
            primary.join();

            if (Adjudicator.testResult(in, out)) {
                System.out.println("Primary is successful!");
                return;
            } else {
                System.out.println("Primary has not passed adjudicator or has failed.");
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Primary has been interrupted.");
            e.printStackTrace();
        }

        // Execute secondary
        SecondaryVariant secondary = new SecondaryVariant(in, out, sFailure, timeLimit);
        try
        {
            secondary.join();
            if (Adjudicator.testResult(in, out)) {
                System.out.println("Secondary is successful!");
                return;
            } else {
                System.out.println("Secondary has not passed adjudicator or has failed.");
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Secondary has been interrupted");
            e.printStackTrace();
        }

        FileManager.deleteFile(out);

        System.out.println("exit");
    }

}
