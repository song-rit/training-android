package th.ac.sut.tabbar.actionbar;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import th.ac.sut.tabbar.R;

public class ActionBarExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_example);


        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

    }
}
