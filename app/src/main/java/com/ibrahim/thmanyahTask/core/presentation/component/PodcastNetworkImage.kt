package com.ibrahim.thmanyahTask.core.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.decode.SvgDecoder
import coil.request.CachePolicy
import coil.request.ImageRequest

@Suppress("ktlint:standard:function-naming")
@Composable
fun PodcastNetworkImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    fallbackPainter: Painter? = null,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    shouldMirrorImage: Boolean = false,
) {
    // Determine if the layout direction is RTL
    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl

    // Apply the mirroring modifier if needed
    val mirrorModifier =
        if (shouldMirrorImage && isRtl) {
            Modifier.graphicsLayer {
                scaleX = -1f // Flip horizontally
            }
        } else {
            Modifier
        }

    if (imageUrl.isEmpty() && fallbackPainter != null) {
        Image(
            painter = fallbackPainter,
            contentDescription = contentDescription,
            modifier = modifier.then(mirrorModifier), // Apply mirroring to fallback image
        )
    } else {
        SubcomposeAsyncImage(
            model =
                ImageRequest
                    .Builder(LocalContext.current)
                    .data(imageUrl)
                    .decoderFactory(SvgDecoder.Factory())
                    .crossfade(true)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .memoryCacheKey(imageUrl)
                    .diskCacheKey(imageUrl)
                    .build(),
            // Build the ImageRequest.
            modifier = modifier, // Apply the outer container modifier.
            contentDescription = contentDescription, // Set the content description.
            contentScale = contentScale, // Set the content scale for the image.
        ) {
            // Get the current state of the image painter.
            val state = painter.state

            when (state) {
                is AsyncImagePainter.State.Loading -> {
                    // Display a circular progress indicator while the image is loading.
                    Box(
                        contentAlignment = Alignment.Center, // Center the progress indicator.
                    ) {
                        PodcastCircularProgressIndicator()
                    }
                }

                is AsyncImagePainter.State.Error -> {
                    // Display an error icon if the image fails to load.
                    Box(
                        contentAlignment = Alignment.Center, // Center the error icon.
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ErrorOutline, // Use a rounded error outline icon.
                            contentDescription = null, // No content description needed for the error icon.
                            tint = MaterialTheme.colorScheme.error, // Set the color of the error icon.
                        )
                    }
                }

                else -> {
                    // Display the image content if it loads successfully.
                    SubcomposeAsyncImageContent(
                        modifier = Modifier.then(mirrorModifier), // Apply mirroring to content
                    )
                }
            }
        }
    }
}
