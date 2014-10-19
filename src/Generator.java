import java.security.InvalidParameterException;
import java.util.Random;

/**
 * Created by James on 10/19/2014.
 */
public class Generator
{

    public static void main(String[] args)
    {
        if (args.length != 2)
            throw new InvalidParameterException("Two arguments expected: String, int");

        String fileName = args[0];
        int valueCount = Integer.parseInt(args[1]);

        Random rand = new Random();
        int values[] = new int[valueCount];

        for (int i=0; i<valueCount; i++)
            values[i] = rand.nextInt();

        FileManager.writeFile(fileName, values);
    }

}
