package com.nikhil.mynewsample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.nikhil.mynewsample.R

class ViewPagerAdapter() :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
    var myAnimeFileName = ArrayList<String>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.ViewPagerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.animation_view, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.ViewPagerViewHolder, position: Int) {
        val myImages = myAnimeFileName[position]
        holder.lottieAnime.setAnimation(myImages)
    }

    override fun getItemCount(): Int {
        return myAnimeFileName.size
    }

    fun updateAnime(fileName: ArrayList<String>){
        myAnimeFileName = fileName
        notifyDataSetChanged()
    }

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var lottieAnime: LottieAnimationView = itemView.findViewById(R.id.lav_loginOne)

    }
}