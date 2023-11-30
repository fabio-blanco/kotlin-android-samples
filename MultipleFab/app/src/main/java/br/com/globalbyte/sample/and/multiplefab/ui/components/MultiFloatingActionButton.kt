package br.com.globalbyte.sample.and.multiplefab.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.globalbyte.sample.and.multiplefab.ui.theme.MultipleFabTheme

enum class MultiFabState {
    COLLAPSED, EXPANDED
}
data class InnerFab(
    val content: @Composable () -> Unit,
    val onFabItemClicked: () -> Unit,
    val shape: Shape = RoundedCornerShape(10.dp)
)

fun listOfInnerFab(vararg innerFabs: InnerFab): List<(@Composable ( () -> Unit ) -> Unit)> =
    innerFabs.map { innerFab ->
        { changeCurrentMFabState ->
            InnerFloatingActionButton(
                onClick = {
                    changeCurrentMFabState()
                    innerFab.onFabItemClicked()
                },
                shape = innerFab.shape
            ) {
                innerFab.content()
            }
        }
    }

@Composable
fun MultiFloatingActionButton(
    modifier: Modifier = Modifier,
    onStateChanged: ((state: MultiFabState) -> Unit)? = null,
    items: List<@Composable (
            () -> Unit
    ) -> Unit>,
    mFabState: MutableState<MultiFabState> = rememberMFabState(),
    shape: Shape = CircleShape,
) {
    MultiFloatingActionButton(
        modifier = modifier,
        onStateChanged = onStateChanged,
        items = items,
        mFabState = mFabState,
        shape = shape,
        openContent = {
            Icon(Icons.Default.Close, contentDescription = "Close")
        }
    ) {
        Icon(Icons.Default.Add, contentDescription = "Open")
    }
}

@Composable
fun rememberMFabState() = remember { mutableStateOf(MultiFabState.COLLAPSED) }

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MultiFloatingActionButton(
    modifier: Modifier = Modifier,
    onStateChanged: ((state: MultiFabState) -> Unit)? = null,
    items: List<@Composable (
        () -> Unit
    ) -> Unit>,
    mFabState: MutableState<MultiFabState> = rememberMFabState(),
    shape: Shape = CircleShape,
    openContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {

    var currentMFabState by mFabState
    val changeCurrentMFabState: () -> Unit = {
        currentMFabState = if (currentMFabState == MultiFabState.EXPANDED) {
            MultiFabState.COLLAPSED
        } else MultiFabState.EXPANDED
        onStateChanged?.invoke(currentMFabState)
    }

    val contentByState = when (currentMFabState) {
        MultiFabState.EXPANDED -> openContent
        MultiFabState.COLLAPSED -> content
    }

    val openCloseFabTransition = updateTransition(currentMFabState == MultiFabState.EXPANDED, label = "Open Close Fab Transition")

    Column(
        modifier = modifier.width(IntrinsicSize.Max)
    ) {

        openCloseFabTransition.AnimatedVisibility(
            visible = { it },
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            Column {
                items.forEach { item ->
                    item {
                        changeCurrentMFabState()
                    }
                }
            }
        }

        val fabModifier = when (currentMFabState) {
            MultiFabState.EXPANDED -> Modifier.padding(top = 8.dp)
            MultiFabState.COLLAPSED -> Modifier
        }

        FloatingActionButton(
            onClick = changeCurrentMFabState,
            content = contentByState,
            modifier = fabModifier,
            shape = shape
        )
    }

}

@Composable
fun InnerFloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(10.dp),
    content: @Composable () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        SmallFloatingActionButton(
            onClick = onClick,
            shape = shape
        ) {
            content()
        }
    }
}

@Composable
fun ModalFabBackground(
    mFabState: MutableState<MultiFabState>,
    backgroundColor: Color = Color.DarkGray.copy(alpha = 0.6f)
) {
    val currentMFabState by mFabState

    val modalBackgroundModifier = if (currentMFabState == MultiFabState.EXPANDED) {
        Modifier.fillMaxSize()
    } else {
        Modifier
    }

    Surface(
        modifier = modalBackgroundModifier,
        color = backgroundColor
    ) {}

}

@Preview(showBackground = true)
@Composable
fun MultiFloatingActionButtonPreview() {
    MultipleFabTheme {
        /*MultiFloatingActionButton(
            items = listOf({ changeCurrentMFabState ->
                InnerFloatingActionButton({changeCurrentMFabState()}) {
                    Icon(Icons.Default.Home, contentDescription = "Home")
                }
            }, { changeCurrentMFabState ->
                InnerFloatingActionButton({changeCurrentMFabState()}) {
                    Icon(Icons.Default.Info, contentDescription = "Info")
                }
            })
        )*/
        MultiFloatingActionButton(
            items = listOfInnerFab(
                InnerFab({ Icon(Icons.Default.Home, contentDescription = "Home") }, {}),
                InnerFab({ Icon(Icons.Default.Info, contentDescription = "Info") }, {}),
            )
        )
    }
}