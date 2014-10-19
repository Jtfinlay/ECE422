/**
 * Created by James on 10/19/2014.
 */
public class Driver
{

    public static void main(String[] args) {
        // Generate integer values

        String in = "in.txt";
        String out = "out.txt";

        // Execute primary
        PrimaryVariant primary = new PrimaryVariant(in, out, .8, 1000);

        try
        {
            primary.join();

            if (Adjudicator.testResult(in, out))
                System.out.println("\n1st success");
            else
                System.out.println("\n1st failure");
        }
        catch (InterruptedException e)
        {
            // Failure
            System.out.println("\n1st failure");
        }

        // If pass adjudicator, return result

        // If adjudicator rejects, timer kills, or primary has error:
        // - Print error message
        // - Execute shadow
        SecondaryVariant secondary = new SecondaryVariant(in, out, .8, 1000);
        try
        {
            secondary.join();
            System.out.println("\n2nd success");
        }
        catch (InterruptedException e)
        {
            System.out.println("\n2nd failure");
        }

        // If pass adjudicator, return result

        // If adjudicator rejects, timer kills, or shadow has error:
        // - Print error message
        // - Delete output file
        // - Terminate program

        System.out.println("exit");
    }

}
