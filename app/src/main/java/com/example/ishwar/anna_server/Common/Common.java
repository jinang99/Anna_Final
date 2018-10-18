package com.example.ishwar.anna_server.Common;

import com.example.ishwar.anna_server.User;

public class Common {
    public static User currentUser;
    public static final String UPDATE = "Update";
    public static final String DELETE = "Delete";
    public static final int PICK_IMAGE_REQUEST = 71;

    public static String convertCdeToStatus(String code)
    {
        if(code.equals("0"))
            return "Order Confirmed";
        else if(code.equals("1"))
            return "On the way";
        else
            return "Delivered";
    }
}
