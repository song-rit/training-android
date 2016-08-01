package th.ac.sut.viewpager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import th.ac.sut.viewpager.adapter.CustomFragmentPagerAdapter;
import th.ac.sut.viewpager.adapter.CustomFragmentStatePagerAdapter;

public class ViewPagerBasic extends AppCompatActivity {

    CustomFragmentPagerAdapter myPagerAdapter;
    ViewPager viewPager;
//    Button buttonNext;
//    Button buttonPrevious;

    final int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_basic);


        infixView();



        PagerAdapter adapter = new CustomFragmentStatePagerAdapter(getSupportFragmentManager());
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
