package com.sprinunna.treasuresocial;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.sprinunna.treasuresocial.Utils.Account;
import com.sprinunna.treasuresocial.Utils.BackgroundWorker;

public class Login extends AppCompatActivity {

    public static Login inst;
    EditText userInput;
    EditText passInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inst = this;
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        userInput = (EditText)findViewById(R.id.username_input);
        passInput = (EditText)findViewById(R.id.password_input);
    }

    public void OnLogin(View view){
        HideInputMothod();
        final String user = userInput.getText().toString();
        final String pass = passInput.getText().toString();

        userInput.setText(null);
        passInput.setText(null);
        ShowHideProgressBar("true");

        if(user.equals("admin") && pass.equals("admin"))
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Account acc = new Account();
                    acc.Set(user, pass, Account.AccountType.Admin, "admin@sprinunna.com", "https://imagineacademy.microsoft.com/content/images/microsoft-img.png");
                    Account.Save(acc);
                    startActivity(new Intent(Login.this, home.class));
                    ShowHideProgressBar("false");
                    finish();
                }
            }, 3000);

        }
        else
        {
            String type = "login";
            BackgroundWorker bw = new BackgroundWorker(this);
            bw.execute(type, user, pass);
        }
    }
    public void Skip (View view) {
        HideInputMothod();
        ShowHideProgressBar("true");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Account acc = new Account();
                acc.Set("guest", "", Account.AccountType.Guest, "<< guest account >>", "https://hividy.com/images/user.png");
                Account.Save(acc);
                startActivity(new Intent(Login.this, home.class));
                finish();
            }
        }, 5000);
    }

    public void HideInputMothod()
    {
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(passInput.getWindowToken(), 0);
    }

    public void ShowHideProgressBar(String show) {
        switch (show)
        {
            case "true":
                findViewById(R.id.skip_input).setVisibility(View.GONE);
                userInput.setVisibility(View.GONE);
                passInput.setVisibility(View.GONE);
                findViewById(R.id.login_input).setVisibility(View.GONE);
                findViewById(R.id.loadingLayout).setVisibility(View.VISIBLE);

                break;
            case "false":
                findViewById(R.id.loadingLayout).setVisibility(View.GONE);
                userInput.setVisibility(View.VISIBLE);
                passInput.setVisibility(View.VISIBLE);
                findViewById(R.id.login_input).setVisibility(View.VISIBLE);
                findViewById(R.id.skip_input).setVisibility(View.VISIBLE);
                break;
        }
    }
}
