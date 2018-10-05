package feuerwehrfitness.de.feuerwehrfitnessproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class StartActivity extends AppCompatActivity  {

    private EditText usernameLogin;
    private EditText passwordLogin;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        usernameLogin = (EditText)findViewById(R.id.Username);
        passwordLogin = (EditText)findViewById(R.id.Password);
        buttonLogin = (Button)findViewById(R.id.LoginButton);

        buttonLogin.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(usernameLogin.getText().toString(), passwordLogin.getText().toString());

            }
        });
    }

    private void validate(String username, String password){

        if((username.equals("manuel")&& password.equals("manuel"))){
            Intent intent = new Intent(StartActivity.this, OverviewActivity.class);
            startActivity(intent);
        }else{
            buttonLogin.setEnabled(false);
        }
    }


}
