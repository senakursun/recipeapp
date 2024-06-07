package com.senanur.recipeapp

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.senanur.recipeapp.adapter.MainCategoryAdapter
import com.senanur.recipeapp.adapter.SubCategoryAdapter
import com.senanur.recipeapp.database.RecipeDatabase
import com.senanur.recipeapp.entities.CategoryItems
import com.senanur.recipeapp.entities.MealsItems
import com.senanur.recipeapp.entities.Recipes
import kotlinx.android.synthetic.main.activity_home.rv_main_category
import kotlinx.android.synthetic.main.activity_home.rv_sub_category
import kotlinx.android.synthetic.main.activity_home.tvCategory
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {
    var arrMainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<MealsItems>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        getDataFromDb()

        mainCategoryAdapter.setClickListener(onClicked)
        subCategoryAdapter.setClickListener(onClickedSubItem)




    }

    private val onClicked = object :MainCategoryAdapter.OnItemClickListener{
        override fun onClicked(categoryName: String) {
            getMealDataFromDb(categoryName)
        }
    }
    private val onClickedSubItem = object :SubCategoryAdapter.OnItemClickListener{
        override fun onClicked(id:String) {
            var intent = Intent(this@HomeActivity,DetailActivity::class.java)
            intent.putExtra("id",id)
            startActivity(intent)
        }
    }

    private fun getDataFromDb(){
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                arrMainCategory = cat as ArrayList<CategoryItems>
                arrMainCategory.reverse()

                getMealDataFromDb(arrMainCategory[0].strCategory)
                mainCategoryAdapter.setData(arrMainCategory)
                rv_main_category.layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
                rv_main_category.adapter = mainCategoryAdapter

            }

        }
    }
    private fun getMealDataFromDb(categoryName:String){
        tvCategory.text ="$categoryName Category"
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getSpecificMealList(categoryName)
                arrSubCategory = cat as ArrayList<MealsItems>
                subCategoryAdapter.setData(arrSubCategory)
                rv_sub_category.layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
                rv_sub_category.adapter = subCategoryAdapter

            }

        }
    }

}