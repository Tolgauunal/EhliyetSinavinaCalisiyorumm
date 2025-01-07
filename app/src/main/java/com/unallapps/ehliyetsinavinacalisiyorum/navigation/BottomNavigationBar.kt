package com.unallapps.ehliyetsinavinacalisiyorum.navigation

import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.util.Constants

sealed class BottomBarScreen(
    val route: String,
    val label: String,
    val icon: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        label = Constants.String.HOME,
        icon = R.drawable.home
    )

    object Subjects : BottomBarScreen(
        route = "subject",
        label = Constants.String.SUBJECT,
        icon = R.drawable.baseline_library_books_24
    )

    object Tests : BottomBarScreen(
        route = "tests",
        label = Constants.String.TEST,
        icon = R.drawable.test
    )

    object Profile : BottomBarScreen(
        route = "profile",
        label = Constants.String.PROFILE,
        icon = R.drawable.baseline_person_24
    )

    object InformationCard : BottomBarScreen(
        route = "informationCard/{subjectName}",
        label = Constants.String.INFORMATION_CARD,
        icon = R.drawable.baseline_person_24
    )

    object TestScreen : BottomBarScreen(
        route = "testScreen/{lessonName}/{restartOrContinue}",
        label = Constants.String.TEST,
        icon = R.drawable.baseline_person_24
    )

    object SubjectScreen : BottomBarScreen(
        route = "subjectScreen/{subjectName}",
        label = Constants.String.SUBJECT,
        icon = R.drawable.baseline_person_24
    )
}