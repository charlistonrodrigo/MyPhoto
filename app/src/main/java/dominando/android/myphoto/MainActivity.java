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
            /*    final Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALERIA_IMAGENS);

                compartilhar();




            /*    public void Compartilhar()
        {

            Bitmap icon = BitmapFactory.decodeResource(getResources(),
                    GALERIA_IMAGENS,         ); //aqui é onde está a sua imagem, e no caso, o nome da imagem que eu estou compartilhando é ImagemStatica.
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("image/jpeg");

            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.TITLE, "COMPARTILHAMENTO MORAIS");
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg"); // note que eu identifico o formato da imagem q estou compartilhando. No caso, jpg.
            Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    values);

           /* OutputStream outstream;
            try {
                outstream = getContentResolver().openOutputStream(uri);
                icon.compress(Bitmap.CompressFormat.JPEG, 100, outstream);
                outstream.close();
            } catch (Exception e) {
                System.err.println(e.toString());
            }

        */



       /*     share.putExtra(Intent.EXTRA_STREAM, uri);
            startActivity(Intent.createChooser(share, "Share Image"));
        }


    });



      /*   findViewById(R.id.btnTakePhoto).setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {


                final Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALERIA_IMAGENS);
     */

        //            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        //            builder.setMessage("Foto").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        //               @Override
        //                public void onClick(DialogInterface dialogInterface, int which) {


        // Intent imageViewPhoto = new Intent(Intent.ACTION_SEND);
        //imageViewPhoto.setType("image/*");
        //imageViewPhoto.setAction(Intent.ACTION_GET_CONTENT);
        //imageViewPhoto.setAction(Intent.ACTION_SEND);
        //imageViewPhoto.putExtra(Intent.EXTRA_STREAM,"Hello");

       // Intent chooser = Intent.createChooser(imageViewPhoto,"Who do you to");
       // startActivityForResult(Intent.createChooser(imageViewPhoto,EXTRA_OUTPUT),1);


        //imageUri = Uri.parse("android.resource://"+ getPackageName() + "/drawable/" + "ic_launcher" +
        //       "" );

                  /*      Intent intent = new Intent();

                        intent.putExtra(Intent.EXTRA_STREAM, imageUri);

                            intent.setType("image/*");
                        startActivity(intent);

                        Uri imageUri = Uri .parse("android.resource://"+ getPackageName()+ "GALERIA_IMAGENS");

                      Intent shareIntent = new Intent();

                        shareIntent.setAction(Intent.ACTION_SEND);
                        shareIntent.putExtra(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                        shareIntent.setType("image/*");
                        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);


                        startActivity(Intent.createChooser(shareIntent,"Share from"));
                   */

      /*          });
                AlertDialog alert = builder.create();



                alert.show();

            }

        });

       */
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
               // BitmapDrawable drawable = (BitmapDrawable) imageViewPhoto.getDrawable();
              //  Bitmap bitmap = drawable.getBitmap();
              //  ByteArrayOutputStream  bytes = new ByteArrayOutputStream();
             //   bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
             //   String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "imagem", null);
             //   Uri uri = Uri.parse(path);
                //shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                //intent.putExtra(Intent.EXTRA_STREAM, uri);
               // startActivity(Intent.createChooser(intent, "Compartilhar"));

                 Uri imageSelecionada = intent.getData();
               // Uri imageUri = Uri .parse("android.resource://"+ getPackageName()+ "GALERIA_IMAGENS");
               // Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               // startActivityForResult(intent, GALERIA_IMAGENS);

                Intent imageViewPhoto = new Intent(Intent.ACTION_SEND);
                imageViewPhoto.setType("image/*");
                imageViewPhoto.setAction(Intent.ACTION_GET_CONTENT);
                imageViewPhoto.setAction(Intent.ACTION_SEND);

                intent.addFlags (Intent.FLAG_GRANT_READ_URI_PERMISSION);

/*              AQUI FOI RETIRADO DO PROGRAMA,28/01/2022. ERRO NO imageViewPhoto.getDrawable()

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





       // });
       // }
        /*


        /*
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALERIA_IMAGENS);
/*

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Foto").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {


        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        Intent chooser = Intent.createChooser(i, "enviar");
        startActivity(chooser);
           }
        });
        AlertDialog alert = builder.create();
        alert.show();

*/



/*

    final ImageButton btnTakePhoto = (ImageButton) findViewById(R.id.btnTakePhoto);
        btnTakePhoto.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, REQUEST_IMAGE_CAPTURE);
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivityForResult(intent, 1);


                            dispatchTakePictureIntent();
                        }
                    }


                });
    }




    public void showCamara(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {

            dispatchTakePictureIntent();

        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                Toast.makeText(this, "camera permission is needed to show the camera preview.",
                        Toast.LENGTH_SHORT).show();
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override

    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grandResults) {
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            if (grandResults[1] == PackageManager.PERMISSION_GRANTED) {

                dispatchTakePictureIntent();

            } else {
                Toast.makeText(this, "Permission was not granted", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grandResults);
        }
    }


    public void dispatchTakePictureIntent() {
        Intent takePictureintent = new Intent("android.media.action.IMAGE_CAPTURE");
       // if (takePictureintent.resolveActivity(getPackageManager()) != null) {



        startActivityForResult(takePictureintent, 1);
   // }

    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            ImageView ivImagem = (ImageView) findViewById(R.id.ivImagem);


            ivImagem.setImageBitmap(imageBitmap);
        }
    }

}

*/
