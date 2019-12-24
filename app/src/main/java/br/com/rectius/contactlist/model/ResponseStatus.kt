package br.com.rectius.contactlist.model

import java.io.Serializable

data class ResponseStatus(
    val sucesso: Boolean,
    val mensagem: String
) : Serializable