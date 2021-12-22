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
class ListOperatorsTest {



    @Test
    fun performGetOrNull() {
        val numbers = listOf(1, 2, 3, 4)
        println(numbers.get(0))
        println(numbers[0])
        //numbers.get(5)                         // exception!
        println(numbers.getOrNull(5))             // null
        println(numbers.getOrElse(5, {it}))        // 5
    }




    @Test
    fun performSearch() {
        val numbers = listOf(1, 2, 3, 4, 2, 5)

//        Linear search
        println(numbers.indexOf(2))
        println(numbers.lastIndexOf(2))
        println(numbers.indexOfFirst { it > 2})
        println(numbers.indexOfLast { it % 2 == 1})

//        Binary search
        val numbers2 = mutableListOf("one", "two", "three", "four")
        numbers2.sort()//list needs to be sorted, to make this search works properly
        println(numbers2)
        println(numbers2.binarySearch("two"))  // at 3, when sorted
        println(numbers2.binarySearch("z")) // should be at -5, according to sorted list
        println(numbers2.binarySearch("two", 0, 2))  //should be at -3, according to sorted list (as range is 0-2)

    }

    @Test
    fun performIteratorsAndLoops() {
        val numbers = listOf("one", "two", "three", "four")
        val numbersIterator = numbers.iterator()
        while (numbersIterator.hasNext()) {
            println(numbersIterator.next())
        }

        for (i in 1..4) // equivalent of 1 <= i && i <= 4
            println(i)

        for (i in 4 downTo 1) println(i)  //reversed

        for (i in 1..8 step 2) println(i)
        for (i in 8 downTo 1 step 2) println(i)

        for (i in 1 until 10) {       // i in [1, 10), 10 is excluded
            print(i)
        }



        for (item in numbers) {
            println(item)
        }

        numbers.forEach {
            println(it)
        }
    }



    @Test
    fun performListOperationsFilter() {
        val numbers = listOf("one", "two", "three", "four")
        numbers.filter { it.length > 3 }  // nothing happens with `numbers`, result is lost
        println("numbers are still $numbers")
        //One way is to create a new list from the filter result, normally
        val longerThan3 = numbers.filter { it.length > 3 } // result is stored in `longerThan3`
        println("numbers longer than 3 chars are $longerThan3")

//Second way is to add filtered result in an existing list. using ..to
        val filterResults = mutableListOf<String>()  //destination object
        numbers.filterTo(filterResults) { it.length > 3 }
        numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
        println(filterResults) // contains results of both operations
    }


    @Test
    fun performListOperationsMap() {
        val numbers = setOf(1, 2, 3)
        println(numbers.map { it * 3 })
        println(numbers.mapIndexed { idx, value -> value * idx })
    }

    @Test
    fun performListOperationsPredicate() {
        val numbers = listOf("one", "two", "three", "four")

        println(numbers.any { it.endsWith("e") })//true / false
        println(numbers.none { it.endsWith("a") })
        println(numbers.all { it.endsWith("e") })
    }

    @Test
    fun performListOperationsTakeAndDrop() {
        val numbers = listOf("one", "two", "three", "four", "five", "six")
        println(numbers.take(3))
        println(numbers.takeLast(3))
        println(numbers.drop(1))
        println(numbers.dropLast(5))
    }




    @Test
    fun performSort() {
        val numbers = mutableListOf("one", "two", "three", "four")
        numbers.sorted()//only return sorted list, original will remain same
        numbers.sort()//sort the original list
        println("Sort into ascending: $numbers")
        numbers.sortDescending()
        println("Sort into descending: $numbers")

        numbers.sortBy { it.length }
        println("Sort into ascending by length: $numbers")
        numbers.sortByDescending { it.last() }
        println("Sort into descending by the last letter: $numbers")

        numbers.sortWith(compareBy<String> { it.length }.thenBy { it })
        println("Sort by Comparator: $numbers")

        numbers.shuffle()
        println("Shuffle: $numbers")

        numbers.reverse()
        println("Reverse: $numbers")
    }





}