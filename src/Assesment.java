import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assesment {
	private static Map<String, List<String>> map = new HashMap<>();

	public static void main(String[] args) {
		addSong("s1", "Shivu");
		addSong("s2", "Shivu");
		checkRecentSong("Shivu");

		addSong("s10", "Shivu");
		checkRecentSong("Abc");

	}

	public static void checkRecentSong(String user) {
		if (map.containsKey(user)) {
			for (Map.Entry<String, List<String>> entry : map.entrySet()) {
				if (entry.getKey() == user) {
					System.out.println(entry.getKey() + "has played following song recently "
							+ entry.getValue().get(entry.getValue().size() - 1) + "and least recent is "
							+ entry.getValue().get(0));
				}
			}
		} else {
			System.out.println(user + "key not found in memory");
		}
	}

	public static void addSong(String song, String user) {
		if (map.containsKey(user)) {
			for (Map.Entry<String, List<String>> entry : map.entrySet()) {
				if (entry.getKey() == user) {
					if (entry.getValue().size() == 3) {
						entry.getValue().remove(0);
					}
					entry.getValue().add(song);
				} else {
					continue;
				}
			}
		} else {
			List<String> songs = new ArrayList<>();
			songs.add(song);
			map.put(user, songs);
		}
	}

}
