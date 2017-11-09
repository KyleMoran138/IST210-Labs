
//package ist210.edu.nhti;

import java.text.DecimalFormat;

public class Time extends Object {
   private int hour;     // 0 - 23
   private int minute;   // 0 - 59
   private int second;   // 0 - 59

   // Time constructor initializes each instance variable
   // to zero. Ensures that Time object starts in a
   // consistent state.
   public Time(){
      setTime( 0, 0, 0 );
   }

   // Time constructor: hour supplied, minute and second
   // defaulted to 0
   public Time( int h ){
      setTime( h, 0, 0 );
   }

   // Time constructor: hour and minute supplied, second
   // defaulted to 0
   public Time( int h, int m ){
      setTime( h, m, 0 );
   }

   // Time constructor: hour, minute and second supplied
   public Time( int h, int m, int s ){
      setTime( h, m, s );
   }

   // Time constructor: another Time object supplied
   public Time( Time time ){
      setTime( time.getHour(), time.getMinute(),
         time.getSecond() );
   }

   // Set Methods
   // Set a new time value using universal time. Perform
   // validity checks on data. Set invalid values to zero.
   /* Write header for setTime. */
   public boolean setTime(int h, int m, int s){
	  if(h < 0 && h > 24) h = 0;
      if(m < 0 && h > 60) m = 0;
      if(s < 0 && h > 60) s = 0;
      this.hour = h;
      this.minute = m;
      this.second = s;
      return true;
   }

   // validate and set hour
   /* Write header for the setHour method. */
   public boolean setHour(int h){
     if(h < 0 && h > 24) h = 0;
     this.hour = h;
	   return false;
   }

   // validate and set minute
   /* Write the header for the setMinute method. */
   public boolean setMinute(int m){
     if(m < 0 && m > 24) m = 0;
     this.minute = m;
	   return false;
   }

   // validate and set second
   /* Write the header for the setSecond method. */
   public boolean setSecond(int s){
     if(s < 0 && s > 24) s = 0;
     this.second = s;
	   return false;
   }

   // Get Methods
   // get hour value
   public int getHour(){
      return hour;
   }

   // get minute value
   public int getMinute(){
      return minute;
   }

   // get second value
   public int getSecond(){
      return second;
   }

   // convert to String in universal-time format
   public String toUniversalString()
{
      DecimalFormat twoDigits = new DecimalFormat( "00" );

      return twoDigits.format( getHour() ) + ":" +
         twoDigits.format( getMinute() ) + ":" +
         twoDigits.format( getSecond() );
   }

   // convert to String in standard-time format
   public String toString()
{
      DecimalFormat twoDigits = new DecimalFormat( "00" );

      return ( ( getHour() == 12 || getHour() == 0 ) ?
         12 : getHour() % 12 ) + ":" +
         twoDigits.format( getMinute() ) + ":" +
         twoDigits.format( getSecond() ) +
         ( getHour() < 12 ? " AM" : " PM" );
   }
}  // end class Time
