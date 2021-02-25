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
        setupRecycler()

        resetButton.setOnClickListener { resetRecycler() }
        removeRangeButton.setOnClickListener { removeRange() }
        updateRangeButton.setOnClickListener { updateRange() }
        deleteButton.setOnClickListener { delete() }
        updateButton.setOnClickListener { update() }
        addListButton.setOnClickListener { addRange() }
        addButton.setOnClickListener { add() }

    }

    private fun setupRecycler() {
        adapter = CharactersAdapter()
        charactersRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        resetRecycler()
    }

    private fun resetRecycler() {
        val characters = getCharacters()
        adapter.setCharacters(characters)
        enableButtons()
    }

    private fun enableButtons() {
        resetButton.isEnabled = false
        removeRangeButton.isEnabled = true
        updateRangeButton.isEnabled = true
        addListButton.isEnabled = true
        deleteButton.isEnabled = true
        updateButton.isEnabled = true
        addButton.isEnabled = true
    }

    private fun disableButtons() {
        resetButton.isEnabled = true
        removeRangeButton.isEnabled = false
        updateRangeButton.isEnabled = false
        addListButton.isEnabled = false
        deleteButton.isEnabled = false
        updateButton.isEnabled = false
        addButton.isEnabled = false
    }

    private fun removeRange() {
        adapter.remove(3, 6)
        disableButtons()
    }

    private fun updateRange() {
        adapter.update(3, getSmallList())
        disableButtons()
    }

    private fun delete() {
        adapter.delete(Character("3", "Hulk"))
        disableButtons()
    }

    private fun update() {
        adapter.update(Character("5", "THANOS"))
        disableButtons()
    }

    private fun addRange() {
        adapter.add(getSmallList())
        disableButtons()
    }

    private fun add() {
        adapter.add(Character("15", "Venom"))
        disableButtons()
    }

    private fun getCharacters(): ArrayList<Character> {
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
            Character("12", "Nick Fury")
        )
    }

    private fun getSmallList(): List<Character> {
        return arrayListOf(
            Character("15", "Venom"),
            Character("16", "Galactus")
        )
    }
}
