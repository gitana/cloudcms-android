package com.cloudcms.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import org.gitana.platform.client.AuthInfo;
import org.gitana.platform.client.Gitana;
import org.gitana.platform.client.support.DriverContext;

public class HelloWorldActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        try {
            Gitana gitana = new Gitana("676e3450-6131-46c2-99cc-496aa2ad80fa",
                    "5fGkvesH/tWEMX6SpevL54rY6iJK5ADzLH963sif2ljrWvFOhV2zXv6rSpLF2uMWlJ9SG0uEO9uQO4JZac0i7DZquA/5W8ixJwhj76g0Ksk=");

            // authenticate
            gitana.authenticate("demo", "demo");

            // check driver properties
            AuthInfo authInfo = DriverContext.getDriver().getAuthInfo();

            // print out some things about the principal
            TextView text = new TextView(this);
            text.setText("Hello " + authInfo.getPrincipalName() + ", Welcome to Cloud CMS!");
            setContentView(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
