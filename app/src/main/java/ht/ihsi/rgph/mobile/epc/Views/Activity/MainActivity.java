package ht.ihsi.rgph.mobile.epc.Views.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import ht.ihsi.rgph.mobile.epc.R;
import ht.ihsi.rgph.mobile.epc.Utilities.ToastUtility;
import ht.ihsi.rgph.mobile.epc.Utilities.Tools;

public class MainActivity  extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            if (savedInstanceState == null) {
                startActivity(new Intent(this, SplashScreen.class));
            }

            CheckPrefIsUseConnected(false);
        }catch( Exception ex) {
            ToastUtility.LogCat(this, ex);
        }
    }



    public void CheckPrefIsUseConnected(boolean forConnexion) {
        try {
            Boolean checkPrefIsUseConnected = Tools.CheckPrefIsUseConnected(this);
            if (!checkPrefIsUseConnected) {
                cancel = true;
//                btn_AjouteBatiman.setVisibility(View.GONE);
//                tv_CompteUtilisateur.setVisibility(View.GONE);
//                txtHeaderTwo.setVisibility(View.GONE);
//                LLGestionSecurity.setVisibility(View.GONE);
//
//                btn_QuitterApplication.setText(getString(R.string.label_Quit));

                if (forConnexion) {
                    intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                } else {
//                    btn_QuitterApplication.setText(getString(R.string.label_Konekte));
//                    LL_ActionButton.setVisibility(View.GONE);
                }
            } else {
                cancel = false;
//                btn_QuitterApplication.setText(getString(R.string.label_Deconnecter));
//                btn_AjouteBatiman.setVisibility(View.VISIBLE);
//                LL_ActionButton.setVisibility(View.VISIBLE);
//                tv_CompteUtilisateur.setVisibility(View.VISIBLE);
//                txtHeaderTwo.setVisibility(View.VISIBLE);

                //loadDataUser();
            }
        }catch (Exception ex) {
            message = "Erreur :";
            ToastUtility.LogCat("Exception: CheckPrefIsUseConnected :" + message +" / " + ex.toString());
            Tools.AlertDialogMsg(this, message +"\n"+ ex.getMessage());
            ex.printStackTrace();
        }
    }//


    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            final int _keyCode=keyCode;
            final KeyEvent _event=event;
            //e = event;
            //k = keyCode;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("" + getString(R.string.msg_Eske_Ou_Vle_Kite_Vre))
                    .setCancelable(false)
                    .setPositiveButton(""+ getString(R.string.label_Non), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    })
                    .setNegativeButton("" + getString(R.string.label_WI), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            MainActivity.super.onKeyDown(_keyCode, _event);
                            finish();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
            return true;
        }else  if (keyCode == KeyEvent.KEYCODE_HOME){
            return true;
        }else{
            return super.onKeyDown(keyCode, event);
        }
    }//
}
