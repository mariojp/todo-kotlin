package br.com.mariojp.todo.web

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RetrofitFabrica {


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val toDoService = retrofit.create(ToDoService::class.java)


}