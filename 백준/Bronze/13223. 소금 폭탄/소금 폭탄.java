import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String currentTime = br.readLine();
        String dropTime = br.readLine();

        String[] currentSplit = currentTime.split(":");
        String[] dropSplit = dropTime.split(":");

        int currentHour = Integer.parseInt(currentSplit[0]);
        int currentMinute = Integer.parseInt(currentSplit[1]);
        int currentSecond = Integer.parseInt(currentSplit[2]);

        int dropHour = Integer.parseInt(dropSplit[0]);
        int dropMinute = Integer.parseInt(dropSplit[1]);
        int dropSecond = Integer.parseInt(dropSplit[2]);

        int currentTotal = currentHour * 60 * 60 + currentMinute * 60 + currentSecond;
        int dropTotal = dropHour * 60 * 60 + dropMinute * 60 + dropSecond;

        if (currentTotal > dropTotal) dropTotal += 24 * 60 * 60;

        int timeDiffTotal = dropTotal - currentTotal;

        if (timeDiffTotal == 0) {
            System.out.print("24:00:00");
        } else {
            int restTime = timeDiffTotal;
            int hour = restTime / 3600;
            restTime %= 3600;
            int minute = restTime / 60;
            restTime %= 60;
            int second = restTime;

            String hourToken = hour <= 9 ? "0" + hour : String.valueOf(hour);
            String minuteToken = minute <= 9 ? "0" + minute : String.valueOf(minute);
            String secondToken = second <= 9 ? "0" + second : String.valueOf(second);

            System.out.print(hourToken + ":" + minuteToken + ":" + secondToken);
        }
    }
}
