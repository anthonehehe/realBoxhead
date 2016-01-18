package realboxhead;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class HighScores {

	/**
	 * Checks if file exists, if not,
	 * then it will create the file
	 */
	private static void checkScoresFile(String filename) {
		File file = new File(filename + ".ini");
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("Created new scores file");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * method to handle where
	 * score gets placed
	 * on ranking 
	 * @param score
	 */
	public static void saveScore(String filename, int score) {
		try {
			checkScoresFile(filename);
			boolean saveNewScore = false; // True only when need to save new score
			int[] scores = new int[5]; // Top 5 scores

			Properties props = new Properties();
			props.load(new FileInputStream(filename + ".ini"));
			for (int i = 0; i < scores.length; i++) {
				String p = props.getProperty(i + ""); // Find an element with a certain key
				if (p != null) {
					// If element exists, take the value of that element and parse it into an integer
					scores[i] = Integer.parseInt(p);
				}
			}
			Arrays.sort(scores); // Sort array from least to greatest
			
			for (int a = scores.length - 1; a > 0; a--) {
				if (score > scores[a]) {
					for (int i = 0; i < a; i++) {
						scores[i] = scores[i + 1];
					}
					saveNewScore = true;
					scores[a] = score;
					break;
				}
			}
			
			if (saveNewScore) {
				FileOutputStream out = new FileOutputStream(filename + ".ini", false);
				String str = "";
				for (int i = 0; i < scores.length; i++) {
					str += i + "=" + scores[i] + "\r\n";
				}
				out.write(str.getBytes());
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
