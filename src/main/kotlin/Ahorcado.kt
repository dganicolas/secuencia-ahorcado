import com.google.gson.Gson
import java.io.File

object Ahorcado: IntAhorcado {

    val intentosMaximos =5
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

    override fun obtenerPalabraAleatoria(): String {
        val palabras = if (ES_JSON) leerFicheroJSON(RUTA_JSON) else leerFicheroTexto(RUTA_TEXTO)
        return palabras.random()
    }

    private fun obtenerPalabraOcultaDescubierta(letrasCorrectas: Set<Char>): String {
        return palabraOculta.map { if (it in letrasCorrectas) it else '_' }.joinToString(" ")
    }

    //preguntar a diego si esto funciona,
    override fun jugar(consola: IntgestorConsola) {
        palabraOculta = obtenerPalabraAleatoria()

    }

}
interface IntAhorcado {
    fun obtenerPalabraAleatoria():String
    fun jugar(gestorConsola: IntgestorConsola)
}
