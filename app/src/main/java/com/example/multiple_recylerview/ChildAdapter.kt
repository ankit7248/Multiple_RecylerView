package com.example.multiple_recylerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiple_recylerview.databinding.BannerItemBinding
import com.example.multiple_recylerview.databinding.BestsellerItemBinding
import com.example.multiple_recylerview.databinding.ClothingLayoutBinding

open class ChildAdapter(private val viewType: Int, private val recyclerItemList: List<RecyclerItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class BestSellerViewHolder(private val binding: BestsellerItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindBestSellerView(recyclerItem: RecyclerItem){
            binding.bestsellerIv.setImageResource(recyclerItem.image)
            binding.bestSellerText.text = recyclerItem.offer
        }
    }

    inner class ClothingViewHolder(private val binding: ClothingLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindClothingView(recyclerItem: RecyclerItem){
            binding.ClothingIv.setImageResource(recyclerItem.image)
            binding.ClothingText.text = recyclerItem.offer
        }
    }

    override fun getItemViewType(position: Int): Int{
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType){
            DataItemtype.BEST_SELLER ->{
                val binding = BestsellerItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,false
                )
                return BestSellerViewHolder(binding)
            }
            else->
            {
                val binding = ClothingLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,false
                )
                return ClothingViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
       return recyclerItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder){
            is BestSellerViewHolder ->{
                holder.bindBestSellerView(recyclerItemList[position])
            }
            is ClothingViewHolder -> {
                holder.bindClothingView(recyclerItemList[position])
            }
        }
    }

}