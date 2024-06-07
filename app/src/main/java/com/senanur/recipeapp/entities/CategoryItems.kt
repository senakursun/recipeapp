package com.senanur.recipeapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "categoryitems")

data class CategoryItems(
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "idcategory")
    @Expose
    @SerializedName("idCategory")
    val idCategory: String,

    @ColumnInfo(name = "strcategory")
    @Expose
    @SerializedName("strCategory")
    val strCategory: String,

    @ColumnInfo(name = "strcategorythumb")
    @Expose
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String,

    @ColumnInfo(name = "strcategorydescription")
    @Expose
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String
)


