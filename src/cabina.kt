//almacena datos de los tipos de llamda
enum class TipoLlamada {
    LOCAL, CELULAR, LARGA_DISTANCIA
}
//logica de la cabina
class Cabina {
    private var llamadasLocales = 0
    private var llamadasCelulares = 0
    private var llamadasLargaDistancia = 0
    private var totalMinutos = 0
//timer de la llamada
    fun registrarLlamada(tipo: TipoLlamada, minutos: Int) {
        when (tipo) {
            TipoLlamada.LOCAL -> llamadasLocales++
            TipoLlamada.CELULAR -> llamadasCelulares++
            TipoLlamada.LARGA_DISTANCIA -> llamadasLargaDistancia++
        }
        totalMinutos += minutos
    }

    fun mostrarInformacionCabina() {
        println("Llamadas locales: $llamadasLocales")
        println("Llamadas celulares: $llamadasCelulares")
        println("Llamadas larga distancia: $llamadasLargaDistancia")
        println("Total minutos: $totalMinutos")
    }

    fun reiniciarCabina() {
        llamadasLocales = 0
        llamadasCelulares = 0
        llamadasLargaDistancia = 0
        totalMinutos = 0
    }
    fun obtenerLlamadasLocales(): Int = llamadasLocales
    fun obtenerLlamadasCelulares(): Int = llamadasCelulares
    fun obtenerLlamadasLargaDistancia(): Int = llamadasLargaDistancia
    fun obtenerTotalMinutos(): Int = totalMinutos
}

class Empresa(private val cabinas: List<Cabina>) {
    fun mostrarConsolidadoTotal() {
        var totalLlamadasLocales = 0
        var totalLlamadasCelulares = 0
        var totalLlamadasLargaDistancia = 0
        var totalMinutos = 0

        println("\nConsolidado total de la empresa:")
        println("================================")

        cabinas.forEachIndexed { index, cabina ->
            println("\nCabina ${index + 1}:")
            println("-------------")
            cabina.mostrarInformacionCabina()

            totalLlamadasLocales += cabina.obtenerLlamadasLocales()
            totalLlamadasCelulares += cabina.obtenerLlamadasCelulares()
            totalLlamadasLargaDistancia += cabina.obtenerLlamadasLargaDistancia()
            totalMinutos += cabina.obtenerTotalMinutos()
        }

        println("\nResumen total:")
        println("--------------")
        println("Total de llamadas locales: $totalLlamadasLocales")
        println("Total de llamadas celulares: $totalLlamadasCelulares")
        println("Total de llamadas larga distancia: $totalLlamadasLargaDistancia")
        println("Total de llamadas: ${totalLlamadasLocales + totalLlamadasCelulares + totalLlamadasLargaDistancia}")
        println("Total de minutos: $totalMinutos")
    }
}