public class Solution {
    public static String solve(String time){
        final String[] NUMBERS = { "midnight", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ", "eleven ",
                "twelve ", "thirteen ", "fourteen ", "", "sixteen ", "seventeen ", "eighteen ", "nineteen ", "twenty ", "", "", "eleven ", "midnight "};
        final String[] PHRASES = {"o'clock", "quarter to ", "quarter past ", "half past ", "minutes past ", "minutes to ", "one minute to ", "one minute past "};

        String retStatement = "";

        String[] timeArr = time.split(":");
        int minutes = Integer.parseInt(timeArr[1]);
        int hour = Integer.parseInt(timeArr[0]);
        if(hour > 12 & hour != 23){
           hour -= 12;
        }
        if(minutes == 0 & hour == 0) {
            return NUMBERS[24].trim();
        } else if(minutes == 0){
            return NUMBERS[hour] + PHRASES[0].trim();
        } else if(minutes == 30){
            return PHRASES[3] + NUMBERS[hour].trim();
        } else if(minutes == 15){
            return  PHRASES[2] + NUMBERS[hour].trim();
        }else if(minutes == 45){
            hour = (hour ==(12 | 23))? hour : hour%12;
            return PHRASES[1] + NUMBERS[hour+1].trim();
        }else if(minutes == 1) {
            return PHRASES[7] + NUMBERS[hour].trim();
        }else if(minutes ==59) {
            hour = (hour ==(12 | 23))? hour : hour%12;
            return PHRASES[6] + NUMBERS[hour+1].trim();
        }else if(minutes <= 20){
            return NUMBERS[minutes] + PHRASES[4] + NUMBERS[hour].trim();
        } else if(minutes < 30){
            return NUMBERS[20] + NUMBERS[minutes-20] + PHRASES[4] + NUMBERS[hour].trim();
        } else if(minutes < 40){
            hour = (hour ==(12 | 23))? hour : hour%12;
            return NUMBERS[20] + NUMBERS[40 - minutes] + PHRASES[5] + NUMBERS[hour+1].trim();
        } else if(minutes >= 40){
            return NUMBERS[60 - minutes] + PHRASES[5] + NUMBERS[hour+1].trim();
        }

        return "its broken";
    }
}