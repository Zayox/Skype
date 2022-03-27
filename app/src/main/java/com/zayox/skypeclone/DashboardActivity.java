package com.zayox.skypeclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;


public class DashboardActivity extends AppCompatActivity {

    private EditText codeInput;
    private Button codeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        codeInput = findViewById(R.id.meetingCode);
        codeValidation = findViewById(R.id.btn_join);

        URL serverURL;

        try {
            serverURL = new URL("https://meet.jit.si");
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(serverURL)
                    .build();
            JitsiMeet.setDefaultConferenceOptions(options);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        codeValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    JitsiMeetConferenceOptions m_options = new JitsiMeetConferenceOptions.Builder()
                            .setRoom(codeInput.getText().toString())
                            .build();
                JitsiMeetActivity.launch(DashboardActivity.this, m_options);
            }
        });



    }
}