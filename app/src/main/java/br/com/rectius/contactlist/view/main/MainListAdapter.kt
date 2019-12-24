package br.com.rectius.contactlist.view.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.rectius.contactlist.R
import br.com.rectius.contactlist.model.Contact
import kotlinx.android.synthetic.main.contact_item.view.*

class MainListAdapter(
    val context: Context,
    val contacts: List<Contact>,
    val clickLista: (Contact) -> Unit
) :
    RecyclerView.Adapter<MainListAdapter.ContactViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactViewHolder {

        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.contact_item, p0, false)

        return ContactViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(p0: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        p0.bindView(contact, clickLista)
    }


    class ContactViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindView(
            contact: Contact,
            clickLista: (Contact) -> Unit
        ) = with(itemView) {
            tvName.text = contact.name
            tvEmail.text = contact.email
            tvPhoneWork.text = contact.phone.work
            tvPhoneMobile.text = contact.phone.mobile

            setOnClickListener { clickLista(contact) }
        }

    }
}