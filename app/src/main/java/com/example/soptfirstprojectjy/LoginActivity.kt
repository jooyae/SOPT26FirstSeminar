package com.example.soptfirstprojectjy


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.soptfirstprojectjy.data.RequestLogin
import com.example.soptfirstprojectjy.data.ResponseLogin
import com.example.soptfirstprojectjy.network.RequestToServer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    btn_login.setOnClickListener{
        if(et_id.text.isNullOrBlank()||ed_pwd.text.isNullOrBlank()){
            Toast.makeText(this, "아이디와 비밀번호를 확인하세요",Toast.LENGTH_SHORT).show()
        }else{
            requestToServer.service.requestLogin(
                RequestLogin(
                    id= et_id.text.toString(),
                    password = ed_pwd.text.toString()
                )
            ).enqueue(object : Callback<ResponseLogin> {
                override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ResponseLogin>,
                    response: Response<ResponseLogin>
                ) {
                    if(response.isSuccessful){
                        if(response.body()!!.success){
                            Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }else{

                            Toast.makeText(this@LoginActivity, "아이디/비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show()
                        }
                    }


                }

            })
         }

    }
    }
}
