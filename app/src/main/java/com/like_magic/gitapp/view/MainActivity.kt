package com.like_magic.gitapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.like_magic.gitapp.R
import com.like_magic.gitapp.databinding.ActivityMainBinding
import com.like_magic.gitapp.domain.entity.UserEntity

class MainActivity : AppCompatActivity(), UsersContract.MainView {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val userAdapter = UserListAdapter()

    private val presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecyclerView()
        setupBtn()
        setupClickListener()
        presenter.attach(this)
        presenter.loadData()
    }

    private fun initRecyclerView(){
        binding.mainRv.adapter = userAdapter
    }

    private fun setupBtn(){
        binding.reloadBtn.setOnClickListener{
            presenter.loadData()
        }
    }

    private fun setupClickListener(){
        userAdapter.clickListener ={
            presenter.getUser(it.login)
        }
    }

    override fun navigateToUserPage(userEntity: UserEntity){
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, UserFragment.newInstance(userEntity))
            .addToBackStack(null)
            .commit()
    }

    override fun showUsers(list: List<UserEntity>) {
        userAdapter.submitList(list)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

}