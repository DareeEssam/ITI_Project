package com.example.iti_project.core.model.response

import com.example.iti_project.core.model.Support
import com.example.iti_project.core.model.Users
import com.google.gson.annotations.SerializedName

data class ResponseUsersList(

    @SerializedName("page")
    var page:Int,

    @SerializedName("per_page")
    var perPage:Int,

    @SerializedName("total")
    var total:Int,

    @SerializedName("total_pages")
    var totalPages:Int,

    @SerializedName("data")
    var data:List<Users>,

    @SerializedName("support")
    var support: Support
)
{

}