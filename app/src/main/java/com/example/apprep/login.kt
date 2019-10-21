package com.example.apprep

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        printKeyHash()
    }

    private fun printKeyHash(){
        try{
            val info = packageManager.getPackageInfo("com.example.apprep", PackageManager.GET_SIGNATURES)
            for(signature in info.signatures){
                val md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray())
                Log.e("KEYHASH", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            }
        }
        catch (e:PackageManager.NameNotFoundException){

        }
        catch (e:NoSuchAlgorithmException){

        }
    }
}
