// Generated by view binder compiler. Do not edit!
package com.example.colorapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.colorapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHsvBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final SeekBar Hbar;

  @NonNull
  public final TextView Htextview;

  @NonNull
  public final SeekBar Sbar;

  @NonNull
  public final TextView Stextview;

  @NonNull
  public final SeekBar Vbar;

  @NonNull
  public final TextView Vtextview;

  @NonNull
  public final ConstraintLayout frameLayout4;

  private FragmentHsvBinding(@NonNull ConstraintLayout rootView, @NonNull SeekBar Hbar,
      @NonNull TextView Htextview, @NonNull SeekBar Sbar, @NonNull TextView Stextview,
      @NonNull SeekBar Vbar, @NonNull TextView Vtextview, @NonNull ConstraintLayout frameLayout4) {
    this.rootView = rootView;
    this.Hbar = Hbar;
    this.Htextview = Htextview;
    this.Sbar = Sbar;
    this.Stextview = Stextview;
    this.Vbar = Vbar;
    this.Vtextview = Vtextview;
    this.frameLayout4 = frameLayout4;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHsvBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHsvBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_hsv, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHsvBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Hbar;
      SeekBar Hbar = ViewBindings.findChildViewById(rootView, id);
      if (Hbar == null) {
        break missingId;
      }

      id = R.id.Htextview;
      TextView Htextview = ViewBindings.findChildViewById(rootView, id);
      if (Htextview == null) {
        break missingId;
      }

      id = R.id.Sbar;
      SeekBar Sbar = ViewBindings.findChildViewById(rootView, id);
      if (Sbar == null) {
        break missingId;
      }

      id = R.id.Stextview;
      TextView Stextview = ViewBindings.findChildViewById(rootView, id);
      if (Stextview == null) {
        break missingId;
      }

      id = R.id.Vbar;
      SeekBar Vbar = ViewBindings.findChildViewById(rootView, id);
      if (Vbar == null) {
        break missingId;
      }

      id = R.id.Vtextview;
      TextView Vtextview = ViewBindings.findChildViewById(rootView, id);
      if (Vtextview == null) {
        break missingId;
      }

      ConstraintLayout frameLayout4 = (ConstraintLayout) rootView;

      return new FragmentHsvBinding((ConstraintLayout) rootView, Hbar, Htextview, Sbar, Stextview,
          Vbar, Vtextview, frameLayout4);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
