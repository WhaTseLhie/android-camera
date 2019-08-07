package pardillo.john.jv.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "MAIN ACTIVITY";
    private final static int IMAGE_CAPTURE_REQUEST = 100;

    private ImageView iv;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.iv = this.findViewById(R.id.imageView);

        this.iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        this.startActivityForResult(intent, IMAGE_CAPTURE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            this.iv.setImageBitmap(bitmap);
        } catch(Exception e) {
            Log.d("ERROR: ", TAG);
        }
    }
}
