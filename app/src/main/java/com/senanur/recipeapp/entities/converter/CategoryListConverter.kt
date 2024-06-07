package com.senanur.recipeapp.entities.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.senanur.recipeapp.entities.CategoryItems

class CategoryListConverter {
    @TypeConverter
    fun fromCategoryItemsList(categoryItems: List<CategoryItems>?): String? {
        if (categoryItems == null) {
            return null
        } else {
            val gson = Gson()
            val type = object : TypeToken<List<CategoryItems>>() {}.type
            return gson.toJson(categoryItems, type)
        }
    }

    @TypeConverter
    fun toCategoryItemsList(categoryItemsString: String?): List<CategoryItems>? {
        if (categoryItemsString == null) {
            return null
        } else {
            val gson = Gson()
            val type = object : TypeToken<List<CategoryItems>>() {}.type
            return gson.fromJson(categoryItemsString, type)
        }
    }
}
