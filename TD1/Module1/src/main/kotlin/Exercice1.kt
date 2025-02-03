import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.system.measureTimeMillis

class Exercice1 {
    // Liste de 1000 nombres aléatoires
    val rndList = List(1000) { (20..40).random() }

    // Calcul de la moyenne
    val avg = rndList.sumOf { it.toDouble() } / rndList.size
    // Calcul de la variance
    val variance = rndList.sumOf { (it.toDouble() - avg).pow(2) } / rndList.size
    // Calcul de l'écart-type
    val ecartType = sqrt(variance)

    // Histogramme des valeurs
    val histogram = mutableMapOf<Int, Int>()

    // Moment centré d'ordre n
    val moment3 = rndList.sumOf { (it - avg).pow(3) } / rndList.size
    val moment4 = rndList.sumOf { (it - avg).pow(4) } / rndList.size

    // Centrage et réduction de la liste
    val zList = rndList.map { (it - avg) / ecartType }
    val zAvg = zList.sumOf { it } / zList.size
    val zVariance = zList.sumOf { (it).pow(2) } / zList.size

    // Comparaison de performance

    val timeSumOf = measureTimeMillis {
        rndList.sumOf { it.toDouble() } / rndList.size
    }
    val timeForLoop = measureTimeMillis {
        var sum = 0.0
        for (num in rndList) {
            sum += num
        }
        sum / rndList.size
    }

    init {
        rndList.forEach { histogram[it] = histogram.getOrDefault(it, 0) + 1 }
        println("Moyenne: $avg")
        println("Variance: $variance, Écart-type: $ecartType")
        println("Histogram: $histogram")
        println("Moment d'ordre 3 : $moment3, Moment d'ordre 4 : $moment4")
        println("Moyenne centrée-réduite: $zAvg, Variance: $zVariance")
        println("Temps avec sumOf: $timeSumOf ms, avec boucle for: $timeForLoop ms")

    }
}

fun main() {
    // Exécution de la classe
    Exercice1()
}
