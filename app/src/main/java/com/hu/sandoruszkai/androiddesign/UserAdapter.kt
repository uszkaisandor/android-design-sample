package com.hu.sandoruszkai.androiddesign

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hu.sandoruszkai.androiddesign.model.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(
    private var context: Context,
    private var users: List<User>
) : RecyclerView.Adapter<UserAdapter.UserHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): UserHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return UserHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setDataSet(users: List<User>) {
        this.users = users
    }

    override fun onBindViewHolder(holder: UserHolder, p1: Int) {
        val dynamicPosition: Int = holder.adapterPosition
        val user: User = users[dynamicPosition]
        setTexts(holder, user)
        setImage(holder, user)
    }

    @SuppressLint("SetTextI18n")
    private fun setTexts(holder: UserHolder, user: User) {
        holder.firstName?.text = "${user.name.first?.capitalize()} "
        holder.lastName?.text = user.name.last?.capitalize()
        holder.gender?.text = user.gender
    }

    private fun setImage(holder: UserHolder, user: User) {
        holder.profilePicture.let { imageView ->
            Picasso.get().load(user.picture.pictureUrl).into(imageView);
        }
    }

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var firstName: TextView? = itemView.tvItemFirstName
        var lastName: TextView? = itemView.tvItemLastName
        var gender: TextView? = itemView.tvItemGender
        var profilePicture: ImageView = itemView.ivItemAvatar
    }

}