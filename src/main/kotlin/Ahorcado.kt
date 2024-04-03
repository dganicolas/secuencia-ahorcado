import com.google.gson.Gson
import java.io.File

class Ahorcado {
    val RUTA_TEXTO = "src/palabras.txt"
    val RUTA_JSON = "src/palabras.json"
    var ES_JSON = true

    data class Palabras(val palabras: List<String>)

    fun leerFicheroTexto(ruta: String): List<String> = File(ruta).readLines()

    fun leerFicheroJSON(ruta: String): List<String> {
        val json = File(ruta).readText()
        return Gson().fromJson(json, Palabras::class.java).palabras
    }
}

