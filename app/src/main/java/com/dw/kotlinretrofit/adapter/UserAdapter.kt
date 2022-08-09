package com.dw.kotlinretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dw.kotlinretrofit.model.User

class UserAdapter(var mList: List<User>) : RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.text.setText(mList.get(position).name)
      holder.text1.setText(mList.get(position).email)
    }

    override fun getItemCount(): Int {
       return mList.size
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var text=itemView.findViewById<TextView>(R.id.text)
    var text1=itemView.findViewById<TextView>(R.id.text1)

}