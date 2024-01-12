package br.com.globalbyte.sample.and.modularizedsample.core.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.globalbyte.sample.and.modularizedsample.core.model.Note

@Composable
fun TodoListing(
    todoNotes: List<Note>,
    modifier: Modifier = Modifier,
    enableToggleable: Boolean = true,
    lazyListState: LazyListState = rememberLazyListState()
) {
    TodoListing(
        todoNotes = todoNotes,
        onTodoChange = {},
        modifier = modifier,
        enableToggleable = enableToggleable,
        lazyListState = lazyListState
    )
}

@Composable
fun TodoListing(
    todoNotes: List<Note>,
    onTodoChange: (Note) -> Unit,
    modifier: Modifier = Modifier,
    enableToggleable: Boolean = true,
    lazyListState: LazyListState = rememberLazyListState()
) {
    LazyColumn(
        modifier = modifier,
        state = lazyListState
    ) {
        itemsIndexed(
            items = todoNotes,
            key = { _, item -> item.id }
        ) { index, todoNote ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                //shape = RectangleShape,
                //border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .toggleable(
                        enabled = enableToggleable,
                        value = todoNote.done,
                        onValueChange = {
                            onTodoChange(todoNote.copy(done = it))
                        }
                    )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = todoNote.description,
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f)
                    )

                    Checkbox(
                        checked = todoNote.done,
                        onCheckedChange = null,
                        enabled = enableToggleable
                    )
                }
            }
            if (index < todoNotes.lastIndex)
                Divider()
        }
    }
}