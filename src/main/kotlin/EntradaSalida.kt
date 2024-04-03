class EntradaSalida(): IMenu {

    override fun mostrarMenu() {
        println("1. Generar serie.")
        println("2. Jugar al ahorcado.")
        println("3. Salir.")
        println("Por favor, selecciona una opción:")

    }

    override fun imprimir(mensaje:String){
        println(mensaje)
    }
    override fun escogerOpcion(){

        do{
            mostrarMenu()
            val numero= readln().toIntOrNull()
            when(numero){
                1-> generarSerie()
                2-> break
                3-> {imprimir("saliendo...");break}
            }
        } while (true)
    }

    override fun escogerNumero(minimo:Int, maximo:Int):Int{
        var numero : Int?
        do {
            print("Inserte un número [$minimo-$maximo] -> ")
            numero = readln().toIntOrNull()
            if (numero != null && (numero > maximo || numero < minimo)){
                numero = null
            }
        }while (numero == null)
        return numero
    }

    override fun generarSerie() {
        GeneradorSeries(EntradaSalida()).generarSerie()
    }

    override fun jugarAhorcado() {
        TODO("Not yet implemented")
    }

}

interface IMenu {
    /**
     * muestra el menu
     * */
    fun mostrarMenu()
    /**
     * muestra una serie tecleada por el usuario
     * */
    fun generarSerie()
    /**
     * juega al ahorcado
     * */
    fun jugarAhorcado()
    /**
     * escoge el numero aleatorio
     * @param minimo numero minimo
     * @param maximo el numero maximo
     * @return el numero
     * */
    fun escogerNumero(minimo:Int,maximo:Int):Int
    /**
     * el ussario escoge un opcion
     * */
    fun escogerOpcion()
    /**
     * muestra por pantalla
     * */
    fun imprimir(mensaje:String)
}