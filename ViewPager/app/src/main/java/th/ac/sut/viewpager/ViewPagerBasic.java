package th.ac.sut.viewpager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import th.ac.sut.viewpager.adapter.MyPagerAdapter;

public class ViewPagerBasic extends FragmentActivity {

    MyPagerAdapter myPagerAdapter;
    ViewPager viewPager;
//    Button buttonNext;
//    Button buttonPrevious;

    final int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_basic);


        infixView();

        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        MyPagerAdapter adapter = myPagerAdapter;
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);

//        buttonNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
//            }
//        });
//
//        buttonPrevious.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
//            }
//        });
    }

    private void infixView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);

    }
}
