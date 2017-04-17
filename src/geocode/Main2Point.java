package geocode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main2Point {

	
	public static void main (String [] args) throws Exception{
		
		String file = "C:\\Users\\Alket\\luna\\GeoCode\\data\\kml"; 
		File f = new File(file);
		File[] files = f.listFiles();
		Map<String, List<String>>map = new TreeMap<String, List<String>>();
		
		for(int i = 0; i < files.length; i++){
		 String line; 
		 String filei ="";
		 String countryname = "" ; 
		 BufferedReader br = new BufferedReader(new FileReader(files[i]));
		 List<String>l = new ArrayList<String>();
		 
		 while((line = br.readLine())!= null){
			 //<name>Slovenia</name>
			 if(line.startsWith("<name>")){
				 
				 countryname = line;
				 countryname = countryname.substring(countryname.indexOf(">")+1, countryname.indexOf("</"));
				 
			 }
			 if(!line.startsWith("<")){
			    l.add(line);	 
		     }
			 
			 
		 }br.close();
		 map.put(countryname, l);
		 
		}
		for(String s : map.keySet()){
			System.out.println(s+", "+map.get(s).size());
		}
		
	}
}
