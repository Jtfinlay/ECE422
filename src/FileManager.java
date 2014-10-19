import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 10/19/2014.
 */
public class FileManager {


    public static int[] readFile(String file)
    {
        BufferedReader br = null;
        String line;

        List<Integer> values = new ArrayList<Integer>();

        try
        {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null)
            {
                for (String item : line.split(","))
                    values.add(Integer.parseInt(item));
            }
        }
        catch (FileNotFoundException e)
        {
        }
        catch (IOException e)
        {
        }
        finally
        {
            if (br != null) try {br.close();} catch(IOException e) {}
        }

        int[] result = new int[values.size()];
        for (int i=0; i<values.size(); i++) result[i] = values.get(i);

        return result;
    }

    public static void writeFile(String fileName, int[] values)
    {
        try{
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            for (int i=0; i<values.length; i++)
            {
                writer.print(values[i]);
                if (i != values.length-1)
                    writer.print(",");
            }
            writer.close();
        } catch (UnsupportedEncodingException e) {
        } catch (FileNotFoundException e)
        {}
    }
}
