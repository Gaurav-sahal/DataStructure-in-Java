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

    public static int getUmbrellas(int requirement, List<Integer> sizes) {
        int result=-1, count=0;
        Collections.sort(sizes);
        for(int i=sizes.size()-1; i>=0; i--) {
            count = count + sizes.get(i);
            int currValue=0;
            if(sizes.get(i) == requirement) {
                result = 1;
                break;
            }
            else {
                if(requirement > sizes.get(i)) {
                    if(requirement % sizes.get(i) == 0) {
                        currValue = requirement / sizes.get(i);
                    }
                    else {
                        int compute = requirement/sizes.get(i);
                        int itr = compute;
                        while(itr >= 1) {
                            int rem = requirement - itr * sizes.get(i);
                            int sum2 = itr * sizes.get(i);
                            boolean flag=false;
                            int inc = 0;
                            for(int k=i-1; k>=0; k--) {
                                
                                if(rem == sizes.get(k) ) {
                                    
                                    currValue = itr + 1;
                                    flag = true;
                                    break;
                                }
                                else if(rem % sizes.get(k) == 0) {
                                    currValue = itr + (rem / sizes.get(k));
                                    flag = true;
                                    break;
                                }
                                else {
                                    sum2 = sum2 + sizes.get(k);
                                    if(sum2 > requirement) {
                                        break;
                                    }
                                    inc++;
                                    if(sum2 == requirement) {
                                        currValue = itr + inc;
                                        flag = true;
                                    }
                                }
                            }                                
                            
                            if(result == -1 && flag == true) {
                                result = currValue;
                            }
                            else if(result > currValue && currValue != 0) {
                                result =currValue;
                            }
                            itr--;
                        }
                    }
                }
            }
            
            if(result == -1 && currValue != 0) {
                result = currValue;
            }
            else if(result != -1 &&  currValue != 0 && result >= currValue)
                    result = currValue;
        
        }
    
        if(count == requirement && result == -1) {
            result = sizes.size(); 
        }
        return result;
    }

}

public class Monsoon_Umbrellas {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int requirement = Integer.parseInt(bufferedReader.readLine().trim());

        int sizesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sizes = IntStream.range(0, sizesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.getUmbrellas(requirement, sizes);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
