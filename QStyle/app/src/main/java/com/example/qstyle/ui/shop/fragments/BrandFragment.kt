package com.example.qstyle.ui.shop.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qstyle.R
import com.example.qstyle.ui.shop.ShopItemAdapter

class BrandFragment : Fragment() {

    var titleString = listOf("lamoda","starbucks","coca-cola","shipudim","technodom","sulpak","xiaomi")
    var imagesOfContext = intArrayOf(
        R.drawable.brand_lamoda,
        R.drawable.brand_starbucks,
        R.drawable.brand_cola,
        R.drawable.brand_shipudim,
        R.drawable.brand_technodom,
        R.drawable.brand_sulpak,
        R.drawable.brand_xiaomi
    )
    var descriptionList = listOf("магазин одежды","лучшиий кофе","годовой запас кока-колы","шашлычная номер 1","магазин техники","магазин техники","магазин техники")
    private lateinit var shopItemAdapter: ShopItemAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_brand, container, false)
        shopItemAdapter = activity?.let { ShopItemAdapter(it,imagesOfContext,titleString,descriptionList) }!!
        recyclerView = root.findViewById(R.id.rec_shop_brand)
        recyclerView.adapter = shopItemAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        return root
    }
}