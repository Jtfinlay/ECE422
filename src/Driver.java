/**
 * Created by James on 10/19/2014.
 */
public class Driver
{

    public static void main(String[] args) {

        String in = "in.txt";
        String out = "out.txt";

        Generator.generate(in, 7);

        // Execute primary
        PrimaryVariant primary = new PrimaryVariant(in, out, .8, 1000);

        try
        {
            primary.join();

            if (Adjudicator.testResult(in, out)) {
                System.out.println("Primary is successful!");
                return;
            } else {
                System.out.println("Primary has failed the Adjudicator test.");
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Primary has been interrupted.");
            e.printStackTrace();
        }

        // Execute secondary
        SecondaryVariant secondary = new SecondaryVariant(in, out, .8, 1000);
        try
        {
            secondary.join();
            if (Adjudicator.testResult(in, out)) {
                System.out.println("Secondary is successful!");
                return;
            } else {
                System.out.println("Secondary has failed the Adjudicator test.");
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
