package com.ggn.updatedbasearchitecture.presentation

import android.graphics.Color
import androidx.lifecycle.lifecycleScope
import com.ggn.updatedbasearchitecture.R
import com.ggn.updatedbasearchitecture.base.BaseActivity
import com.ggn.updatedbasearchitecture.databinding.ActivityMainBinding
import com.ggn.updatedbasearchitecture.presentation.feature_one.CoinListActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main
    override var binding: ActivityMainBinding
        get() = setUpBinding()
        set(value) {}


    override fun bindData() {
        lifecycleScope.launchWhenStarted {
            delay(600)
            binding.layout.setBackgroundColor(Color.CYAN)
            delay(600)
            binding.layout.setBackgroundColor(Color.BLUE)
            delay(600)
            binding.layout.setBackgroundColor(Color.GREEN)
            delay(600)
            binding.layout.setBackgroundColor(Color.MAGENTA)
            delay(600)
            binding.layout.setBackgroundColor(Color.LTGRAY)
            delay(600)

            CoinListActivity.start(this@MainActivity)
        }
    }

    override fun initListeners() {

    }
}