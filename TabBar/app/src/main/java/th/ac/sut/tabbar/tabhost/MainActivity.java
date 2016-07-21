package th.ac.sut.tabbar.tabhost;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import th.ac.sut.tabbar.R;
import th.ac.sut.tabbar.tabhost.Tab1;
import th.ac.sut.tabbar.tabhost.Tab2;
import th.ac.sut.tabbar.tabhost.Tab3;

public class MainActivity extends AppCompatActivity {


    private LocalActivityManager localActivityManager;
    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localActivityManager = new LocalActivityManager(this, false);
        localActivityManager.dispatchCreate(savedInstanceState);



        infixView();

        tabHost.setup(localActivityManager);

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tab1")
                .setIndicator("Jame")
                .setContent(new Intent(this, Tab1.class));

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2")
                .setIndicator("Jib")
                .setContent(new Intent(this, Tab2.class));

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab2")
                .setIndicator("Jib")
                .setContent(new Intent(this, Tab3.class));

        tabHost.addTab(tabSpec);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);
    }

    private void infixView() {

         tabHost = (TabHost) findViewById(R.id.tab_host);

    }

    @Override
    protected void onPause() {
        super.onPause();
        localActivityManager.dispatchPause(!isFinishing());
    }

    @Override
    protected void onResume() {
        super.onResume();
        localActivityManager.dispatchResume();
    }
}
