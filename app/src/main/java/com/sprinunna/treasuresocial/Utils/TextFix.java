package com.sprinunna.treasuresocial.Utils;

/**
 * Created by SinpaiKun on 6/19/2017.
 */

public class TextFix {
    public static String Fix (String text){
        text = text.replace(".", ". ");
        text = text.replace("!", "! ");
        text = text.replace("?", "? ");
        return text;
    }
}
