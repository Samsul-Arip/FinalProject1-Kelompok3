package com.samsul.finalproject1;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.ImageView;

public class ViewDialog {

    public void showDialog(Activity activity, String message) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.view_dialog_add);

        ImageView close = dialog.findViewById(R.id.imgClose);
        close.setOnClickListener(v -> {
            dialog.dismiss();
        });

        dialog.show();
    }
}
