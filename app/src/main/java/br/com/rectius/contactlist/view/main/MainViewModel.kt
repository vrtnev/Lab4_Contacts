package br.com.rectius.contactlist.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.rectius.contactlist.model.Contact
import br.com.rectius.contactlist.repository.ContactRepository

class MainViewModel : ViewModel() {

    val contactRepository = ContactRepository()

    val contacts : MutableLiveData<List<Contact>> = MutableLiveData()
    val mensagemErro : MutableLiveData<String> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()


    fun buscarTodos () {
        isLoading.value = true
        contactRepository.getAll(
            onComplete = {
                isLoading.value = false
                contacts.value = it

            },
            onError = {
                isLoading.value = false
                mensagemErro.value = it?.message
            }
        )
    }

}