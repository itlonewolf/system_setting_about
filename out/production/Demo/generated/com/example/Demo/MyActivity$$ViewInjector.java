// Generated code from Butter Knife. Do not modify!
package com.example.Demo;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MyActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.Demo.MyActivity target, Object source) {
    View view;
    view = finder.findById(source, 2131034112);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131034112' for field 'mPhoneNum' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.mPhoneNum = (android.widget.EditText) view;
    view = finder.findById(source, 2131034113);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131034113' for field 'mSendMsg' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.mSendMsg = (android.widget.Button) view;
    view = finder.findById(source, 2131034115);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131034115' for field 'mMakeACall' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.mMakeACall = (android.widget.Button) view;
    view = finder.findById(source, 2131034116);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131034116' for field 'mCallRecode' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.mCallRecode = (android.widget.Button) view;
    view = finder.findById(source, 2131034117);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131034117' for field 'mConfirmWifi' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.mConfirmWifi = (android.widget.Button) view;
  }

  public static void reset(com.example.Demo.MyActivity target) {
    target.mPhoneNum = null;
    target.mSendMsg = null;
    target.mMakeACall = null;
    target.mCallRecode = null;
    target.mConfirmWifi = null;
  }
}
