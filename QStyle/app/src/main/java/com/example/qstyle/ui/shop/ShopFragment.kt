package com.example.qstyle.ui.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.qstyle.R
import com.example.qstyle.ui.shop.fragments.BrandFragment
import com.example.qstyle.ui.shop.fragments.CartFragment
import com.example.qstyle.ui.shop.fragments.ProductFragment


class ShopFragment : Fragment() {
    private lateinit var navMeowShop: MeowBottomNavigation
    private var brandFragment = BrandFragment()
    private var productFragment = ProductFragment()
    private var cartFragment = CartFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_shop, container, false)
        navMeowShop = root.findViewById(R.id.bnv_shop)
        navMeowShop.add(MeowBottomNavigation.Model(1, R.drawable.ic_hopping_cart))
        navMeowShop.add(MeowBottomNavigation.Model(2, R.drawable.ic_shop))
        navMeowShop.add(MeowBottomNavigation.Model(3, R.drawable.ic_shop_basket))
        navMeowShop.show(1, true)
        replaceFragment(brandFragment)
        navMeowShop.setOnClickMenuListener {
            when(it.id){
                1 -> replaceFragment(brandFragment)
                2 -> replaceFragment(productFragment)
                3 -> replaceFragment(cartFragment)
            }
        }

        return root
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction?.replace(R.id.frame, fragment)
        transaction?.commit()
    }
}