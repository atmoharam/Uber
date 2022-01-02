package com.example.demo.Controller;

import com.example.demo.DataBase.SystemData;
import com.example.demo.core.DriverInfo;
import com.example.demo.application.DriverService;
import com.example.demo.core.Ride;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
class data
{
    public String x;
    public String y;
    public String l;
    public int z;
    public double w;
}
@RestController
public class DriverController {
    DriverInfo driver=new DriverInfo ();
    @PostMapping("/driver/register")
    public void register( @RequestBody DriverService person){
        driver.add ( person);
    }
    @PostMapping("/driver/login")
    public boolean login( @RequestBody data info){
        return SystemData.getInstence ().checkDataDrivers ( info.x,info.y );
    }
    @PostMapping ("/driver/AddArea")
    public boolean addToFavourate( @RequestBody data area)
    {
        //driver.AddFavourateArea ( area ,driverId);
        List< DriverService >drive=driver.getAll ();
        System.out.println ( drive.size () );
        for ( int i=0;i<drive.size ();i++ )
        {
           // System.out.println ( drive.get ( i ).getUserId () +" "+driverId);
            if(drive.get ( i ).getUserId ().equals ( area.y ))
            {
                SystemData.getInstence ().getDrivers ().get ( i ).setFav ( area.x );
                return true;
            }
        }
        return false;
    }
    @GetMapping("/driver/ratings")
    public ArrayList<Integer> getRating(data driverId) {
        return SystemData.getInstence ().getDriverById ( driverId.x).getRating ();
    }
    @GetMapping("/driver/notify")
    public ArrayList< Ride > Notify( data driverId) {
        return SystemData.getInstence ().getDriverById ( driverId.x).getNotifcation();
    }
    @GetMapping("/driver/listRides")
    public ArrayList<Ride>listRides(data driverId)
    {
        return SystemData.getInstence().getRidesWithName ( driverId.x );
    }
    @PostMapping("/driver/suggestPrice")
    public void SuggestPrice(@RequestBody data info )
    {
        SystemData.getInstence ().getDriverById ( info.x ).setPrice ( info.x, info.y,info.z );
    }
}
