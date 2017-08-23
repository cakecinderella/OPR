
package test; // da kehrt da ordner her

// TODO: Auto-generated Javadoc
/**
 * The Class clocktime.
 */
public class Clocktime {

  /** The total seconds. */
  
	final static int SECONDS_PER_DAY = 60 * 60 * 24;
	int totalSeconds;

  /**
   * Instantiates a new clocktime.
   *
   * @param hours the hours
   * @param minutes the minutes
   * @param seconds the seconds
   */
  public Clocktime(int hours, int minutes, int seconds) {
    totalSeconds = hours * 60 * 60 + minutes * 60 + seconds;
  }

  /**
   * Instantiates a new clocktime.
   *
   * @param hours the hours
   * @param minutes the minutes
   */
  public Clocktime(int hours, int minutes) {
    this(hours, minutes, 0);
  }

  /**
   * Instantiates a new clocktime.
   *
   * @param totalSeconds the total seconds
   */
  public Clocktime(int totalSeconds) {
    this.totalSeconds = totalSeconds;
  }

  /**
   * Instantiates a new clocktime.
   *
   * @param time the time
   */
  public Clocktime(Clocktime time) {
    this(time.totalSeconds);
  }

  /**
   * Adds the.
   *
   * @param time the time
   */
  public void add(Clocktime time) {
    this.totalSeconds += time.totalSeconds;
  }

  /**
   * Subtract.
   *
   * @param time the time
   */
  public void subtract(Clocktime time) {
    this.totalSeconds -= time.totalSeconds;
  }

  /**
   * Gets the hours.
   *
   * @return the hours
   */
  public int getHours() {
    return totalSeconds / 60 / 60;
  }

  /**
   * Gets the minutes.
   *
   * @return the minutes
   */
  public int getMinutes() {
    return totalSeconds / 60 % 60;
  }

  /**
   * Gets the seconds.
   *
   * @return the seconds
   */
  public int getSeconds() {
    return totalSeconds % 60;
  }
  
  //methode setTotalSeconds soll normalize beinhalten und totalSeconds überall ersetzen
  
  public void normalizer() {
	  totalSeconds %= SECONDS_PER_DAY;
	  if(totalSeconds < 0){
		  totalSeconds += SECONDS_PER_DAY;
	  }
  }
}