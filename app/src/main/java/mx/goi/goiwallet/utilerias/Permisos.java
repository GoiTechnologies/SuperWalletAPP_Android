package mx.goi.goiwallet.utilerias;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class Permisos
{ //classBegin


    public static final int RECORD_PERMISSION_REQUEST_CODE = 1;
    public static final int EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 2;
    public static final int CAMERA_PERMISSION_REQUEST_CODE = 3;
    public static final int ACCESS_FINE_LOCATION_PERMISSION_REQUEST_CODE=4;
    public static final int READ_CONTACTS_PERMISSION_REQUEST_CODE=5;
    public static final int GET_ACCOUNTS_PERMISSION_REQUEST_CODE=6;
    public static final int GET_PHONE_PERMISSION_REQUEST_CODE=7;
    //READ_PHONE_STATE




    private Activity activity;


    public Permisos(Activity activity) {
        this.activity = activity;
    }


    public boolean checkPermissionForTelefono()
    {
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }




    public boolean checkPermissionForRecord()
    {
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.RECORD_AUDIO);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }


//ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.GET_ACCOUNTS}, PERMISSIONS_REQUEST_GET_ACCOUNTS);


    public boolean checkPermissionForAccounts(){
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.GET_ACCOUNTS);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }



    public boolean checkPermissionForExternalStorage(){
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }





    public boolean checkPermissionForCamera(){
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }



    public boolean checkPermissionForContacts(){
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_CONTACTS);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }

    }





    public boolean checkPermissionForLocation(){
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }







    public void requestPermissionForRecord()
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.RECORD_AUDIO)){
            Toast.makeText(activity, "Microphone permission needed for recording. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.RECORD_AUDIO}, RECORD_PERMISSION_REQUEST_CODE);
        }
    }




    public void requestPermissionForExternalStorage()
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            Toast.makeText(activity, "External Storage permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE);
        }
    }



    public void requestPermissionForCamera()
    { //beginMETHOD

        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA))
        {
            Toast.makeText(activity, "Camera permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        }

        else
        {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
        }


    }//endMETHOD





    public void requestPermissionForLocation()
    { //beginMETHOD

        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION))
        {
            Toast.makeText(activity, "Location permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        }

        else
        {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, ACCESS_FINE_LOCATION_PERMISSION_REQUEST_CODE);
        }


    }//endMETHOD




    public void requestPermissionForContacts()
    { //beginMETHOD

        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_CONTACTS))
        {
            Toast.makeText(activity, "Contacts permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        }

        else
        {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_CONTACTS}, READ_CONTACTS_PERMISSION_REQUEST_CODE);
        }


    }//endMETHOD


//ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.GET_ACCOUNTS}, PERMISSIONS_REQUEST_GET_ACCOUNTS);

    public void requestPermissionForAccounts()
    { //beginMETHOD

        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.GET_ACCOUNTS))
        {
            Toast.makeText(activity, "Accounts permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        }

        else
        {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.GET_ACCOUNTS}, GET_ACCOUNTS_PERMISSION_REQUEST_CODE);
        }


    }//endMETHOD




    public void requestPermissionForTelefono()
    { //beginMETHOD

        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_PHONE_STATE))
        {
            Toast.makeText(activity, "Acceso al telefono es necesario. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        }

        else
        {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_PHONE_STATE}, GET_PHONE_PERMISSION_REQUEST_CODE);
        }


    }//endMETHOD



} //classBegin
