package com.androidopentutorials.imageslideshow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
//import android.util.Log;
import android.view.Menu;

import com.androidopentutorials.imageslideshow.fragment.HomeFragment;
import com.androidopentutorials.imageslideshow.fragment.ProductDetailFragment;

public class MainActivity extends FragmentActivity {

	private Fragment contentFragment;
	HomeFragment homeFragment;
	ProductDetailFragment pdtDetailFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentManager fragmentManager = getSupportFragmentManager();

		if (savedInstanceState != null) {
			if (savedInstanceState.containsKey("content")) {
				String content = savedInstanceState.getString("content");
				if (content.equals(ProductDetailFragment.ARG_ITEM_ID)) {
					if (fragmentManager
							.findFragmentByTag(ProductDetailFragment.ARG_ITEM_ID) != null) {
						contentFragment = fragmentManager
								.findFragmentByTag(ProductDetailFragment.ARG_ITEM_ID);
					}
				}
			}
			if (fragmentManager.findFragmentByTag(HomeFragment.ARG_ITEM_ID) != null) {
				homeFragment = (HomeFragment) fragmentManager
						.findFragmentByTag(HomeFragment.ARG_ITEM_ID);
				contentFragment = homeFragment;
			}
		} else {
			homeFragment = new HomeFragment();
			switchContent(homeFragment, HomeFragment.ARG_ITEM_ID);
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		if (contentFragment instanceof HomeFragment) {
			outState.putString("content", HomeFragment.ARG_ITEM_ID);
		} else {
			outState.putString("content", ProductDetailFragment.ARG_ITEM_ID);
		}
		super.onSaveInstanceState(outState);
	}

	public void switchContent(Fragment fragment, String tag) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		while (fragmentManager.popBackStackImmediate())
			;

		if (fragment != null) {
			FragmentTransaction transaction = fragmentManager
					.beginTransaction();
			transaction.replace(R.id.content_frame, fragment, tag);
			// Only ProductDetailFragment is added to the back stack.
			if (!(fragment instanceof HomeFragment)) {
				transaction.addToBackStack(tag);
			}
			transaction.commit();
			contentFragment = fragment;
		}
	}

	@Override
	public void onBackPressed() {
		FragmentManager fm = getSupportFragmentManager();
		if (fm.getBackStackEntryCount() > 0) {
			super.onBackPressed();
		} else if (contentFragment instanceof HomeFragment
				|| fm.getBackStackEntryCount() == 0) {
			finish();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
