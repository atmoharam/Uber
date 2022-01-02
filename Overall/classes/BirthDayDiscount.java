package com.example.demo.application;

import com.example.demo.DataBase.SystemData;
import com.example.demo.core.Ride;

public class BirthDayDiscount extends DiscountDecorator {
    Discount dis;
    @Override
    public double getPrice ( ) {
        return price;
    }

    @Override
    public void discount ( Ride r ) {
        if(SystemData.getInstence ().getUserById ( r.getUserId () ).getBirthDay ().equals (  r.getRideDate ()))
        {
           price*=0.9;
        }

    }
}
