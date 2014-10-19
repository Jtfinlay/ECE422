import java.util.Random;

/**
 * Created by James on 10/19/2014.
 */
public class Generator
{

    public static void generate(String fileName, int valueCount)
    {
        Random rand = new Random();
        int values[] = new int[valueCount];

        for (int i=0; i<valueCount; i++)
            values[i] = rand.nextInt();

        FileManager.writeFile(fileName, values);
    }

}
