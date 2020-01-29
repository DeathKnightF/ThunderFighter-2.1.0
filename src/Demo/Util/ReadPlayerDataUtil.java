package Demo.Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReadPlayerDataUtil {
	private BufferedReader br;
	private BufferedWriter bw;
	public int coin=0;
	public int topGrade=0;
	public ReadPlayerDataUtil() {
		try {
			readData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	private void readData() throws IOException {
		br=new BufferedReader(
				new InputStreamReader(
						new FileInputStream("data/PlayerData.txt")));
		String value=br.readLine();
		coin=Integer.parseInt(value);
		value=br.readLine();
		topGrade=Integer.parseInt(value);
		br.close();
	}
	public void writeData() throws IOException {
		bw=new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream("data/PlayerData.txt")));
		bw.write(new String(""+coin+"\n"));
		bw.write(new String(""+topGrade+"\n"));
		bw.flush();
		bw.close();
	}
}
