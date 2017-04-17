package geocode;

import java.util.ArrayList;

public class MainTest {
	
	public static void main(String [] args) throws Exception{
		Runner r = new Runner();
	boolean res = 	r.is_valid_gps_coordinate(25, -82);
	realTest_for_points_inside();
	System.out.println(res);
	}
	
//@Test
//public void test_lat_long_in_bounds(){
//    Runner r = new Runner();
//    //These make sure the lat/long passed in is a valid gps 
//    //lat/long coordinate.  These should be valid. 
//    assertTrue(r.is_valid_gps_coordinate(25, -82));
//    assertTrue(r.is_valid_gps_coordinate(-25, -82));
//    assertTrue(r.is_valid_gps_coordinate(25, 82));
//    assertTrue(r.is_valid_gps_coordinate(-25, 82));
//    assertTrue(r.is_valid_gps_coordinate(0, 0));
//    assertTrue(r.is_valid_gps_coordinate(89, 179));
//    assertTrue(r.is_valid_gps_coordinate(-89, -179));
//    assertTrue(r.is_valid_gps_coordinate(89.999, 179));
//    //If your bounding box crosses the equator or prime meridian, 
//  //  then you have to test for those situations still work.
//}

public static void realTest_for_points_inside()
{
    ArrayList<Double> lat_array = new ArrayList<Double>();
    ArrayList<Double> long_array = new ArrayList<Double>();
    ArrayList<String> polygon_lat_long_pairs = new ArrayList<String>();
    //upper left tip of florida.
    polygon_lat_long_pairs.add("31.000213,-87.584839");
    polygon_lat_long_pairs.add("31.009629,-85.003052");
    polygon_lat_long_pairs.add("30.726726,-84.838257");
    polygon_lat_long_pairs.add("30.584962,-82.168579");
    polygon_lat_long_pairs.add("30.73617,-81.476441");  
    //upper right tip of florida.
    polygon_lat_long_pairs.add("29.002375,-80.795288");
    polygon_lat_long_pairs.add("26.896598,-79.938355");
    polygon_lat_long_pairs.add("25.813738,-80.059204");
    polygon_lat_long_pairs.add("24.93028,-80.454712");
    polygon_lat_long_pairs.add("24.401135,-81.817017");
    polygon_lat_long_pairs.add("24.700927,-81.959839");
    polygon_lat_long_pairs.add("24.950203,-81.124878");
    polygon_lat_long_pairs.add("26.0015,-82.014771");
    polygon_lat_long_pairs.add("27.833247,-83.014527");
    polygon_lat_long_pairs.add("28.8389,-82.871704");
    polygon_lat_long_pairs.add("29.987293,-84.091187");
    polygon_lat_long_pairs.add("29.539053,-85.134888");
    polygon_lat_long_pairs.add("30.272352,-86.47522");
    polygon_lat_long_pairs.add("30.281839,-87.628784");

    for(String s : polygon_lat_long_pairs){
        lat_array.add(Double.parseDouble(s.split(",")[0]));
        long_array.add(Double.parseDouble(s.split(",")[1]));
    }

    Runner r = new Runner();
    ArrayList<String> pointsInside = new ArrayList<String>();
    pointsInside.add("30.82112,-87.255249");
    pointsInside.add("30.499804,-86.8927");
    pointsInside.add("29.96826,-85.036011");
    pointsInside.add("30.490338,-83.981323");
    pointsInside.add("29.825395,-83.344116");
    pointsInside.add("30.215406,-81.828003");
    pointsInside.add("29.299813,-82.728882");
    pointsInside.add("28.540135,-81.212769");
    pointsInside.add("27.92065,-82.619019");
    pointsInside.add("28.143691,-81.740113");
    pointsInside.add("27.473186,-80.718384");
    pointsInside.add("26.769154,-81.729126");
    pointsInside.add("25.853292,-80.223999");
    pointsInside.add("25.278477,-80.707398");
    pointsInside.add("24.571105,-81.762085");   //bottom tip of keywest
    pointsInside.add("24.900388,-80.663452");
    pointsInside.add("24.680963,-81.366577");

    for(String s : pointsInside)
    {
        r.coordinate_is_inside_polygon(
            Double.parseDouble(s.split(",")[0]), 
            Double.parseDouble(s.split(",")[1]), 
            lat_array, long_array);
    }
}


public void realTest_for_points_outside()
{
    ArrayList<Double> lat_array = new ArrayList<Double>();
    ArrayList<Double> long_array = new ArrayList<Double>();

    ArrayList<String> polygon_lat_long_pairs = new ArrayList<String>();
    //upper left tip, florida.
    polygon_lat_long_pairs.add("31.000213,-87.584839");
    polygon_lat_long_pairs.add("31.009629,-85.003052");
    polygon_lat_long_pairs.add("30.726726,-84.838257");
    polygon_lat_long_pairs.add("30.584962,-82.168579");
    polygon_lat_long_pairs.add("30.73617,-81.476441");
    //upper right tip, florida.
    polygon_lat_long_pairs.add("29.002375,-80.795288");
    polygon_lat_long_pairs.add("26.896598,-79.938355");
    polygon_lat_long_pairs.add("25.813738,-80.059204");
    polygon_lat_long_pairs.add("24.93028,-80.454712");
    polygon_lat_long_pairs.add("24.401135,-81.817017");
    polygon_lat_long_pairs.add("24.700927,-81.959839");
    polygon_lat_long_pairs.add("24.950203,-81.124878");
    polygon_lat_long_pairs.add("26.0015,-82.014771");
    polygon_lat_long_pairs.add("27.833247,-83.014527");
    polygon_lat_long_pairs.add("28.8389,-82.871704");
    polygon_lat_long_pairs.add("29.987293,-84.091187");
    polygon_lat_long_pairs.add("29.539053,-85.134888");
    polygon_lat_long_pairs.add("30.272352,-86.47522");
    polygon_lat_long_pairs.add("30.281839,-87.628784");

    for(String s : polygon_lat_long_pairs)
    {
        lat_array.add(Double.parseDouble(s.split(",")[0]));
        long_array.add(Double.parseDouble(s.split(",")[1]));
    }

    Runner r = new Runner();

    ArrayList<String> pointsOutside = new ArrayList<String>();
    pointsOutside.add("31.451159,-87.958374");
    pointsOutside.add("31.319856,-84.607544");
    pointsOutside.add("30.868282,-84.717407");
    pointsOutside.add("31.338624,-81.685181");
    pointsOutside.add("29.452991,-80.498657");
    pointsOutside.add("26.935783,-79.487915");
    pointsOutside.add("25.159207,-79.916382");
    pointsOutside.add("24.311058,-81.17981");
    pointsOutside.add("25.149263,-81.838989");
    pointsOutside.add("27.726326,-83.695679");
    pointsOutside.add("29.787263,-87.024536");
    pointsOutside.add("29.205877,-62.102052");
    pointsOutside.add("14.025751,-80.690919");
    pointsOutside.add("29.029276,-90.805666");
    pointsOutside.add("-12.606032,-70.151369");
    pointsOutside.add("-56.520716,-172.822269");
    pointsOutside.add("-75.89666,9.082024");
    pointsOutside.add("-24.078567,142.675774");
    pointsOutside.add("84.940737,177.480462");
    pointsOutside.add("47.374545,9.082024");
    pointsOutside.add("25.831538,-1.069338");
    pointsOutside.add("0,0");

    for(String s : pointsOutside){
        r.coordinate_is_inside_polygon(
            Double.parseDouble(s.split(",")[0]),
            Double.parseDouble(s.split(",")[1]), lat_array, long_array);
    }
}
}
//The list of lat/long inside florida bounding box all return true.
//The list of lat/long outside florida bounding box all return false.

