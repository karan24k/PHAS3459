package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import module5.DataPoint;

public class TestDataPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<DataPoint> dataFromURL(String url) throws IOException {
		ArrayList<DataPoint> dataSet = new ArrayList<DataPoint> ();

		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;
		
		
}
