***
## SOPT FIRST PRACTICE

 1. 회원가입시 LoginActivity로 돌아오기 
 2. 회원가입 성공한 ID와 PW가 입력되어 있도록 구현 
 
 
 - [ ] 수정 내용 
 - findViewByld를 사용하지 않고 Kotlin extension 으로 xml에서 정해준 아이디 값 그대로 불러와주기
 - login 되었으면 로그인 창은 필요없으니 finish() 호출해주기
 

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
        })   }  }  }
