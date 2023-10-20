package br.com.globalbyte.sample.and.composebasicstatecodelab.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.globalbyte.sample.and.composebasicstatecodelab.data.WellnessTask
import br.com.globalbyte.sample.and.composebasicstatecodelab.ui.theme.ComposeBasicStateCodelabTheme

@Composable
fun WellnessTaskList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked) },
                onClose = { onCloseTask(task)}
            )
        }
    }
}

private fun getWellnessTasks() = List(30) {i -> WellnessTask(i, "Task # $i") }

@Preview(showBackground = true)
@Composable
fun WellnessTaskListPreview() {
    ComposeBasicStateCodelabTheme {
        WellnessTaskList(getWellnessTasks(), {_, _ ->}, {})
    }
}