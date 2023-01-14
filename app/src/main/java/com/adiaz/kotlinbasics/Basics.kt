package com.adiaz.kotlinbasics

// Data class
data class User(val id: Long, var name: String)


fun main() {
    // Data classes
    val user1 = User(1, "Ale")
    user1.name = "Mar"

    val user2 = User(2, "Xim")
    println(user1.name == user2.name)

    val updatedUser = user1.copy(name="Yao")

    // Deconstructing
    val (id, newName) = updatedUser
    println("id:$id\nname:$newName")

    ///
    val myName = "Aldair Diaz"
    val myAge = 24

    // String interpolation
    print("Hello $myName and i'm $myAge\n")
    print("First Character ${myName[0]}, and the length of the string is ${myName.length}\n")

    // Single line comments
    /*
    Multiline comment
     */
    // ////////// Data-types

    // Integer types: Byte 8 bits, Short 16 bits, Int 32 bits, Long 64 bits
    val myByte: Byte = 22
    val myShort: Short = 2344
    val myInt: Int = 235324245
    val myLong: Long = 2143_1241_1234_1242_124

    // Floating Point number types: Float 32 bits, Double 64 bits
    val myFloat: Float = 32.2F
    val myDouble: Double = 3.1415

    // Boolean
    val isSunny = false

    // Char
    val myChar: Char = '&'

    // type inference finds out the type from context

    // //////////// Exercise Variables And Data-types
    var name: String = "Android Masterclass"
    var newFloat: Float = 13.37F
    val pi: Double = 3.14159265358979
    var twentyFive: Byte = 25
    var worstYear: Int = 2020
    var randomNumber: Long = 18881234567
    var isItTrue: Boolean = true
    var aChar: Char = 'a'

    // Arithmetic operators
    var result = 5 + 3
    val a = 5.0
    val b = 3
    val resultDouble: Double = a / b
    println(resultDouble)

    // Comparison Operators
    // val isEqual: Boolean = 5 == 3
    // println("The result is $isEqual")

    // Assignment operators
    var myNum = 3
    myNum += 3
    myNum ++
    println("The result is ${++myNum}")

    // if statement
    val heightPerson1 = 175
    val heightPerson2 = 185

    if (heightPerson1 > heightPerson2){
        println("Use raw force")
        heightPerson1
    } else if (heightPerson1 == heightPerson2) {
        println("Use your power technique 334")
    } else {
        println("Use technique")
    }

    // When expressions similar to switch condition
    val season = 3

    when(season) {
        1 -> println("Spring")
        2 -> println("Summer")
        3 -> {
            println("Fall")
            println("Autumn")
        }
        4 -> println("Winter")
        else -> println("No season")
    }

    val x: Any = 23.34
    when(x) {
        is Int -> println("$x is an integer")
        is Double -> println("$x is a double")
        is Float -> println("$x is a Float")
        else -> println("$x is none of the above")
    }

    // when can be used as an expression
    val result_when = when(x) {
        is Int -> "X is an integer"
        is Double -> "X is a float"
        else -> "X is not a number"
    }
    println("$x is a $result_when")

    // Loops
    var xWhile = 10
    while (xWhile >= 1) {
        println(xWhile)
        xWhile --;
    }

    var k = 1
    do {
        println(k)
        k ++
    } while (k <= 10)

    // in for loops you can use .. ; until; downTo; and specify the step
    for (num in 1..20) {
        println(num)
    }

    for (i in 20 downTo 10 step 2) {
        println(i)
    }

    // functions
    newFunction()
    val resultF = addUp(5, 2)
    println(resultF)
    println(divedUp(4.0, 2.2))

    // Nullable
    var nullName: String? = "Aldair"
    nullName = null

    val newNullName = nullName ?: "Guest"


    // Objects
    val aldair = Person("Aldair", "Diaz", 24)
    aldair.hobby = "Play soccer"
    aldair.stateHobby()
    val john = Person()
    john.stateHobby()

    print("\n\nInheritance: \n\n")
    // Inheritance
    val myCar = Vehicle("A5", "Audi")
    val myECar = ElectricCar("Tesla model S", "Tesla", 504.23)

    myCar.drive(200.0)
    myECar.drive(230.2)

    myECar.extendRange(25.2)
    myECar.chargerType = "Type 2"


    // Challenge: create three objets from the class MobilePhone

    val phone1 = MobilePhone("android 11", "Samsung", "A 55")
    var phone2 = MobilePhone("android 13", "LG", "atxr 45")
    var phone3 = MobilePhone("android 10", "Google", "Pixel 7")

    phone1.chargeBattery(30)

}

fun addUp(a: Int, b: Int): Int {
    return a + b
}

fun newFunction() {
    print("Called from function\n")
}

fun divedUp(a: Double, b: Double): Double {
    return a / b
}

// Classes

class Person constructor(firstName: String = "Person name", lastName: String="Person last name") {
    // Member variables - properties
    var age: Int? = null
    var hobby: String = "Watch Netflix"
    var firstName: String? = null

    // Initializer block
    init {
        this.firstName = firstName
        println("Person created\nFirst name = $firstName, last name = $lastName")
    }

    // Member secondary constructor
    constructor(firstName: String, lastName: String, age: Int) : this (firstName, lastName) {
        this.age = age
        // this.firstName = firstName
    }

    // Member functions - Methods
    fun stateHobby() {
        println("$firstName\'s hobby is $hobby")

    }

}

class Car(){
    lateinit var owner: String

    val myBrand: String = "BMW"
    get () {
        return field.lowercase()
    }

    var maxSpeed: Int = 250
        get() = field
        set(value) {
            field = if(value > 0) value else throw IllegalArgumentException("Max speed cannot be" +
                    "less than zero")
        }

    var myModel: String = "M5"
        private set

    init {
        this.owner = "Aldair"
    }
}
/* value
 We use value as the name of the setter parameter. This is the default convention in Kotlin but you’re free to use any other name if you want.
 The value parameter contains the value that a property is assigned to. For example, when you write user.name = "Elon Musk",
 the value parameter contains the assigned value "Elon Musk".
 2. Backing Field (field)
 Backing field helps you refer to the property
 inside the getter and setter methods.
 This is required because if you use the property
 directly inside the getter or setter then you’ll
 run into a recursive call which will generate
 a StackOverflowError.*/

// Inheritance
/*
The class that inherits the features of another class is called the sub class or child class or
derived class, and the class whose features are inherited is called the super class or parent class
or base class
 */
open class Vehicle(val name: String, val brand: String) {
    // properties
    open var range: Double = 0.0
    // methods
    fun extendRange(amount: Double) {
        if (amount > 0)
            range += amount
    }
    fun drive(distance: Double){
        println("Dove for $distance Km")
    }
}

class ElectricCar(name: String, brand: String, batteryLife: Double) : Vehicle(name, brand){
    override var range = batteryLife * 6
    var chargerType = "Type 1"
}

// Challenge: create a class

class MobilePhone constructor(osName: String, brand: String, model: String) {
    // Challenge: classes
    private var battery: Int = 50

    init {
        println("Object created: \n$osName\n$brand\n$model\n\n")
    }

    fun chargeBattery(chargedBy: Int) {
        println("Battery was at $battery and now is at ${battery + chargedBy}")
        battery += chargedBy
    }
}



