package wasu.com.texttest;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class HotFixActivity extends AppCompatActivity {

    private static final String APATCH_PATH = "/fix.apatch"; // 补丁文件名

    private static final String DOWNLOAD_URL = "http://125.210.141.30/movies/fix.apatch";

    private String PATH;

    private TextView mainTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_fix);
        PATH = Environment.getExternalStorageDirectory().getAbsolutePath();

        mainTv = (TextView) findViewById(R.id.main_tv);
//        mainTv.setText("点击Toast");
        mainTv.setText("加载了补丁之后");
        mainTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast();
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });


        IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                long reference = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                Toast.makeText(getApplication(), "下载完成！！", Toast.LENGTH_LONG).show();

            }
        };
        registerReceiver(receiver, filter);
        downLoad();

    }

    private void update() {
        try {
            String patchFileStr = PATH + APATCH_PATH;
            AndFixApplication.mPatchManager.addPatch(patchFileStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showToast() {
//        Toast.makeText(this, "打补丁之前", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "打补丁之后", Toast.LENGTH_LONG).show();
    }


    /**
     * 下载文件
     */
    public void downLoad() {
        String serviceString = Context.DOWNLOAD_SERVICE;
        DownloadManager downloadManager;
        downloadManager = (DownloadManager) getSystemService(serviceString);

        Uri uri = Uri.parse(DOWNLOAD_URL);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        long reference = downloadManager.enqueue(request);
        request.setTitle("Earthquakes");
        request.setDescription("XML");
        request.allowScanningByMediaScanner();
        request.setVisibleInDownloadsUi(true);
        request.setDestinationUri(Uri.parse(PATH));
        request.setDestinationInExternalPublicDir("/AAAAAAAAA/", "/fix.apatch");
    }

}