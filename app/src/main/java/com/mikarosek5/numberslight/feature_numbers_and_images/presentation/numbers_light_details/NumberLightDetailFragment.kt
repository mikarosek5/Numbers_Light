package com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.model.NumberLightDetail
import com.mikarosek5.numberslight.feature_numbers_and_images.presentation.theme.TheNumbersLightTheme
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class NumberLightDetailFragment : Fragment() {

    @Inject
    lateinit var viewModel: NumberLightDetailsViewModel

    private lateinit var composeView: ComposeView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).also {
            composeView = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        composeView.setContent {
            TheNumbersLightTheme {
                this.arguments?.getString("id")?.let {
                    viewModel
                        .getObservableDetail(it)
                        .subscribeAsState(initial = null)
                        .value
                        ?.let { details->
                            DetailsScreen(detail = details)
                        }
                }
            }
        }
    }



}

@Composable
fun DetailsScreen(detail:NumberLightDetail) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = detail.id, modifier = Modifier.padding(horizontal = 8.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = detail.word,
                fontSize = 50.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            AndroidView(factory = { ImageView(it) }) { imageView ->
                imageView.apply {
                    Picasso.get().load(detail.imageUrl).into(this)
                    minimumWidth = 500
                    minimumHeight = 500
                }
            }
        }

    }
}