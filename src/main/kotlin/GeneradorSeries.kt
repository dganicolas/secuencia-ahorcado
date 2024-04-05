import kotlin.math.abs

class GeneradorSeries(): IntGeneradorSeries {
    var MAXIMO = 0
    var MINIMO = 0

    override fun generarRangoAleatorio():Int{
        var numero:Int? = null
        while (numero == null){
            numero = (1..100).random()
            if(numero + 30<100){
                MINIMO = numero
                MAXIMO = numero + 30
            }else numero= null
        }
        return MINIMO
    }

    override fun generarSerie(numero: Int): String {
        return if(abs(MINIMO - numero) < abs(MAXIMO - numero)){
            serieCreciente(numero)
        }else{
            serieDecreciente(numero)
        }
    }

    override fun serieCreciente(digito:Int): String {
        var numero = digito
        var serie = "$numero"
        var frase = ""
        var contador = 0
        var suma = 0
        frase += "$numero ($contador)\n"
        suma += numero
        suma += numero
        contador ++
        numero ++
        for (i in (numero..MAXIMO)){
            serie += " + $i"
            suma += i
            frase +="$serie ($contador)\n"
            contador ++
        }
        frase += "Suma =>  $suma"
        return frase
    }

    override fun serieDecreciente(digito:Int): String {
        val numero = digito
        var serie:String
        var frase = ""
        var contador = 0
        var suma = 0
        var total = 0

        for(i in (numero..MAXIMO)){
            serie = "$contador -> "
            var numeroFila = i
            for(i in (numeroFila..MAXIMO-1)){

                suma += numeroFila
                serie += "$numeroFila + "
                numeroFila++
            }
            suma += numeroFila
            serie += "$numeroFila"

            contador ++
            total += suma
            serie += " = $suma"
            frase += "$serie\n"
            suma = 0

        }
        frase += "Total => $total"
        return frase
    }

}
interface IntGeneradorSeries{
    fun generarRangoAleatorio():Int

    fun generarSerie(numero:Int): String

    fun serieCreciente(digito:Int): String

    fun serieDecreciente(digito:Int): String
}
