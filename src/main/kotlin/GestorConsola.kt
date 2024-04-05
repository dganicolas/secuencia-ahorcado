class GestorConsola: IntgestorConsola{
    override fun imprimir(mensaje: String) {
        println(mensaje)
    }

    override fun pedir(mensaje: String): String {
        print(mensaje)
        return readln()
    }
}

interface IntgestorConsola {
    fun imprimir(mensaje:String)
    fun pedir(mensaje:String):String
}