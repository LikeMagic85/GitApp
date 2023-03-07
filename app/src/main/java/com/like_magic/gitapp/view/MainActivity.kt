package com.like_magic.gitapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.like_magic.gitapp.R
import com.like_magic.gitapp.databinding.ActivityMainBinding
import com.like_magic.gitapp.domain.entity.UserEntity

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
        setupClickListener()
    }

    private fun initRecyclerView(){
        binding.mainRv.adapter = userAdapter
    }

    private fun setupBtn(){
        binding.reloadBtn.setOnClickListener{
            presenter.setList()
        }
    }

    fun navigateToUserPage(userEntity: UserEntity){
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, UserFragment.newInstance(userEntity))
            .addToBackStack(null)
            .commit()
    }

    private fun setupClickListener(){
        userAdapter.clickListener ={
            presenter.getUser(it.login)
        }
    }


}