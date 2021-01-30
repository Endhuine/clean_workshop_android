package com.endhuine.cleanworkshop.ui.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.endhuine.cleanworkshop.R
import com.endhuine.cleanworkshop.databinding.FragmentUserDetailBinding
import com.endhuine.cleanworkshop.databinding.FragmentUserListBinding
import com.endhuine.cleanworkshop.ui.user.model.UserDetailModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A [Fragment] that display the detail of a user
 */
@AndroidEntryPoint
class UserDetailFragment : Fragment() {

    private val viewModel: UserDetailViewModel by viewModels()

    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.user.observe(viewLifecycleOwner, Observer { user ->
            bindUser(user)
        })
    }

    private fun bindUser(user: UserDetailModel) {
        Glide.with(this)
            .load(user.avatar)
            .centerCrop()
            .into(binding.ivUserAvatar)

        binding.tvUserName.text = user.name
        binding.tvUserLastName.text = user.lastName
        binding.tvUserEmail.text = user.email
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}