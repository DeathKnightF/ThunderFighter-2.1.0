package Demo.Data;

public class PlayerData {
	private static int id;
	private static volatile PlayerData playerData;
	private PlayerData() {
		
	}
	public static PlayerData getPlayerData() {
		if(playerData!=null)
			return playerData;
		synchronized (PlayerData.class) {
			if(playerData==null)
				playerData=new PlayerData();
		}
		return playerData;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		PlayerData.id = id;
	}
	
}
