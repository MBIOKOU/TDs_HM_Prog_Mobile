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
    // Comparaison de la moyenne et l'écart type empirique
    val avg_empirique = (40 + 20)/2
    val ecartType_empirique = sqrt(((40 - 20).toDouble().pow(2)) / 12)



    // Histogramme des valeurs
    val histogram = mutableMapOf<Int, Int>()

    // Moment centré d'ordre n
    val moment3 = rndList.sumOf { (it - avg).pow(3) } / rndList.size
    val moment4 = rndList.sumOf { (it - avg).pow(4) } / rndList.size

    // Coeeficient d'applatissement et d'assymétrie
    val asymcoef = moment3 / (ecartType.pow(3)) // Coefficient d'asymétrie
    val applcoef = moment4 / (ecartType.pow(4)) - 3


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
        println("moyenne empirique : $avg_empirique, Ecart-type empirique: $ecartType_empirique")
        println("La moyenne et l'écart-type théorique sont approximatives aux théoriques")

        println("Histogram: $histogram")
        println("La modalité de la liste est 21")
        println("Moment d'ordre 3 : $moment3, Moment d'ordre 4 : $moment4")
        println("Le coefficent d'assymétrie est : $asymcoef, Le coefficient d'applatissement est : $applcoef")

        println("Moyenne centrée-réduite: $zAvg, Variance: $zVariance")
        println("On remarque que la varience est égale à 1 et la moyenne est proche de 0")
        println("Temps avec sumOf: $timeSumOf ms, avec boucle for: $timeForLoop ms. On constate que le temps est le meme")

    }
}

fun main() {
    // Exécution de la classe
    Exercice1()
}
