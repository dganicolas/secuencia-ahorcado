class Menu(val consola: IntgestorConsola, val generadorSeries: IntGeneradorSeries): IMenu {

    var estado = true
    override fun mostrarMenu() {
        while(estado){
            consola.imprimir("1. Generar serie.")
            consola.imprimir("2. Jugar al ahorcado.")
            consola.imprimir("3. Salir.")
            consola.imprimir("Por favor, selecciona una opción:")
            realizarOpcion(pedirOpcion())
        }
    }

    fun realizarOpcion(opcion:Int){
        when (opcion){
            1 -> generarSerie()
            2 -> jugarAhorcado()
            3 -> finalPrograma()
        }
    }

    fun finalPrograma(){
        consola.imprimir("saliendo...")
        Thread.sleep(1000)
        estado= false
    }

    fun pedirOpcion():Int{
        var numero:Int?
        do{
            numero = consola.pedir("dame un numero:").toIntOrNull()
            if (numero == null || numero > 3 || numero < 1){
                consola.imprimir("ERROR- pon una opcion valida")
                numero = null
            }
        }while (numero == null)
        return numero
    }

    override fun generarSerie() {
        val numero = elegirOpcion(generadorSeries.generarRangoAleatorio())
        consola.imprimir(generadorSeries.generarSerie(numero))
    }

    fun elegirOpcion(numero : Int):Int{
        var numeroElegido:Int?
        do{
            consola.imprimir("dame un numero de $numero - ${numero+30}")
            numeroElegido = consola.pedir("dame el numero:").toIntOrNull()
            if (numeroElegido == null || numeroElegido > numero+30 || numeroElegido < numero){
                consola.imprimir("ERROR- pon una opcion valida")
                numeroElegido = null
            }
        }while(numeroElegido == null)
        return numeroElegido
    }

    override fun jugarAhorcado() {
        println("")
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
}