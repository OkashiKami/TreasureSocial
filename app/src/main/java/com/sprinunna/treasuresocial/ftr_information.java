package com.sprinunna.treasuresocial;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.sprinunna.treasuresocial.Utils.FileManager;
import com.sprinunna.treasuresocial.Utils.QuoteBank;
import com.sprinunna.treasuresocial.Utils.TextFix;

import java.util.ArrayList;
import java.util.List;

public class ftr_information extends AppCompatActivity {
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
                Continue();
            }
        });

        ((TextView)findViewById(R.id.body)).setText(new FileManager(this, "TermsAndCondition").LoadTermsAndConditions());
    }

    private int focus_pos=1;
    boolean canGoNext = false;
    public void Continue()
    {
        View v = findViewById(R.id.pagelayout);
        final ScrollView sview = (ScrollView) v.findViewById(R.id.sview);

        if(!canGoNext)
        {
            sview.post(new Runnable() {
                @Override
                public void run() {
                    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                    //1 for up and 2 for down
                    if(focus_pos==1) {
                        sview.fullScroll(ScrollView.FOCUS_DOWN);

                        fab.setImageDrawable(getResources().getDrawable(R.drawable.next));
                        canGoNext = true;
                    }
                    else {
                        sview.fullScroll(ScrollView.FOCUS_UP);
                        focus_pos=1;
                        fab.setImageDrawable(getResources().getDrawable(R.drawable.more));
                        canGoNext = false;
                    }
                }
            });
        }
        else if(canGoNext)
        {
            new FileManager(this, "FTR_Manager").ActivateFTR();
            GoToLogin();
        }


    }

    private void GoToLogin() {
        startActivity(new Intent(ftr_information.this, Login.class));
        finish();
    }
}
