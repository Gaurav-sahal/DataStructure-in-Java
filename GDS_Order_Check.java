import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'countStudents' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY height as parameter.
     */

    public static int countStudents(List<Integer> height) {

        List<Integer> temp =new ArrayList<Integer>(height); 
        Collections.sort(temp);
        //System.out.println("height "+height);
        //System.out.println("temp "+temp);
        int count = 0;
        for(int i=0; i<height.size(); i++){
            if(height.get(i) != temp.get(i)){
                count++;
            }
        }
        return count;
    }

}
public class GDS_Order_Check {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int heightCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> height = IntStream.range(0, heightCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.countStudents(height);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
