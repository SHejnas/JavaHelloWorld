public class Solution {
    private static final String[] HOUR_NUM = {"midnight", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
            "twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "midnight"};
    private static final String[] MIN_NUM = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
            "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "half"};
    private static final String O_CLOCK = "o'clock";
    private static final String MINUTE = "minute";
    private static final String MINUTES = "minutes";
    private static final String PAST = "past";
    private static final String TO = "to";
    private static final int MINUTES_IN_HOUR = 60;

    public static String solve(String time){

       final String[] timeArr = time.split(":");
       final int minutes = Integer.parseInt(timeArr[1]);
       final int hour = Integer.parseInt(timeArr[0]);
       final StringBuilder output = new StringBuilder();


       if(minutes == 0){
           output.append(HOUR_NUM[hour]);
           if(hour == 0){
               return output.toString();
           }else{
               return output.append(" " + O_CLOCK).toString();
           }
       }

        final boolean bottomOfHour = (minutes >= 31);
        final int refactoredMin;
        final int refactoredHour;
        final String minutesReferenceDirection;
        if(bottomOfHour){
            refactoredMin = MINUTES_IN_HOUR - minutes;
            refactoredHour = hour + 1;
            minutesReferenceDirection = TO;
        }
        else{
            refactoredMin = minutes;
            refactoredHour = hour;
            minutesReferenceDirection = PAST;
        }

        output.append(MIN_NUM[refactoredMin]);
        if(refactoredMin == 1){
            output.append(" " + MINUTE);
        }
        else if((refactoredMin != 15) && (refactoredMin != 30)){
            output.append(" " + MINUTES);
        }

        output.append(" " + minutesReferenceDirection);

        output.append(" " + HOUR_NUM[refactoredHour]);

        return output.toString();
    }
}