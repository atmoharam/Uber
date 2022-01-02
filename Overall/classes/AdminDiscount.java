package com.example.demo.application;

import com.example.demo.DataBase.SystemData;
import com.example.demo.core.Ride;

public class AdminDiscount  extends DiscountDecorator {
    Discount dis;

    public AdminDiscount (  ) {

    }

    @Override
    public double getPrice ( ) {
        return price;
    }

    @Override
    public void discount ( Ride r ) {
        if(SystemData.getInstence ().checkDiscount ( r.getDistination () )==true||
                SystemData.getInstence ().checkDiscount ( r.getSource ())==true)
        {
            price*=0.9;
        }
    }
}
