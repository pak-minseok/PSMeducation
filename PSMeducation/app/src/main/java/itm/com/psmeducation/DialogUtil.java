package itm.com.psmeducation;

/**
 * Created by park min seok on 2015-10-10.
 */
import android.app.ProgressDialog;
import android.content.Context;

public class DialogUtil { //dialog ���� ��

    public static void timeThread(Context context) {

        final ProgressDialog dialog = new ProgressDialog(context);
        dialog.setTitle("실행...");
        dialog.setMessage("로딩 중 입니다.");
        dialog.setIndeterminate(true);
        dialog.setCancelable(true);
        dialog.show();
        new Thread(new Runnable() {
            public void run() {
                // TODO Auto-generated method stub
                try {
                    Thread.sleep(2000);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
                dialog.dismiss();
            }
        }).start();
    }
}

