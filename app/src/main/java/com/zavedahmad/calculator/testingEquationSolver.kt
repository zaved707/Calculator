package com.zavedahmad.calculator

import org.mariuszgromada.math.mxparser.Expression
import org.mariuszgromada.math.mxparser.License


fun main() {
    License.iConfirmNonCommercialUse("John Doe")
    val eqString = "33 +4*5*1-3love"

    val equation = Expression(eqString)

    println(equation.calculate())
}
