
package net.gsantner.markor.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (Intent.ACTION_SEND.equals(intent.getAction()) && intent.getType() != null) {
            if ("text/plain".equals(intent.getType())) {
                handleSendText(intent.getStringExtra(Intent.EXTRA_TEXT));
            }
        }
        finish();
    }

    private void handleSendText(String text) {
        String prefix = "- ";
        String separator = "  ";
        String content = prefix + text + separator;
        String filePath = "/storage/emulated/0/Documents/markor/jurnal_work.md";
        try {
            FileWriter writer = new FileWriter(new File(filePath), true);
            writer.append(content).append("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
