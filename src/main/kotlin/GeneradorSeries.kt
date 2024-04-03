import kotlin.math.abs

class GeneradorSeries(val consola:IMenu): IntGeneradorSeries {
    var MAXIMO = 0
    var MINIMO = 0

    override fun generarRangoAleatorio(){
        var numero:Int? = null
        while (numero == null){
            numero = (1..100).random()
            if(numero + 30<100){
                MINIMO = numero
                MAXIMO = numero + 30
            }else numero= null
        }
    }

    override fun generarSerie(){
        generarRangoAleatorio()
        val numero = consola.escogerNumero(MINIMO,MAXIMO)

        if(abs(MINIMO - numero) < abs(MAXIMO - numero)){
            serieCreciente(numero)
        }else{
            serieDecreciente(numero)
        }
    }

    override fun serieCreciente(digito:Int){
        var numero = digito
        var serie = ""
        var contador = 0
        var suma = 0
        serie += numero
        suma += numero
        consola.imprimir("$serie ($contador)")
        suma += numero
        contador ++
        numero ++
        for (i in (numero..MAXIMO)){
            serie += " + $i"
            suma += i
            consola.imprimir("$serie ($contador)")
            contador ++
        }
        consola.imprimir("Suma =>  $suma")

    }

    override fun serieDecreciente(digito:Int){
        var numero = digito
        var serie:String
        var contador = 0
        var suma = 0
        var total = 0
        var resta = 0

        for(i in (numero..MAXIMO)){
            serie = "$contador -> "
            resta = abs(numero - i)
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
            consola.imprimir(serie)
            suma = 0
        }
        consola.imprimir("Total => $total")
    }

}
interface IntGeneradorSeries{
    fun generarRangoAleatorio()

    fun generarSerie()

    fun serieCreciente(digito:Int)

    fun serieDecreciente(digito:Int)
}
