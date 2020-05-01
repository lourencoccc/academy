import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {
    
    private List<Observer> observers = new ArrayList<>();
    private String channelName;
    private String status;

    public Channel(String channelName) {
        this.channelName = channelName;
    }
    

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public String getChannelName() {
        return this.channelName;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(this.status);
        }
    }
    

}
