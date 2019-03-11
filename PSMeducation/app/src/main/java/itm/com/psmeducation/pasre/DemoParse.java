package itm.com.psmeducation.pasre;

import android.app.Application;
import com.parse.Parse;

public class DemoParse extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "H4shLUs5Dlm8m6RPYQ7z4h1sWos12Xo5BPhhysNK", "5UuYOJqgFMfg1v4tuadTnF2LxxSgNCVncGWhyIpL"); }
}
