package com.senanur.recipeapp.entities.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.senanur.recipeapp.entities.Category
import com.senanur.recipeapp.entities.CategoryItems
import com.senanur.recipeapp.entities.MealsItems

class MealListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<MealsItems>):String? {
        if (category == null) {
            return (null)
        } else {
            val gson = Gson()
            val type = object : TypeToken<MealsItems>() {}.type
            return gson.toJson(category, type)
        }
    }

        @TypeConverter
        fun toCategoryList(categoryString: String): List<MealsItems>? {
            if (categoryString == null) {
                return (null)
            } else {
                val gson = Gson()
                val type = object : TypeToken<MealsItems>() {}.type
                return gson.fromJson(categoryString, type)

            }

        }
    }