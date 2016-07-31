package com.example.lsx.trainningmultithread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView  mImageView;
    private Button mLbutton;
    private Button mTbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.mai_image);
        mLbutton = (Button) findViewById(R.id.activity_Lbutton);
        mTbutton = (Button) findViewById(R.id.activity_Tbutton);

        mLbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new LoadImageTask().execute();
            }
        });
        mTbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"this is time wait",Toast.LENGTH_SHORT).show();
            }
        });


    }

    class LoadImageTask extends AsyncTask<Void,Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Void...params) {

            try {
                Thread.sleep(4000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mImageView.setImageBitmap(bitmap);
        }
    }
}
