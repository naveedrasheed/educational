/* From http://java.sun.com/docs/books/tutorial/index.html */
/*
 * Copyright (c) 2006 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *
 * -Redistribution in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * Neither the name of Sun Microsystems, Inc. or the names of contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MIDROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */
import java.applet.Applet;
import java.awt.Graphics;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class GUIClock extends Applet implements Sleeper {

  private AlarmClock clock;

  public void init() {
    clock = new AlarmClock();
  }

  public void start() {
    clock.letMeSleepFor(this, ONE_SECOND);
  }

  public void paint(Graphics g) {
    Calendar cal = Calendar.getInstance();
    Date date = cal.getTime();
    DateFormat dateFormatter = DateFormat.getTimeInstance();
    g.drawString(dateFormatter.format(date), 5, 10);
  }

  public void wakeUp() {
    repaint();
    clock.letMeSleepFor(this, ONE_SECOND);
  }
}

interface Sleeper {
  public void wakeUp();

  public long ONE_SECOND = 1000; // in milliseconds
}

class AlarmClock {

  private static final int MAX_CAPACITY = 10;

  private static final int UNUSED = -1;

  private static final int NOROOM = -1;

  private Sleeper[] sleepers = new Sleeper[MAX_CAPACITY];

  private long[] sleepFor = new long[MAX_CAPACITY];

  public AlarmClock() {
    for (int i = 0; i < MAX_CAPACITY; i++)
      sleepFor[i] = UNUSED;
  }

  public synchronized boolean letMeSleepFor(Sleeper s, long time) {
    int index = findNextSlot();
    if (index == NOROOM) {
      return false;
    } else {
      sleepers[index] = s;
      sleepFor[index] = time;
      new AlarmThread(index).start();
      return true;
    }
  }

  private synchronized int findNextSlot() {
    for (int i = 0; i < MAX_CAPACITY; i++) {
      if (sleepFor[i] == UNUSED)
        return i;
    }
    return NOROOM;
  }

  private synchronized void wakeUpSleeper(int sleeperIndex) {
    sleepers[sleeperIndex].wakeUp();
    sleepers[sleeperIndex] = null;
    sleepFor[sleeperIndex] = UNUSED;
  }

  private class AlarmThread extends Thread {
    int mySleeper;

    AlarmThread(int sleeperIndex) {
      super();
      mySleeper = sleeperIndex;
    }

    public void run() {
      try {
        sleep(sleepFor[mySleeper]);
      } catch (InterruptedException e) {
      }
      wakeUpSleeper(mySleeper);
    }
  }
}
