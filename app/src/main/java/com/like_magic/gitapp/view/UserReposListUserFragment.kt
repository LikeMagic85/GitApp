package com.like_magic.gitapp.view

import android.app.AlertDialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.like_magic.gitapp.databinding.FragmentUserReposListBinding
import com.like_magic.gitapp.databinding.RepoDialogBinding
import com.like_magic.gitapp.domain.entity.UserRepoEntity


class UserReposListUserFragment : Fragment(), UsersContract.UsersRepoFragmentView{

    private var _binding: FragmentUserReposListBinding? = null
    private val binding:FragmentUserReposListBinding
    get() = _binding ?: throw RuntimeException("FragmentUserReposListBinding is null")
    lateinit var list:List<UserRepoEntity>
    private val repoAdapter = RepoListAdapter()
    private var presenter =  Presenter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.attach(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list = parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserReposListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        repoAdapter.clickListener = {
            presenter.getUsersRepo(it.url)
        }
    }

    private fun initList(){
        binding.repoRv.adapter = repoAdapter
        repoAdapter.submitList(list)
    }


    override fun showRepo(userRepoEntity: UserRepoEntity) {
        val builder = AlertDialog.Builder(requireContext())
        val repoBinding = RepoDialogBinding.inflate(requireActivity().layoutInflater)
        repoBinding.repoId.text = userRepoEntity.id.toString()
        repoBinding.repoName.text = userRepoEntity.name
        repoBinding.repoForksCount.text = userRepoEntity.forks.toString()
        builder.setView(repoBinding.root)
        builder.show()
    }

    private fun parseArgs(): List<UserRepoEntity> {
        @Suppress("DEPRECATION") val args = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelableArrayList(LIST_REPO, UserRepoEntity::class.java)
        } else {
            arguments?.getParcelable(LIST_REPO)
        }
        return args!!
    }

    companion object {

        private const val LIST_REPO = "list repo"

        fun newInstance(list:List<UserRepoEntity>) =
            UserReposListUserFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(LIST_REPO, arrayListOf<Parcelable?>().apply {
                        addAll(list)
                    })
                }
            }
    }

}