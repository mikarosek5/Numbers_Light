package com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import com.mikarosek5.numberslight.R
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class NumberLightDetailFragment : Fragment() {

    @Inject
    lateinit var viewModel: NumberLightDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.arguments?.let {
            val id = it.getString("id")
            if (id != null) {
                viewModel.getDetail(id)
            } else {
                Toast.makeText(this.context, "bundle is empty", Toast.LENGTH_LONG).show()
            }


        }
    }

    override fun onResume() {
        super.onResume()
        view?.apply {
            findViewById<ComposeView>(R.id.composeView).apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                setContent {
                    viewModel.detail.observeAsState().value?.let {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(text = it.id, modifier = Modifier.padding(horizontal = 8.dp))
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceAround
                            ) {
                                Text(
                                    text = it.word,
                                    fontSize = 50.sp,
                                    modifier = Modifier.padding(horizontal = 8.dp)
                                )
                                AndroidView(factory = { ImageView(it) }) { imageView ->
                                    imageView.apply {
                                        Picasso.get().load(it.imageUrl).into(this)
                                        minimumWidth = 500
                                        minimumHeight = 500
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_number_light_detail, container, false)
    }

}

@Composable
fun DetailsScreen() {

}