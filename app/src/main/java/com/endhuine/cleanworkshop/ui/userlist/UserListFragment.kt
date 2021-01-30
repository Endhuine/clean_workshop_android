package com.endhuine.cleanworkshop.ui.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.endhuine.cleanworkshop.databinding.FragmentUserListBinding
import com.endhuine.cleanworkshop.ui.userlist.adapter.UserAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * A [Fragment] that display a list of users
 */
@AndroidEntryPoint
class UserListFragment() : Fragment() {

    private val viewModel: UserListViewModel by viewModels()

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    private val userAdapter = UserAdapter {
        //Mock navigation
        findNavController().navigate(UserListFragmentDirections.actionFirstFragmentToSecondFragment(it.id))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvUserList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userAdapter
        }

        viewModel.userList.observe(viewLifecycleOwner, Observer { userList ->
            userAdapter.users = userList
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}