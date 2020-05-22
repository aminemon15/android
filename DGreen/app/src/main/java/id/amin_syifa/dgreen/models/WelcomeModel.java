package id.amin_syifa.dgreen.models;

import id.amin_syifa.dgreen.R;

public enum WelcomeModel {
  FIRSTVIEW(R.string._first, R.layout.welcome_first),
  SECONDVIEW(R.string._second, R.layout.welcome_second),
  THIRDVIEW(R.string._third, R.layout.welcome_third);

  private int mTitleResId;
  private int mLayoutResId;

  WelcomeModel(int titleResId, int layoutResId) {
    mTitleResId = titleResId;
    mLayoutResId = layoutResId;
  }

  public int getTitleResId() {
    return mTitleResId;
  }

  public int getLayoutResId() {
    return mLayoutResId;
  }

}