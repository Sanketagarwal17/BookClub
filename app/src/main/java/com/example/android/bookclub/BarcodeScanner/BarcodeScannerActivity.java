package com.example.android.bookclub.BarcodeScanner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.bookclub.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.vision.face.Landmark;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions;
import com.google.firebase.ml.vision.cloud.landmark.FirebaseVisionCloudLandmark;
import com.google.firebase.ml.vision.cloud.landmark.FirebaseVisionCloudLandmarkDetector;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;
import com.google.firebase.ml.vision.text.RecognizedLanguage;

import org.w3c.dom.Text;

import java.util.List;

public class BarcodeScannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scanner);
    }



    int Barcode_Reader_request_Code=200;




    public void Barcode(View view)
    {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,Barcode_Reader_request_Code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==Barcode_Reader_request_Code)
        {
            if(resultCode==RESULT_OK)
            {
                Bitmap photo=(Bitmap)data.getExtras().get("data");
                BarCodeRecognition(photo);
            }
            else if(requestCode==RESULT_CANCELED)
            {
                Toast.makeText(this,"Operation Cancelled",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"Failed To Take Image",Toast.LENGTH_SHORT).show();
            }
        }

    }



    private void BarCodeRecognition(Bitmap photo)
    {
        FirebaseVisionImage image=FirebaseVisionImage.fromBitmap(photo);

        FirebaseVisionBarcodeDetector detector= FirebaseVision.getInstance().getVisionBarcodeDetector();

        Task<List<FirebaseVisionBarcode>> result=detector.detectInImage(image)
                .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionBarcode>>() {
                    @Override
                    public void onSuccess(List<FirebaseVisionBarcode> Barcodes)
                    {
                        for (FirebaseVisionBarcode barcode: Barcodes) {
                            String rawValue = barcode.getRawValue();
                            Toast.makeText(BarcodeScannerActivity.this,rawValue,Toast.LENGTH_SHORT).show();

                            int valueType = barcode.getValueType();
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BarcodeScannerActivity.this,"Failed To Recognize",Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
