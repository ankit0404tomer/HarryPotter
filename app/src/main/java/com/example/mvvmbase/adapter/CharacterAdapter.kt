package com.example.mvvmbase.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmbase.R
import com.example.mvvmbase.model.CharacterList
import kotlinx.android.synthetic.main.character_item_cell.view.*

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    private var characterList: CharacterList? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item_cell, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = characterList?.get(position)?.image?.replace("http", "https")
        Glide.with(holder.itemView.img_character.context).load(movie).into(holder.image)
        holder.character_name.text = characterList?.get(position)?.name
    }

    override fun getItemCount(): Int {
       return characterList?.size!!
    }

    fun setCharacterList(it: CharacterList?) {
        characterList=it
        this.characterList?.let { it1 ->
            notifyItemRangeInserted(
                it1.size,
                characterList!!.size - 1
            )
        }
        notifyDataSetChanged()
    }


    class MyViewHolder(binding: View) : RecyclerView.ViewHolder(binding.rootView) {
        var image: ImageView = binding.findViewById(R.id.img_character)
        var character_name: TextView = binding.findViewById(R.id.txt_name)


    }

}
