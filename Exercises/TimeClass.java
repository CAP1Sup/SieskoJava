/**
 * @author Christian Piper
 * @since 9/24/21
 */
public class TimeClass {
    private int hrs, min, sec;

    TimeClass() {
        hrs = 0;
        min = 0;
        sec = 0;
    }

    TimeClass(int hours) {
        hrs = hours;
        min = 0;
        sec = 0;
    }

    TimeClass(int hours, int mins) {
        hrs = hours;
        min = mins;
        sec = 0;
        fixTime();
    }

    TimeClass(int hours, int mins, int secs) {
        hrs = hours;
        min = mins;
        sec = secs;
        fixTime();
    }

    public int getHours() {
        return hrs;
    }

    public void setHours(int hours) {
        hrs = hours;
    }

    public int getMins() {
        return min;
    }

    public void setMins(int mins) {
        min = mins;
        fixTime();
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int secs) {
        sec = secs;
        fixTime();
    }

    public void addTime(int hours, int minutes, int seconds) {
        hrs = hours;
        min = minutes;
        sec = seconds;
        fixTime();
    }

    private void fixTime() {
        sec = sec % 60;
        min = (min % 60) + (sec / 60);
        hrs = hrs + (min / 60);
    }

    public String toString() {
        return ("H: " + hrs + " | M: " + min + " | S: " + sec);
    }
}
