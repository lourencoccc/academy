

public class Follower implements Observer {

    private String followerName;

    public Follower(String followerName) {
        this.followerName = followerName;
    }

    @Override
    public void update(String status) {
        System.out.printf("Follower: %s, Status recived: %s\n", followerName, status);
        play();
    }

    public void play(){
        System.out.printf("Play: %s\n", followerName);
    }
}