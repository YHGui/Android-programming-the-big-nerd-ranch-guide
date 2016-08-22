package com.baymini.katsura.criminallntent;

import android.support.v4.app.Fragment;

/**
 * Created by Katsura on 2016-04-12.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
