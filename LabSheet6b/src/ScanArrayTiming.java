import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class ScanArrayTiming {

    public static int[] generateRandomArray(int x)
    {
        Random numGenerator = new Random(x);
        int[] generatedArray = new int[x];

        for(int i=0; i < x; i++)
        {
            generatedArray[i] = numGenerator.nextInt(100);
        }

        return generatedArray;
    }

    public static Boolean scanArray(int[] a, int e)
    {
        Boolean found = false;
        for(int i=0; i < a.length; i++)
        {
            if (e == a[i])
            {
                found = true;
            }
        }

        return found;
    }

    public static Boolean scanArrayEarlyAbandon(int[] a, int e)
    {
        for(int i=0; i < a.length; i++)
        {
            if (e == a[i])
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        int[] testArray;
        long startTime;
        long finishTime;
        long totalTime;
        Random searchIntRandom = new Random(100);
        //FileWriter resultsFile = new FileWriter("scanArrayResults.txt");
        FileWriter resultsFile = new FileWriter("scanArrayEarlyResults.txt");




        for(int i = 1000; i < 10000000; i*=2)
        {
            testArray = generateRandomArray(i);
            startTime = System.nanoTime();
            //scanArray(testArray, searchIntRandom.nextInt(100));
            scanArrayEarlyAbandon(testArray, searchIntRandom.nextInt(100));
            finishTime = System.nanoTime();

            totalTime = finishTime - startTime;
            finishTime = 0;
            startTime = 0;

            resultsFile.write(i + "," + totalTime + "\n");

        }
        resultsFile.close();

    }

}