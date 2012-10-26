package com.plivo.dialer;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


/**
 * @author Master
 * PlivoDialerActivity is the initial login activity
 * 
 */
public class PlivoDialerLogInActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	private EditText username;
	private EditText password;
	public static Boolean connectivity = false;
	private ConnectivityManager mConnectivityManager;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        Button signinbutton = (Button) findViewById(R.id.signinbutton);
		signinbutton.setOnClickListener(this);
		
        Button signupbutton = (Button) findViewById(R.id.signupbutton);
		signupbutton.setOnClickListener(this);
		
		mConnectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if (mConnectivityManager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
				.isConnectedOrConnecting()
				|| mConnectivityManager.getNetworkInfo(
						ConnectivityManager.TYPE_WIFI)
						.isConnectedOrConnecting()) {
			connectivity = true;
		} else {
			connectivity = false;

		}
		
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (mConnectivityManager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
				.isConnectedOrConnecting()
				|| mConnectivityManager.getNetworkInfo(
						ConnectivityManager.TYPE_WIFI)
						.isConnectedOrConnecting()) {
			connectivity = true;
			if(v.getId()==R.id.signinbutton)	{
				Intent intentsignin = new Intent(PlivoDialerLogInActivity.this,
						PlivoDialerActivity.class);
				startActivity(intentsignin);
			}
			if(v.getId()==R.id.signupbutton)	{
				Intent intentsignup = new Intent(Intent.ACTION_VIEW);
				intentsignup.setData(Uri.parse("https://www.plivo.com/accounts/register/"));
				startActivity(intentsignup);
			}
		} else {
			connectivity = false;

		}
		if(v.getId()==R.id.signinbutton)	{
			
		}
		if(v.getId()==R.id.signupbutton)	{
			
		}
		
	}
}