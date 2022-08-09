package com.dw.kotlinretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dw.kotlinretrofit.model.Animal

class MyAdapter(var mList: List<Animal>) : RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.designone, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.text.setText(mList.get(position).title)
      holder.text1.setText(mList.get(position).body)
    }

    override fun getItemCount(): Int {
       return mList.size
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var text=itemView.findViewById<TextView>(R.id.text)
    var text1=itemView.findViewById<TextView>(R.id.text1)

}