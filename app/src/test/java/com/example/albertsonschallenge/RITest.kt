package com.example.albertsonschallenge

import com.example.albertsonschallenge.model.RepositoryImplementation
import com.example.albertsonschallenge.model.remote.SearchAPI
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RITest {
    private lateinit var classUnderTest: RepositoryImplementation

    @Before
    fun setup(){classUnderTest = RepositoryImplementation(SearchAPI())
    }

    @Test
    fun `return false when response failed`(){
        val actual = classUnderTest.getAcronym("test")
        Assert.assertEquals("test", actual)
    }

    @After
    fun cleanUp(){}
}