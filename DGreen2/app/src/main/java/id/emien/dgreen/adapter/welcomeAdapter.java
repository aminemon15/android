package id.emien.dgreen.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.emien.dgreen.Models.WelcomeModel;

public class welcomeAdapter extends PagerAdapter {

    private Context mContext;

    public welcomeAdapter(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        WelcomeModel welcomeModel = WelcomeModel.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(welcomeModel.getLayoutResId(),container,false);
        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){
        container.removeView((View)object);
    }

    @Override
    public int getCount(){
        return WelcomeModel.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o){
        return view == o;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        WelcomeModel welcomeModel = WelcomeModel.values()[position];
        return mContext.getString(welcomeModel.getTitleResId());
    }
}
