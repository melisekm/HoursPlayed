package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessHook {

	public boolean isProcessRunning(String process) {
		String line;
		String pidInfo = "";
		Process p;
		
		try {
			p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

			while ((line = input.readLine()) != null) {
				pidInfo += line;
			}

			input.close();
		} catch (IOException e) {
			System.out.println("CHYBA PRI OTVARANI TASKLIST.EXE");
			//e.printStackTrace();
		}
		if (pidInfo.contains(process))
			return true;
		return false;
	}


}
