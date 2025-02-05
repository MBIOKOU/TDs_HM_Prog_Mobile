import kotlin.math.sqrt

fun apply(n : Int, m : Int=0, f:(Int)->Int ) : Int {
    var result = n
    repeat(m) {
        result = f(result)
    }
    return result
}

// Utilisation de apply sur la suite de Syracuse
fun syracuse (n:Int, m:Int) : Int {
    return apply(n,m){ x->
        println(x)
        if(x % 2 == 0) x / 2 else 3 * x + 1
    }
}

// Utiliser apply pour calculer l'approximation
// La fonction apply de la question1 n'accepte pas les double, car la consigne a bien spécifié des entiers, alors au lieu de retourner la moifier ett ne plus respecter l'énoncé,  j'ai préféré utiliser une autre fonction apply
fun apply1(n: Double, m: Int = 0, f: (Double) -> Double): Double {
    var result = n
    repeat(m) {
        result = f(result)
    }
    return result
}

fun approximateSqrt2(iterations: Int): Double {
    return apply1(1.0, iterations) { u -> 0.5 * (u + 2.0 / u) }
}
fun main() {
    // Test de la fonction apply
    val result1 = apply(2,3){x->x*x}
    println("Resultat de apply(2, 3, f = { x -> x * x }): $result1")
    println("La fonction renvoie la valeur 256 ")

    val result2 = apply(12,8){x->
        println("  \${x % 2}")
        x/2
    }
    println("Resultat de apply(12, 8, f = { x -> println(\"  \${x % 2}\"); x / 2 }): $result2")
    println("La fonction apply divise successivement 12 par 2 et affiche la parité à chaque étape. A la 8ème étape la valeur renvoyée est 0")

   // Test de syracuses

    val result = syracuse(15, 10)
    println("Le 10ème terme de la suite est : $result")

    // Approximation de sqrt(2) avec 10 itérations
    val approxSqrt2 = approximateSqrt2(10)
    println("Approximation de sqrt(2) après 10 itérations : $approxSqrt2")
}