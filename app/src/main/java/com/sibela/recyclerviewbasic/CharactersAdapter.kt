package com.sibela.recyclerviewbasic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.character_item.view.*

class CharactersAdapter(private var characters: ArrayList<Character> = arrayListOf()) :
    RecyclerView.Adapter<CharactersAdapter.Holder>() {

    fun setCharacters(characters: ArrayList<Character>) {
        this.characters = characters
        notifyDataSetChanged()
    }

    fun delete(character: Character) {
        val index = characters.indexOf(character)
        if (index >= 0) {
            characters.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    fun add(character: Character) {
        characters.add(character)
        notifyItemInserted(characters.size)
    }

    fun update(character: Character) {
        val foundCharacter = characters.find { it.id == character.id }
        if (foundCharacter != null) {
            val index = characters.indexOf(foundCharacter)
            characters.removeAt(index)
            characters.add(index, character)
            notifyItemChanged(index)
        }
    }

    fun add(characters: List<Character>) {
        val oldSize = this.characters.size
        val newSize = oldSize + characters.size
        this.characters.addAll(characters)
        notifyItemRangeInserted(oldSize + 1, newSize)
    }

    fun remove(positionStart: Int, amount: Int) {
        for (position in positionStart..amount) {
            characters.removeAt(position)
        }
        notifyItemRangeRemoved(positionStart, amount)
    }

    fun update(positionStart: Int, characters: List<Character>) {
        val positionEnd = positionStart + characters.size
        for ((i, position) in (positionStart until positionEnd).withIndex()) {
            this.characters.removeAt(position)
            this.characters.add(position, characters[i])
        }
        notifyItemRangeChanged(positionStart, characters.size)
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
