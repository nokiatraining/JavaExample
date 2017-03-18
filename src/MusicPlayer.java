import java.io.*;
import java.util.*;
public class MusicPlayer {
	public ArrayList<String> SongsList = new ArrayList<String>();
	public ArrayList<String> SingersList = new ArrayList<String>();
	int songplaying=0;
	public void addSongs(String input) throws IOException
	{
		
		File file = new File(input);
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=bf.readLine())!=null)
			{
				String tokens[]=line.split("/");
				SongsList.add(tokens[0]);
				SingersList.add(tokens[1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void PrintSongsandSingers()
	{
		System.out.println("Songs: "+SongsList);
		System.out.println("Singers: "+SingersList);
	}
    public void PlaySong(String song)
    {
    	if(songplaying==0)
    	{
    		if(SongsList.contains(song))
    		{
    			songplaying=1;
    			System.out.println("Current Song playing: "+song);
    			System.out.println("Singer: "+SingersList.get((SongsList.indexOf(song))));
    		}
    		else
    		{
    			System.out.println("song does not exist");
    		}
    	}
    	else
    		System.out.println("A song is already being played");
    }
    public void StopSong()
    {
    	if(songplaying==1)
    	 {
    	   songplaying=0;
    	   System.out.println("Song stopped");
    	 }
    	else
    		System.out.println("No song being played");
    }
	public static void main(String[] args) throws IOException {
		MusicPlayer Mp1 = new MusicPlayer();
		Mp1.addSongs("C:\\Users\\adityav\\Documents\\Songs.txt");
		Mp1.PrintSongsandSingers();
		Mp1.PlaySong("Tu hai");
		Mp1.PlaySong("Hossana");
		Mp1.StopSong();
		Mp1.StopSong();
		Mp1.PlaySong("Hossana");
	}

}
