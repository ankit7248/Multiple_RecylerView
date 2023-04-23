package com.example.multiple_recylerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiple_recylerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mList : ArrayList<DataItems>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecyclerView.setHasFixedSize(true)
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)

        mList = ArrayList()
        prepareData()

        val adapter = MainAdapter(mList)
        binding.mainRecyclerView.adapter = adapter
    }

    private fun prepareData() {
        //bestSeller
        val bestSellerList = ArrayList<RecyclerItem>()

        bestSellerList.add(RecyclerItem(R.drawable.bestseller,"Upto 20% off"))
        bestSellerList.add(RecyclerItem(R.drawable.gadgets1,"Upto 20% off"))
        bestSellerList.add(RecyclerItem(R.drawable.gadgets2,"Upto 20% off"))
        bestSellerList.add(RecyclerItem(R.drawable.bags,"Upto 20% off"))
        bestSellerList.add(RecyclerItem(R.drawable.bags,"Upto 20% off"))
        bestSellerList.add(RecyclerItem(R.drawable.bags,"Upto 20% off"))

        //Clothing
        val ClothingList = ArrayList<RecyclerItem>()

        ClothingList.add(RecyclerItem(R.drawable.clothing,"Upto 20% off"))
        ClothingList.add(RecyclerItem(R.drawable.clothing1,"Upto 20% off"))
        ClothingList.add(RecyclerItem(R.drawable.clothing2,"Upto 20% off"))
        ClothingList.add(RecyclerItem(R.drawable.bags,"Upto 20% off"))
        ClothingList.add(RecyclerItem(R.drawable.bags,"Upto 20% off"))
        ClothingList.add(RecyclerItem(R.drawable.bags,"Upto 20% off"))

        mList.add(DataItems(DataItemtype.BEST_SELLER, bestSellerList))
        mList.add(DataItems(DataItemtype.BANNER, Banner(R.drawable.banner)))
        mList.add(DataItems(DataItemtype.CLOTHING, ClothingList))
        mList.add(DataItems(DataItemtype.BANNER, Banner(R.drawable.banner)))
        mList.add(DataItems(DataItemtype.BEST_SELLER, bestSellerList.asReversed()))
        mList.add(DataItems(DataItemtype.BANNER, Banner(R.drawable.banner)))
    }
}