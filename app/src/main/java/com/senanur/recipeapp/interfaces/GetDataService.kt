package com.senanur.recipeapp.interfaces


import com.senanur.recipeapp.entities.Category
import com.senanur.recipeapp.entities.Meal
import com.senanur.recipeapp.entities.MealResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataService {
    @GET("categories.php")
    fun getCategoryList(): Call<Category>

    @GET("filter.php")
    fun getMealList(@Query("c") category: String): Call<Meal>

    @GET("lookup.php")
    fun getSpesificItems(@Query("i") id: String): Call<MealResponse>
}
