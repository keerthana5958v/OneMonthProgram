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
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */
     
    static Calendar calender; 
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String date = sc.next();
        String month = sc. next();
        String year = sc.next();
        int date1;
        if(date.charAt(0)=='0'){
            date1 = (int) date.charAt(1);
        }
        else{
            date1 = Integer.valueOf(date);
        }
        int month1;
        if(month.charAt(0)=='0'){
            month1 = (int) month.charAt(1);
        }
        else{
            month1 = Integer.valueOf(month);
        }
        int year1;
        if(year.charAt(0)=='0'){
            year1 = (int) year.charAt(1);
        }
        else{
            year1 = Integer.valueOf(year);
        }
        System.out.println(findDay(month1,date1,year1));
        
        
     }
         

    public static String findDay(int month, int day, int year) {
        calender.set(year,(month - 1),day);
        int dayOfWeek = calender.get(Calendar.DAY_OF_WEEK);
        String theDay="";
        switch(dayOfWeek){
            case 1:
            theDay = "SUNDAY";
            break;
            case 2:
            theDay = "TUESDAY";
            break;
            case 3:
            theDay = "WEDNESDAY";
            break;
            case 4:
            theDay = "THURSDAY";
            break;
            case 5:
            theDay = "FRIDAY";
            break;
            case 6:
            theDay = "SATURDAY";
            break;
            case 7:
            theDay = "SUNDAY";
            break;
        }
        return theDay;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

