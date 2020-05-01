public class Song implements IComponent {
	public String songName;
	public String artist;
	public float speed = 1; // Default playback speed

	public Song(String songName, String artist ) {
		this.songName = songName;
		this.artist = artist; 
	}
	
    public void play() {
        System.out.printf("Playing song %s with speed %.2f\n", songName, speed);
    }

    public void setPlayBackSpeed(float speed){
        this.speed = speed;
    }

    public String getArtist(){
        return artist;
    }

    public String getName(){
        return songName;
    }
	
}