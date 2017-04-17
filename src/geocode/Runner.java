package geocode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Runner
{
    public static double PI = 3.14159265;
    public static double TWOPI = 2*PI;
    
    public static void main(String[] args) throws Exception{
    	
    ArrayList<Double> lat_array = new ArrayList<Double>();
    ArrayList<Double> long_array = new ArrayList<Double>();

    //This is the polygon bounding box, if you plot it, 
    //you'll notice it is a rough tracing of the parameter of 
    //the state of Florida starting at the upper left, moving 
    //clockwise, and finishing at the upper left corner of florida.

    ArrayList<String> polygon_lat_long_pairs = new ArrayList<String>();
    String file = "data\\ALB_adm0.kml";
    BufferedReader br = new BufferedReader(new BufferedReader(new FileReader(new File(file))));
    String line ;
    
    while((line =br.readLine())!= null){
    	//String [] ll = line.split(",");
    	
    	polygon_lat_long_pairs.add(line);
    	//System.out.println(line);
    }br.close();
    System.out.println(polygon_lat_long_pairs.size());
    //Convert the strings to doubles.       
    for(String s : polygon_lat_long_pairs){
        lat_array.add(Double.parseDouble(s.split(",")[0]));
        System.out.println(s);
        long_array.add(Double.parseDouble(s.split(",")[1]));
    }

    //prints TRUE true because the lat/long passed in is 
    //inside the bounding box.
    System.out.println(coordinate_is_inside_polygon(
    		20.47980354268678,42.00165251308158D, 
            lat_array, long_array));

    //prints FALSE because the lat/long passed in 
    //is Not inside the bounding box.
    System.out.println(coordinate_is_inside_polygon(
    		20.79948945449184,41.62290744322927D, 
            lat_array, long_array));

}
public static boolean coordinate_is_inside_polygon(
    double latitude, double longitude, 
    ArrayList<Double> lat_array, ArrayList<Double> long_array)
{       
       int i;
       double angle=0;
       double point1_lat;
       double point1_long;
       double point2_lat;
       double point2_long;
       int n = lat_array.size();
       
       //System.out.println("from is inside");
       for (i=0;i<n;i++) {
          point1_lat = lat_array.get(i) - latitude;
          point1_long = long_array.get(i) - longitude;
          point2_lat = lat_array.get((i+1)%n) - latitude; 
          //you should have paid more attention in high school geometry.
          point2_long = long_array.get((i+1)%n) - longitude;
          angle += Angle2D(point1_lat,point1_long,point2_lat,point2_long);
       }

       if (Math.abs(angle) < PI)
          return false;
       else
          return true;
}

public static double Angle2D(double y1, double x1, double y2, double x2){
	
   double dtheta,theta1,theta2;

   theta1 = Math.atan2(y1,x1);
   theta2 = Math.atan2(y2,x2);
   dtheta = theta2 - theta1;
   while (dtheta > PI)
      dtheta -= TWOPI;
   while (dtheta < -PI)
      dtheta += TWOPI;

   return(dtheta);
}

public static boolean is_valid_gps_coordinate(double latitude, 
    double longitude)
{
    //This is a bonus function, it's unused, to reject invalid lat/longs.
    if (latitude > -90 && latitude < 90 && 
            longitude > -180 && longitude < 180)
    {
        return true;
    }
    return false;
}
}
