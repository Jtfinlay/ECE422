/**
 * Created by James on 10/19/2014.
 */
public class Driver
{

    public static void main(String[] args) {
        // Generate integer values

        // Execute primary
        PrimaryVariant primary = new PrimaryVariant("in", "out", .8, 1000);

        try
        {
            primary.join();
            // Success
            System.out.println("1st success");
        }
        catch (InterruptedException e)
        {
            // Failure
            System.out.println("1st failure");
        }

        // If pass adjudicator, return result

        // If adjudicator rejects, timer kills, or primary has error:
        // - Print error message
        // - Execute shadow
        SecondaryVariant secondary = new SecondaryVariant("in", "out", .8, 1000);
        try
        {
            secondary.join();
            System.out.println("2nd success");
        }
        catch (InterruptedException e)
        {
            System.out.println("2nd failure");
        }

        // If pass adjudicator, return result

        // If adjudicator rejects, timer kills, or shadow has error:
        // - Print error message
        // - Delete output file
        // - Terminate program

        System.out.println("exit");
    }

}
