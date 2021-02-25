package com.sibela.recyclerviewbasic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.character_item.view.*

class CharactersAdapter(private var characters: List<Character> = arrayListOf()) :
    RecyclerView.Adapter<CharactersAdapter.Holder>() {

    fun setCharacters(characters: List<Character>) {
        this.characters = characters
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.character_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount() = characters.size

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        private val characterId = view.idText
        private val characterName = view.nameText

        fun bind(character: Character) {
            characterId.text = character.id
            characterName.text = character.name
        }
    }
}
