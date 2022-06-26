package dominando.android.myphoto;


import android.Manifest;
import android.Manifest.permission;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.graphics.Bitmap;
import android.content.Intent;
import android.app.Activity.*;
import android.os.Bundle;
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.Toast;
import android.provider.MediaStore;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.content.PermissionChecker;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;
import static android.provider.MediaStore.EXTRA_OUTPUT;
import static android.provider.MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA;
import static android.webkit.ConsoleMessage.MessageLevel.LOG;


public class MainActivity extends AppCompatActivity {

    ImageView imageViewPhoto;
    private Uri imageUri;
    private Intent intent;

    // private final int REQUEST_IMAGE_CAPTURE = 1;
    private final int GALERIA_IMAGENS = 2;
    // private final int TIRAR_FOTO = 3;
    // private final int FOTOS = 4;
    // private final int EXTERNAL_CONTENT_URI = 5;
    //  private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);

        }

        final ImageView imageViewPhoto = (ImageView) findViewById(R.id.ivImagem);

        findViewById(R.id.btnphoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirafoto();


            }

        });

        findViewById(R.id.btnTakePhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartilhar();

            }
        });

    }

        public void tirafoto () {
            Intent intent = new Intent(ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1);

        }

        public void compartilhar () {
            if (imageViewPhoto.getDrawable() != null) {

               // Intent shareIntent = new Intent();
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               // startActivityForResult(intent, GALERIA_IMAGENS);

                //Intent intent = new Intent(Intent.ACTION_SEND);
               intent.setType("image/jpeg");

               Uri imageSelecionada = intent.getData();

                Intent imageViewPhoto = new Intent(Intent.ACTION_SEND);
                imageViewPhoto.setType("image/*");
                imageViewPhoto.setAction(Intent.ACTION_GET_CONTENT);
                imageViewPhoto.setAction(Intent.ACTION_SEND);

                intent.addFlags (Intent.FLAG_GRANT_READ_URI_PERMISSION);
                /*  AQUI FOI RETIRADO DO PROGRAMA,28/01/2022. ERRO NO imageViewPhoto.getDrawable()

                BitmapDrawable drawable = (BitmapDrawable) imageViewPhoto.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                String path = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap, "imagem", null);
                Uri uri = Uri.parse(path);
                */
                intent.putExtra(Intent.EXTRA_STREAM, imageUri);
                startActivity(Intent.createChooser(intent, "Compartilhar"));
               // imageViewPhoto.setAction(Intent.ACTION_SEND);
          }

        }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            if (requestCode == 1 && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imagem = (Bitmap) extras.get("data");

                ImageView imageViewPhoto = (ImageView) findViewById(R.id.ivImagem);
                imageViewPhoto.setImageBitmap(imagem);
            }
            super.onActivityResult(requestCode, resultCode, data);
        }

}





