package com.sprinunna.treasuresocial.Utils;

import java.util.Random;

/**
 * Created by SinpaiKun on 6/13/2017.
 */

public class NetworkCheck
{
    public static String getURL()
    {
        String[] ips = new String[]{
                "http://www.sprinunna.com/android",
                "http://10.1.10.100/android",
                "http://10.0.2.2/android"
        };
        Random r = new Random();
        int num = r.nextInt((ips.length-1) - 0 + 1) + 0;

        return ips[1];
    }
}
