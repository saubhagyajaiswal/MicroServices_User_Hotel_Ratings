/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		int[][] preferences = {
                {0, 1, 3, 2},    // User 0 preferences
                {0, 2, 3, 1},    // User 1 preferences
                {1, 0, 3, 2},     // User 2 preferences
                {2, 1, 0, 3},
                {0, 3, 1, 2}
        };

        int[] songRanking = rankSongs(preferences);

        System.out.println("Song Ranking: " + Arrays.toString(songRanking));
    }

    public static int[] rankSongs(int[][] preferences) {
        int m = preferences[0].length; // Number of songs
        int n = preferences.length;    // Number of users

        Map<Integer, Integer> songWins = new HashMap<>();

        // Count the number of wins for each song
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int songA = preferences[i][j];
                for (int k = j + 1; k < m; k++) {
                    int songB = preferences[i][k];
                    if (songA == songB) continue; // Skip if songs are the same
                    songWins.put(songA, songWins.getOrDefault(songA, 0) + 1);
                    songWins.put(songB, songWins.getOrDefault(songB, 0) - 1);
                }
            }
        }

        // Find the most popular song(s)
        List<Map.Entry<Integer, Integer>> songWinsList = new ArrayList<>(songWins.entrySet());
        songWinsList.sort(Map.Entry.<Integer, Integer>comparingByValue()
                .thenComparing(Map.Entry.comparingByKey()));

        int[] songRanking = new int[m];
        Collections.reverse(songWinsList);
     songWinsList.forEach((x) ->{
             System.out.println(x.getKey()+ " : "+ x.getValue());

     });

        for (int i = 0; i < m; i++) {
            songRanking[i] = songWinsList.get(i).getKey();
        }

        return songRanking;
    }
}
