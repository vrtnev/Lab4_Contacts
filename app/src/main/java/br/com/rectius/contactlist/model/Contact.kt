package br.com.rectius.contactlist.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Contact(
    @SerializedName("_id") val id: String? = null,
    val name: String,
    val email: String,
    @SerializedName("phone") val phone : Phone
) : Serializable
