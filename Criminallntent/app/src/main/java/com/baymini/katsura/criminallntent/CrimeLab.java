package com.baymini.katsura.criminallntent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;


/**
 * Created by Katsura on 2016-04-11.
 */
public class CrimeLab {
    private ArrayList<Crime> mCrimes;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appContext){
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        for(int i = 0;i<100;i++){
            Crime c = new Crime();
            c.setTitle("Crime #" + i );
            c.setSolved(i % 2 == 0);
            mCrimes.add(c);
        }
    }

    public static CrimeLab get(Context c){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for(Crime c: mCrimes){
            if(c.getID().equals(id))
                return  c;
        }
        return null;
    }
}
