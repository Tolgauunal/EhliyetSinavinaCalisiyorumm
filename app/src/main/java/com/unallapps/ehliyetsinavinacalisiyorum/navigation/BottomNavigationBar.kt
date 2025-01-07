package com.unallapps.ehliyetsinavinacalisiyorum.navigation

import com.unallapps.ehliyetsinavinacalisiyorum.R

sealed class BottomBarScreen(
    val route: String,
    val label: String,
    val icon: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        label = "Home",
        icon = R.drawable.home
    )

    object Subjects : BottomBarScreen(
        route = "subject",
        label = "Subjects",
        icon = R.drawable.baseline_library_books_24
    )

    object Tests : BottomBarScreen(
        route = "tests",
        label = "Tests",
        icon = R.drawable.test
    )

    object Profile : BottomBarScreen(
        route = "profile",
        label = "Profile",
        icon = R.drawable.baseline_person_24
    )

    object InformationCard : BottomBarScreen(
        route = "informationCard/{subjectName}",
        label = "InformationCard",
        icon = R.drawable.baseline_person_24
    )

    object TestScreen : BottomBarScreen(
        route = "testScreen/{lessonName}/{restartOrContinue}",
        label = "TestScreen",
        icon = R.drawable.baseline_person_24
    )

    object SubjectScreen : BottomBarScreen(
        route = "subjectScreen/{subjectName}",
        label = "SubjectScreen",
        icon = R.drawable.baseline_person_24
    )
}