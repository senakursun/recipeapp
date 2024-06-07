package com.senanur.recipeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.senanur.recipeapp.dao.RecipeDao
import com.senanur.recipeapp.entities.Category
import com.senanur.recipeapp.entities.CategoryItems
import com.senanur.recipeapp.entities.Meal
import com.senanur.recipeapp.entities.MealsItems
import com.senanur.recipeapp.entities.Recipes
import com.senanur.recipeapp.entities.converter.CategoryListConverter
import com.senanur.recipeapp.entities.converter.MealListConverter

@Database(entities = [Recipes::class, CategoryItems::class, Category::class, Meal::class, MealsItems::class], version = 1, exportSchema = false)
@TypeConverters(CategoryListConverter::class, MealListConverter:: class)
abstract class RecipeDatabase:RoomDatabase() {


    companion object {
        var recipesDatabase: RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase {
            if (recipesDatabase == null) {
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!

        }
    }
    abstract fun recipeDao():RecipeDao
}