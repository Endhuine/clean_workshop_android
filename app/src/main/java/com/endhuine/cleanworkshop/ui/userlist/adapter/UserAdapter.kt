package com.endhuine.cleanworkshop.ui.userlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.endhuine.cleanworkshop.databinding.ItemUserBinding
import com.endhuine.cleanworkshop.ui.userlist.model.UserListModel

/**
 * Adapter for rendering a list of [UserListModel]
 */
class UserAdapter(private val onClickListener: (UserListModel) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * The list that will be rendered
     */
    var users = emptyList<UserListModel>()
        set(value) {
            if (value != field) {
                field = value
                notifyDataSetChanged()
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserViewHolder).bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    /**
     * A [RecyclerView.ViewHolder] that binds a [UserListModel]
     */
    inner class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserListModel) {
            binding.tvUserEmail.text = user.email
            Glide.with(binding.ivUserAvatar)
                .load(user.avatar)
                .centerCrop()
                .into(binding.ivUserAvatar)

            binding.root.setOnClickListener { onClickListener(user) }
        }
    }
}