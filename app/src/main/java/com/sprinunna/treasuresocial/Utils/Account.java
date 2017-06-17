package com.sprinunna.treasuresocial.Utils;

import android.support.annotation.Nullable;
import android.widget.Toast;

import com.sprinunna.treasuresocial.home;

import java.util.Random;

/**
 * Created by SinpaiKun on 6/16/2017.
 */

public class Account {
    public int id;
    public String username, password, email, url;
    public AccountType type;
    public boolean isSet = false;
    public static Account  saved;

    public enum AccountType {Genaral, Admin, Guest};

    public Account() {
        id = new Random().nextInt((100000) - 0 + 1);
    }

    public void Set(String username, String password, AccountType type, String email, String url) {
        this.username = username;
        this.password = password;
        this.email = email;
        this .type = type;
        this.url = url;
    }

    public static void Save(Account acc) {
        saved = acc;
        saved.isSet = true;
    }
    @Nullable
    public static Account Load() {
        if(saved.isSet)
        {
            Toast.makeText(home.inst, "Saved account was found", Toast.LENGTH_LONG).show();
            return saved;
        }
        else return null;
    }
}
