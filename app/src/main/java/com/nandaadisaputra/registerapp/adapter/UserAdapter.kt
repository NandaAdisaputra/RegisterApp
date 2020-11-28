package com.nandaadisaputra.registerapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nandaadisaputra.registerapp.R
import com.nandaadisaputra.registerapp.model.UserModel
import kotlinx.android.synthetic.main.item_user.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class UserAdapter (var list: List<UserModel>?) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            itemView.textViewResult.text = list?.get(position)?.name

            itemView.onClick {
                itemView.context.toast("Hallo Asroi")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    fun setListOfUser(list: List<UserModel>?){
        this.list = list
        notifyDataSetChanged()
    }

}