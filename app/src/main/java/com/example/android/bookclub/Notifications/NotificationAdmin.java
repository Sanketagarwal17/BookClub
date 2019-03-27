package com.example.android.bookclub.Notifications;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.bookclub.R;

public class NotificationAdmin extends AppCompatActivity {

    EditText title,message;
    Button send;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_admin);

        title=findViewById(R.id.notificationtitle);;
        message=findViewById(R.id.notificationdescription);
        send=findViewById(R.id.send);

     final String notificationtitle=title.getText().toString().trim();
     final String notificationdescription=message.getText().toString().trim();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder=(NotificationCompat.Builder) new NotificationCompat.Builder(NotificationAdmin.this)
                        .setSmallIcon(R.drawable.ic_facebook).setContentTitle(notificationtitle).setContentText(notificationdescription);

                NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,mBuilder.build());

            }
        });

    }
}
