//@Composable
//fun MyDateField() {
//    val dialogState = rememberMaterialDialogState()
//    val textState = remember { mutableStateOf(TextFieldValue()) }
//    MaterialDialog(
//        dialogState = dialogState,
//        buttons = {
//            positiveButton("Ok")
//            negativeButton("Cancel")
//        }
//    ) {
//
//            date ->
//        val formattedDate = date.format(
//            DateTimeFormatter.ofPattern("dd.MM.yyyy")
//        )
//        textState.value = TextFieldValue(formattedDate)
//    }

//        Column(modifier = Modifier.padding(16.dp)) {
//            ReadonlyTextField(
//                value = textState.value,
//                onValueChange = { textState.value = it },
//                onClick = {
//                    dialog.show()
//                },
//                label = {
//                    Text(text = "Date")
//                }
//            )
//        }
//    }

//}

//@Composable
//fun ReadonlyTextField(
//    value: TextFieldValue,
//    onValueChange: (TextFieldValue) -> Unit,
//    modifier: Modifier = Modifier,
//    onClick: () -> Unit,
//    label: @Composable () -> Unit
//) {
//    Box {
//        TextField(
//            value = value,
//            onValueChange = onValueChange,
//            modifier = modifier,
//            label = label
//        )
//        Box(
//            modifier = Modifier
//                .matchParentSize()
//                .alpha(0f)
//                .clickable(onClick = onClick),
//        )
//    }
//}

////@Composable
////fun DatePicker() : DatePickerDialog {
////    val context = LocalContext.current
////    val calendar = Calendar.getInstance()
////
////    var selectedDateText by remember { mutableStateOf("") }
////
////// Fetching current year, month and day
////    val year = calendar[Calendar.YEAR]
////    val month = calendar[Calendar.MONTH]
////    val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
////
////    val datePicker = DatePickerDialog(
////        context,
////        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
////            selectedDateText = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
////        }, year, month, dayOfMonth
////    )
////    datePicker.datePicker.minDate = calendar.timeInMillis
////
////    return datePicker
////}