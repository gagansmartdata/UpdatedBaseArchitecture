package com.ggn.updatedbasearchitecture

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    class Person() {
        var name: String = "Abcd"
        var contactNumber: String = "1234567890"
        var address: String = "xyz"
        var id: Int = 0
    }

    @Test
    fun performLetOperation() {
        val person : Person? = Person()

        val personString = person?.let {
            "The name of the Person is: ${it.name}"
        } ?: "The name of the Person is: Null Case"

        println(personString)
    }







    @Test
    fun performRunOperation() {
        val person : Person? = null

        val data = person?.run {
            name = "Asdf"
            contactNumber = "0987654321"
            id = 2
            9
        }
    }








    @Test
    fun performWithOperation() {
        val person : Person = Person()

        val data = with(person) {
            "The name of the Person is: $name"
        }
        System.out.println(data)
    }








    @Test
    fun performApplyOperation() {
        val person: Person = Person()
        val data = person.apply {
            name = "asdf"
            contactNumber = "1234"
            address = "wasd"
        }
    }






    @Test
    fun performAlsoOperation() {
        val data = Person().also {
            println("Current name is: ${it.name}\n")
            it.name = "modifiedName"
        }.run {
            "Current name is: $name"
        }
        println(data)
    }

}