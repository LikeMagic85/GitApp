package com.like_magic.gitapp.view


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.like_magic.gitapp.databinding.ItemRepoBinding
import com.like_magic.gitapp.domain.entity.UserRepoEntity

class RepoListAdapter : ListAdapter<UserRepoEntity, RepoViewHolder>(RepoDiffCallback()) {

    var clickListener: ((UserRepoEntity) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = ItemRepoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val userRepo = getItem(position)
        with(holder) {
            with(binding) {
                repoName.text = userRepo.name
                root.setOnClickListener {
                    clickListener?.invoke(userRepo)
                }
            }
        }
    }
}
