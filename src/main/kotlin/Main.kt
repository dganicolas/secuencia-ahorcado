fun main() {
    val consola = GestorConsola()
    val generadorSeries = GeneradorSeries()
    val juego =  Menu(consola, generadorSeries)
    juego.mostrarMenu()
}