package com.ggn.updatedbasearchitecture.presentation.feature_two

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.fonts.FontStyle
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ggn.updatedbasearchitecture.R
import com.ggn.updatedbasearchitecture.base.BaseActivity
import com.ggn.updatedbasearchitecture.common.Constants
import com.ggn.updatedbasearchitecture.common.compose_ui.CircularLoading
import com.ggn.updatedbasearchitecture.databinding.ActivityCoinDetailsBinding
import com.ggn.updatedbasearchitecture.domain.model.CoinDetail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinDetailsActivity : BaseActivity<ActivityCoinDetailsBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_coin_details
    override var binding: ActivityCoinDetailsBinding
        get() = setUpBinding()
        set(value) {}

    private val viewModel:CoinDetailViewModel by viewModels()

    override fun bindData() {
        binding.composeView.apply {
            setContent {
                showCoinDetails()
            }
        }
    }

    override fun initListeners() {

    }


    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun showCoinDetails(){
        var showLoader by remember {mutableStateOf(true)}

                MaterialTheme {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        Alignment.Center
                    ) {
                        showLoader = viewModel.state().collectAsState().value.isLoading
                        CircularLoading(show = showLoader)
                        viewModel.state().collectAsState().value.data?.let { showCoinDetailsText(data = it) }
                    }
        }
    }

    @Composable
    fun showCoinDetailsText(data : CoinDetail){
        Column(horizontalAlignment =Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()) {
                Text(text = data.name, fontWeight = FontWeight.Bold, fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
                Text(text = "-->")
                Text(text = data.symbol,fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = data.description,fontWeight = FontWeight.Light)
        }

    }

    companion object{
        fun start(context: Context,coinId :String){
            context.startActivity(Intent(context, CoinDetailsActivity::class.java).apply {
                putExtra(Constants.PARAM_COIN_ID,coinId)
            })
        }
    }
}

