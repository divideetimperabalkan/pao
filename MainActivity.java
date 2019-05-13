package com.example.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import android.support.v7.widget.Toolbar;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener  {
   // implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener
   private DrawerLayout drawer;
    private Button b1, b2, b3, b4, b5;
    private SignInButton SignIn;
    private TextView Name;
    protected String n1;
    private GoogleApiClient googleApiClient;
    private GoogleSignInClient mGoogleSignInClient;
    private  int REQ_CODE = 9001;
    private FirebaseAuth mAuth;
    private String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Toolbar toolbar=findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
      //  drawer=findViewById(R.id.drawer_layout);
      //  ActionBarDrawerToggle toogle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
      /// drawer.addDrawerListener(toogle);
      // toogle.syncState();
     //  NavigationView navigationView=findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);



    //    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
             //   .requestIdToken(getString(R.string.default_web_client_id))
             //   .requestEmail()
            //    .build();
       // mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mAuth = FirebaseAuth.getInstance();



     /*   b1 = (Button) findViewById(R.id.b_food);
        b2 = (Button) findViewById(R.id.b_clothes);
        b3 = (Button) findViewById(R.id.b_appliances);
      //  b4 = (Button) findViewById(R.id.b_myprofile);
      //  b5 = (Button) findViewById(R.id.b_faq);

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfaq();
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmyprofile();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openappliancesActivity();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openclothesActivity();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfood1Activity();

            }

            //     private void openfood1Activity() {
            //   Intent intent=new Intent();
            //    startActivity(intent);
            // }
        });   */
        SignIn = (SignInButton) findViewById(R.id.login1);
     //   Name = (TextView) findViewById(R.id.id_name);
      SignIn.setOnClickListener(this);

        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();

        SharedPreferences sharedPreferences = getSharedPreferences("Pr", Context.MODE_PRIVATE);
        String id_token = sharedPreferences.getString("Logged", "Not logged");
        if (id_token == "Not logged") {
          // SignIN();

        } else {
            SignIn.setVisibility(View.GONE);
            //Name.setText(id_token);


        }

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    private void SignIN() {
        //Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent, REQ_CODE);


    }
    protected void openfaq() {
        Intent intent = new Intent(this, faq.class);

        startActivity(intent);


    }


    protected void b1(View view) {
    }

    protected void appliancesb1(View view) {
    }

    protected void openclothesActivity() {
        Intent intent = new Intent(this, clothesActivity.class);
        startActivity(intent);
    }

    protected void openfood1Activity() {
        Intent intent = new Intent(this, food1Activity.class);
        startActivity(intent);
    }

    protected void openappliancesActivity() {
        Intent intent = new Intent(this, appliancesAcitivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
     switch (view.getId()) {
            case R.id.login1:
                SignIN();
                break;


        }

    }






    private void handleresult(GoogleSignInResult result) {

        if (result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            String name = account.getDisplayName();
           // Name.setText(name);
            updateUI(true);
            String id_token = account.getIdToken();
            SharedPreferences sharedPreferences = getSharedPreferences("Pr", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Logged", id_token);
            editor.commit();
            String filename="userinfo.csv";
            String userinfo=account.getDisplayName()+","+account.getEmail()+"\n";
            try {
                FileOutputStream out=openFileOutput(filename,Context.MODE_PRIVATE);
                out.write(userinfo.getBytes());
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {
            updateUI(false);
        }

    }

    private void updateUI(boolean islogin) {
        if (islogin) {
            SignIn.setVisibility(View.GONE);




          Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);


        } else {

            SignIn.setVisibility(View.VISIBLE);

        }

    }

    protected void openmyprofile() {
        Intent intent = new Intent(this, myprofile.class);
       // intent.putExtra("Name", Name.getText().toString()); //numele contului pentru profil

        startActivity(intent);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
               handleresult(result);
// Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);

       /*     Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                // ...
            } */
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

  /*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == REQ_CODE) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                //Log.d(TAG, "signInWithCredential:success");

                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                Name.setText("dd");
               //
                Log.w(TAG, "Google sign in failed", e);

               Toast.makeText(MainActivity.this,"you are not able to log in",Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
                Name.setText(e.toString());

                // Google Sign In failed, update UI appropriately
                // ...
            }
        }
    }
  */


/*
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI2(user);
                        } else {
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity.this,task.getException().toString(),Toast.LENGTH_LONG).show();

                            // If sign in fails, display a message to the user.
                            updateUI2(null);
                        }

                        // ...
                    }
                });
    }

    private void updateUI2(FirebaseUser islogin) {
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getApplicationContext());


        if (acct != null) {
            SignIn.setVisibility(View.GONE);

        } else {

            SignIn.setVisibility(View.VISIBLE);

        }


    }     */
}