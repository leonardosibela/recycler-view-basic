package com.sibela.recyclerviewbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CharactersAdapter()
        charactersRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        val characters = getCharacters()
        adapter.setCharacters(characters)
    }

    fun getCharacters(): List<Character> {
        return arrayListOf(
            Character("1", "Spider Man"),
            Character("2", "Iron Man"),
            Character("3", "Hulk"),
            Character("4", "Captain America"),
            Character("5", "Thanos"),
            Character("6", "Wolverine"),
            Character("7", "Deadpool"),
            Character("8", "Dr. Strange"),
            Character("9", "Black Widow"),
            Character("10", "Thor"),
            Character("11", "Vision"),
            Character("12", "Nick Fury"),
            Character("13", "Venom"),
            Character("14", "Galactus")
        )
    }
}