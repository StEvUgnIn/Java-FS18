package mvc;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CounterModel {

    private BooleanProperty startPrp;
    private BooleanProperty stopPrp;
    private BooleanProperty resetPrp;
    private StringProperty timePrp;
    private int s, m, h;

    public CounterModel () {
        startPrp = new SimpleBooleanProperty(false);
        stopPrp = new SimpleBooleanProperty(true);
        resetPrp = new SimpleBooleanProperty(false);
        timePrp = new SimpleStringProperty("Time: 00:00:00");
    }

    public void reset () {
        s = 0;
        m = 0;
        h = 0;
        getTime();
    }

    public void next () {
        s++;
        if (s == 60) {
            m++;
            s = 0;
        }
        if (m == 60) {
            h++;
            m = 0;
        }
        getTime();
    }

    public String getTime () {
        String x = s > 9 ? "" : "0";
        String y = m > 9 ? "" : "0";
        String z = h > 9 ? "" : "0";

        getTimePrp().set("Time: " + z + h + ":" + y + m + ":" + x + s);
        return getTimePrp().get();
    }

    BooleanProperty getStartPrp () {
        return startPrp;
    }

    BooleanProperty getStopPrp () {
        return stopPrp;
    }

    BooleanProperty getResetPrp () {
        return resetPrp;
    }

    StringProperty getTimePrp () {
        return timePrp;
    }
}
