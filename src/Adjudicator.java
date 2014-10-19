import java.util.Arrays;

/**
 * Created by James on 10/19/2014.
 */
public class Adjudicator {

    public static boolean testResult(String fileInput, String fileOutput)
    {
        if (!FileManager.fileExists(fileInput)) return false;
        if (!FileManager.fileExists(fileOutput)) return false;

        int[] input = FileManager.readFile(fileInput);
        int[] output = FileManager.readFile(fileOutput);
        Arrays.sort(input);

        for (int i=0; i < input.length; i++)
        {
            if (input[i] != output[i]) return false;
        }
        return true;
    }
}
