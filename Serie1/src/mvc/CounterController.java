package mvc;

import javafx.animation.AnimationTimer;

public class CounterController {

    private AnimationTimer timer;
    private CounterModel model;

    public CounterController (CounterModel model) {
        timer = new AnimationTimer() {
            private long currentTime;

            public void handle (long now) {
                if (now > currentTime + 1_000_000_000L) {
                    currentTime = now;
                    model.next();
                }
            }
        };
    }

    public void start () {
        timer.start();
        model.getStartPrp().setValue(true);
        model.getStopPrp().setValue(false);
        model.getResetPrp().setValue(false);
    }

    public void stop () {
        timer.stop();
        model.getStartPrp().setValue(false);
        model.getStopPrp().setValue(true);
    }

    public void reset () {
        model.reset();
        timer.stop();
        model.getStartPrp().setValue(false);
        model.getStopPrp().setValue(true);
        model.getResetPrp().setValue(true);
    }

    public void addObserver (CounterModel m) {
        model = m;
    }

}
