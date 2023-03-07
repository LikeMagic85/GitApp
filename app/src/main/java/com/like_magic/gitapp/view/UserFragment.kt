package com.like_magic.gitapp.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.like_magic.gitapp.databinding.FragmentUserBinding
import com.like_magic.gitapp.domain.entity.UserEntity
import com.squareup.picasso.Picasso


class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding:FragmentUserBinding
    get() = _binding ?: throw RuntimeException("FragmentUserBinding is null")

    lateinit var user:UserEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user = parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUser(user)
    }

    private fun initUser(userEntity: UserEntity){
        with(binding){
            userIdValue.text = userEntity.id.toString()
            Picasso.get().load(userEntity.avatarUrl).into(userAvatar)
            userLoginValue.text = userEntity.login
        }
    }

    private fun parseArgs(): UserEntity {
        @Suppress("DEPRECATION") val args = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(USER, UserEntity::class.java)
        } else {
            arguments?.getParcelable(USER)
        }
        return args!!
    }

    companion object {

        private const val USER = "user"

        fun newInstance(userEntity: UserEntity) =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(USER, userEntity)
                }
            }
    }
}