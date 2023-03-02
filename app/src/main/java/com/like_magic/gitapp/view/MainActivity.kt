package com.like_magic.gitapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.like_magic.gitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    val userAdapter = UserListAdapter()

    private val presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecyclerView()
        presenter.setList()
        setupBtn()
    }

    private fun initRecyclerView(){
        binding.mainRv.adapter = userAdapter
    }

    private fun setupBtn(){
        binding.reloadBtn.setOnClickListener{
            presenter.setList()
        }
    }
}