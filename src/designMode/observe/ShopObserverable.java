package designMode.observe;

import java.util.ArrayList;
import java.util.List;

public class ShopObserverable implements Observerable {
    private List<Observer> observers = new ArrayList<>();
    private String mMessage;
    @Override
    public void addObserve(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserve(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer :
                observers) {
            observer.update(mMessage);
        }
    }

    @Override
    public void pushMessage(String message) {
        mMessage = message;
        notifyObservers();
    }
}
