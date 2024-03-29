// Generated by view binder compiler. Do not edit!
package com.example.colorapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

  @NonNull
  public final Button saveButtonHSV;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TextView textView9;

  private FragmentHsvBinding(@NonNull ConstraintLayout rootView, @NonNull SeekBar Hbar,
      @NonNull TextView Htextview, @NonNull SeekBar Sbar, @NonNull TextView Stextview,
      @NonNull SeekBar Vbar, @NonNull TextView Vtextview, @NonNull ConstraintLayout frameLayout4,
      @NonNull Button saveButtonHSV, @NonNull TextView textView6, @NonNull TextView textView7,
      @NonNull TextView textView8, @NonNull TextView textView9) {
    this.rootView = rootView;
    this.Hbar = Hbar;
    this.Htextview = Htextview;
    this.Sbar = Sbar;
    this.Stextview = Stextview;
    this.Vbar = Vbar;
    this.Vtextview = Vtextview;
    this.frameLayout4 = frameLayout4;
    this.saveButtonHSV = saveButtonHSV;
    this.textView6 = textView6;
    this.textView7 = textView7;
    this.textView8 = textView8;
    this.textView9 = textView9;
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

      id = R.id.saveButtonHSV;
      Button saveButtonHSV = ViewBindings.findChildViewById(rootView, id);
      if (saveButtonHSV == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      return new FragmentHsvBinding((ConstraintLayout) rootView, Hbar, Htextview, Sbar, Stextview,
          Vbar, Vtextview, frameLayout4, saveButtonHSV, textView6, textView7, textView8, textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
