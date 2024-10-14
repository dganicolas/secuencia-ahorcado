import com.google.gson.Gson
import java.io.File

object Ahorcado: IntAhorcado {

    var partidaGanada = true
    var INTENTOS_MAXIMO =5
    val RUTA_TEXTO = "src/palabras.txt"
    val RUTA_JSON = "src/palabras.json"
    var ES_JSON = true
    var palabraOculta = ""
    data class Palabras(val palabras: List<String>)

    fun leerFicheroTexto(ruta: String): List<String> = File(ruta).readLines()

    fun leerFicheroJSON(ruta: String): List<String> {
        val json = File(ruta).readText()
        return Gson().fromJson(json, Palabras::class.java).palabras
    }

    fun obtenerPalabraAleatoria(): String {
        val palabras = if (ES_JSON) leerFicheroJSON(RUTA_JSON) else leerFicheroTexto(RUTA_TEXTO)
        return palabras.random()
    }

    private fun obtenerPalabraOcultaDescubierta(letrasCorrectas: List<Char>): String {
        return palabraOculta.map { if (it in letrasCorrectas) it else '_' }.joinToString(" ")
    }

    fun pedirLetra(gestorConsola: IntgestorConsola):Char{
        var palabra:String
        do{
            palabra = gestorConsola.pedir("dame una letra")
            if (palabra.length > 1){
                gestorConsola.imprimir("error debe ser una letra")
            }
        }while (palabra.length > 1)
        return palabra.toCharArray()[0]
    }

    //preguntar a diego si esto funciona,
    override fun jugar(gestorConsola: IntgestorConsola,intentos:Int) {
        var letrasCorrectas = mutableListOf<Char>()
        INTENTOS_MAXIMO = intentos
        palabraOculta = obtenerPalabraAleatoria()
        while (INTENTOS_MAXIMO >0 && palabraOculta in "_"){
            gestorConsola.imprimir("la letra es: $palabraOculta")
            val palabra = pedirLetra(gestorConsola)
            letrasCorrectas.add(palabra)
            obtenerPalabraOcultaDescubierta(letrasCorrectas)
        }
        if (palabraOculta in "_"){
            gestorConsola.imprimir("has perdido la palabra era: $palabraOculta")
        }else{
            gestorConsola.imprimir("felicidades has adivinado la palabra $palabraOculta")
        }

    }

}
interface IntAhorcado {
    fun jugar(gestorConsola: IntgestorConsola,intentos:Int=5)
}
