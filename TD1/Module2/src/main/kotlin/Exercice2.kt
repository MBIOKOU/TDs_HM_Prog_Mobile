import kotlin.math.sqrt

fun mySqrt(x: Double): Double? {
    return if (x >= 0) {
        sqrt(x)
        } else {
            null
        }
    }
fun realRoots(a :Double, b: Double, c: Double): List<Double>? {
    if (a==0.0 ) throw IllegalArgumentException("a doit etre non plus")
    val delta = b*b - 4 * a * c

    return when{
        delta < 0 -> emptyList()    // Pas de racine réelle
        delta == 0.0 -> listOf(-b / (2 * a)) // Une racine double
        else ->{
            val sqrtDelta = mySqrt(delta)!!  // Calcul de la racine de delta
            listOf(
                (-b + sqrtDelta) / (2 * a),
                (-b - sqrtDelta) / (2 * a),
            )
        }
    }

}

// Test de la fonction
fun main (){
    println("Polynome x^2 - 2x +1")
    println(realRoots(1.0,-2.0,1.0))

    println("Polynome x^2 - 2x +2")
    println(realRoots(1.0,-2.0,2.0))

    println("Polynome x^2 - 2")
    println(realRoots(1.0,0.0,-2.0))

    println("Polynome x^2 - 3x +2")
    println(realRoots(1.0,-3.0,2.0))
}

