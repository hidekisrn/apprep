package com.example.apprep

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Intent
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
//import androidx.test.orchestrator.junit.BundleJUnitUtils.getResult
import com.google.android.gms.tasks.Task


//const val RC_SIGN_IN = 123

class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonCadastrar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.

//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestEmail()
//            .build()
//        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//        sign_in_button.setSize(SignInButton.SIZE_WIDE);
//        sign_in_button.setOnClickListener {
//            val signInIntent = mGoogleSignInClient.signInIntent
//            startActivityForResult(signInIntent, RC_SIGN_IN)
//        }
//        val acct = GoogleSignIn.getLastSignedInAccount(this)
//        if (acct != null) {
////            val personName = acct.displayName
////            val personGivenName = acct.givenName
////            val personFamilyName = acct.familyName
////            val personEmail = acct.email
////            val personId = acct.id
////            val personPhoto = acct.photoUrl
//            sign_in_button.visibility = View.GONE
//            textViewNomeGoogle.text = acct.displayName
//            textViewNomeGoogle.visibility = View.VISIBLE
//
//        }
//
//
//        printKeyHash()
    }

//    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            // The Task returned from this call is always completed, no need to attach
//            // a listener.
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            handleSignInResult(task)
//        }
//    }
//
//    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
//        try {
//            val account = completedTask.getResult(ApiException::class.java)
//
//            // Signed in successfully, show authenticated UI.
//            //updateUI(account)
//            sign_in_button.visibility = View.GONE
//            textViewNomeGoogle.text = account?.displayName
//            textViewNomeGoogle.visibility = View.VISIBLE
//
//        } catch (e: ApiException) {
//            // The ApiException status code indicates the detailed failure reason.
//            // Please refer to the GoogleSignInStatusCodes class reference for more information.
//            //Log.w(FragmentActivity.TAG, "signInResult:failed code=" + e.statusCode)
//            //updateUI(null)
//
//            sign_in_button.visibility = View.VISIBLE
//            textViewNomeGoogle.text = ""
//            textViewNomeGoogle.visibility = View.GONE
//        }
//
//    }
//
//    private fun printKeyHash(){
//        try{
//            val info = packageManager.getPackageInfo("com.example.apprep", PackageManager.GET_SIGNATURES)
//            for(signature in info.signatures){
//                val md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray())
//                Log.e("KEYHASH", Base64.encodeToString(md.digest(), Base64.DEFAULT))
//            }
//        }
//        catch (e:PackageManager.NameNotFoundException){
//
//        }
//        catch (e:NoSuchAlgorithmException){
//
//        }
//    }
}
