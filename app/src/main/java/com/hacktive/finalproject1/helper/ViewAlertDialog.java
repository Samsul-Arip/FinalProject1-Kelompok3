package com.hacktive.finalproject1.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;

import com.hacktive.finalproject1.ui.update.UpdateActivity;
import com.hacktive.finalproject1.database.Notes;

public class ViewAlertDialog {
    public static void showAlertDialog(Context application, Notes data) {
        AlertDialog alertDialog = new AlertDialog.Builder(application).create();
        alertDialog.setTitle("Edit Catatan");
        alertDialog.setMessage("Apakah mau edit catatan!!");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ok", (dialog, which) -> {
            Intent intent = new Intent(application, UpdateActivity.class);
            intent.putExtra("uid", data.getId());
            intent.putExtra(UpdateActivity.CATATAN, data.getDescription());
            application.startActivity(intent);
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cencel", (dialog, which) -> {
            alertDialog.dismiss();
        });
        alertDialog.show();
    }
}
