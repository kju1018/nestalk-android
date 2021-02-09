package com.doongji.kakaotalk_clone_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import com.doongji.kakaotalk_clone_android.databinding.ActivityMainBinding
import com.doongji.kakaotalk_clone_android.ui.fragment.ChatFragment
import com.doongji.kakaotalk_clone_android.ui.fragment.FriendFragment
import com.doongji.kakaotalk_clone_android.ui.fragment.SettingFragment

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding
    
    private lateinit var fragmentTransaction:FragmentTransaction
    private val friendFragment:FriendFragment by lazy {FriendFragment.newInstance()}
    private val chatFragment:ChatFragment by lazy { ChatFragment.newInstance() }
    private val settingFragment:SettingFragment by lazy { SettingFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fl_main_layout, friendFragment).commit()

        activityMainBinding.bottomNavigationView.setOnNavigationItemSelectedListener {
            fragmentTransaction = supportFragmentManager.beginTransaction()
            when(it.itemId){
                R.id.item_friend -> { fragmentTransaction.replace(R.id.fl_main_layout, friendFragment).commit() }
                R.id.item_chat -> { fragmentTransaction.replace(R.id.fl_main_layout, chatFragment).commit()}
                R.id.item_setting -> {fragmentTransaction.replace(R.id.fl_main_layout, settingFragment).commit() }
            }
            return@setOnNavigationItemSelectedListener true
        }

    }
}