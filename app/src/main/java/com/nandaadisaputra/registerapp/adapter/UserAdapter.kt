package com.nandaadisaputra.registerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nandaadisaputra.registerapp.databinding.ItemUserBinding
import com.nandaadisaputra.registerapp.model.UserModel
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class UserAdapter(var list: List<UserModel>?) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.textViewName.text = list?.get(position)?.name
            binding.textViewNumberParticipant.text = list?.get(position)?.number
            binding.textViewGender.text = list?.get(position)?.gender
            binding.textViewAge.text = list?.get(position)?.age
            binding.textViewDateOfBirth.text = list?.get(position)?.date
            val username = list?.get(position)?.name
            itemView.onClick {
                itemView.context.toast("Hallo $username")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    fun setListOfUser(list: List<UserModel>?) {
        this.list = list
        notifyDataSetChanged()
    }


}