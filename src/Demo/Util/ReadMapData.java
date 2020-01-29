package Demo.Util;

//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;

public class ReadMapData {
	
	public static int[][] readMap(){
//		BufferedReader br=new BufferedReader(
//				new InputStreamReader(
//						new FileInputStream("src//MapData.txt")));
//		LinkedList<String> list=new LinkedList<>();
//		String value=br.readLine();
//		while(value!=null) {
//			list.add(value);
//			value=br.readLine();
//		}
//		int[][] mapData=new int[list.size()][13];
//		int i=0;
//		for(String t:list) {
//			String[] arr=t.split(",");
//			int j=0;
//			for(String t1:arr)
//				mapData[i][j++]=Integer.valueOf(t1.trim());
//			i++;
//		}
//		br.close();
		int[][] mapData= {
				{100 ,100 ,100 ,0   ,0   ,0   ,1   ,0   ,0   ,0   ,0   ,0   ,0},
				{200 ,200 ,200 ,300 ,0   ,0   ,0   ,1   ,0   ,0   ,0   ,0   ,0},
				{300 ,300 ,300 ,300 ,0   ,0   ,0   ,0   ,1   ,0   ,0   ,0   ,0},
				{400 ,400 ,400 ,400 ,400 ,400 ,0   ,1   ,1   ,0   ,0   ,0   ,0},
				{500 ,500 ,500 ,500 ,500 ,500 ,1   ,1   ,1   ,0   ,0   ,0   ,0}
		};
		return mapData;
	}
}
