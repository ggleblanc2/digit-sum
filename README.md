# Digit Sum

Recently, on Stack Overflow, this question was posted.

> Printing integer numbers between 100 to 1000000 whose digits sum equals 19

Not much to go on.  The problem sounded interesting, so I quickly coded it and found out there were 30,492 integers whose digits sum to 19 between the integers 100 and 1,000,000.

Before I continue, if you're here just to find out how to sum the digits of an `int` value, here's the method I used.

    private int sumDigits(int value) {
        int sum = 0;
		
        while (value > 0) {
            int remainder = value % 10;
            sum += remainder;
            value = value / 10;
        }
		
        return sum;
    }

I decided to turn this problem into a problem of how to generalize shortening a long console display.  What do I mean by that?  It's easier to show than tell.  Here's the output from one of my many test runs.

      Integer  Sum
          199   19
          289   19
          298   19
          379   19
          388   19
          397   19
          469   19
          478   19
          487   19
          496   19
          ...
      980,110   19
      980,200   19
      981,001   19
      981,010   19
      981,100   19
      982,000   19
      990,001   19
      990,010   19
      990,100   19
      991,000   19
    There were 30,492 integers whose digits sum to 19 between the integers 100 and 1,000,000.

I printed the first 10 values, then an ellipses, then the last 10 values.  I printed enough to visually verify that the Java program was summing the digits correctly, but not so much that I couldn't visually verify that the Java program was summing the digits correctly.
  
So, in order to produce the shortened console output, I had to generate all of the integers whose digits summed to 19, save those values to a `List`, print the first 10 values, and print the last 10 values.  If the resulting `List` had less than 20 values, I'd print all the values.

The code I wrote accepted the integer minimum, the integer maximum, and the integer sum of the digits to match.  You can change these values to any positive integers you wish, and the code will produce the correct result.

I go through all the values between the minimum and the maximum one by one.  This is fast enough for the integers 100 to one million, but will take some minutes to compute if the range is much larger, like from 100 to `Integer.MAX_VALUE`.

The method that displays the two integer ranges has a javadoc describing what it does.  While you may not always display a list of integers, the technique of displaying a few of the many results for visual verification is worth knowing and understanding.

I did not write the final code in one step.  I added a little bit here and a little bit there until I got everything working.  I refactored some of the code when I had good test results to keep any method from getting too nulti-purpose.  A method should do one thing and do it well.
