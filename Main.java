import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("ASMR");
			System.out.flush();

			String line;
			while ((line = br.readLine()) != null) {

				if (line.contains("video.")) {

					int startBid = 1;
					int maxBid = 3;

					// SIMPLE PARSING
					boolean subscribed = line.contains("viewer.subscribed=Y");
					boolean interestMatch = line.contains("ASMR");

					double engagement = 0.0;
					try {
						String[] parts = line.split(",");
						int views = 1;
						int comments = 0;

						for (String p : parts) {
							if (p.contains("video.viewCount=")) {
								views = Integer.parseInt(p.split("=")[1]);
							}
						}
						engagement = (double) comments / views;
					} catch (Exception ignored) {}

					// SCORING
					double score = 0;

					if (subscribed) score += 2;
					if (interestMatch) score += 2;
					score += engagement * 10;

					// BID LOGIC
					if (score > 3) {
						startBid = 5;
						maxBid = 15;
					} else if (score > 1.5) {
						startBid = 2;
						maxBid = 8;
					} else {
						startBid = 1;
						maxBid = 3;
					}

					System.out.println(startBid + " " + maxBid);
					System.out.flush();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}