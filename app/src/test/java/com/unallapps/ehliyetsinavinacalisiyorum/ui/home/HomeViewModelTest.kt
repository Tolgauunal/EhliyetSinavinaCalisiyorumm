package com.unallapps.ehliyetsinavinacalisiyorum.ui.home

import com.google.common.truth.Truth.assertThat
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseSubject
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.UserRepository
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {
    private lateinit var viewModel: HomeViewModel
    private val userRepository: UserRepository = mockk()
    private val testScope = TestScope(UnconfinedTestDispatcher())

    fun createViewModel() {
        coEvery { userRepository.getUser() } returns UserEntity(userName = "Tolga")
        viewModel = spyk(HomeViewModel(userRepository))
    }

    @Test
    fun `given existing user in repository when viewModel initializes then userInfo and userName should be set correctly`() =
        testScope.runTest {
            createViewModel()
            viewModel.getInitialData()
            advanceUntilIdle()

            assertThat(viewModel.userName.value).isEqualTo("Tolga")
            assertThat(viewModel.userInfo.value).isEqualTo(UserEntity(userName = "Tolga"))
        }

    @Test
    fun `given lesson index when updateSelectedLesson called then selectedLessonIndex should update`() =
        testScope.runTest {
            createViewModel()
            viewModel.updateSelectedLesson(1)

            assertThat(viewModel.selectedLessonIndex.value).isEqualTo(1)
        }

    @Test
    fun `given subject when updateSelectedSubject called then selectedSubject should update`() {
        createViewModel()
        val subject = DatabaseSubject.subjectLists.first()

        viewModel.updateSelectedSubject(subject)

        assertThat(viewModel.selectedSubject.value).isEqualTo(subject)
    }

    @Test
    fun `given dialog state when showDialog called then isDialogVisible should update`() =
        testScope.runTest {
            createViewModel()
            viewModel.showDialog(true)

            assertThat(viewModel.isDialogVisible.value).isTrue()
        }
}