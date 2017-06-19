package com.sprinunna.treasuresocial;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.sprinunna.treasuresocial.Utils.QuoteBank;
import com.sprinunna.treasuresocial.Utils.TextFix;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ftr_information extends AppCompatActivity {
    private QuoteBank mQuoteBank = null;
    private List<String> mLines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftr_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final String path = "welcome.docx";

        ((TextView)findViewById(R.id.title)).setText("");
        ((TextView)findViewById(R.id.body)).setText("");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mQuoteBank = new QuoteBank(ftr_information.this);
                mLines = mQuoteBank.readLine(path);
                String text = "";
                if (mLines.size() > 0)
                {
                    ((TextView)findViewById(R.id.title)).setText(mLines.get(0));
                    for (int i = 0; i < mLines.size(); i++)
                    {
                        if(i != 0) {
                            Log.d("TAG", mLines.get(i));
                            text += mLines.get(i);
                            text = TextFix.Fix(text);
                        }
                    }
                    ((TextView)findViewById(R.id.body)).setText(text);
                }
            }
        }, 500);
    }
}
