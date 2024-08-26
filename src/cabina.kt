data class Llamada(val tipo: TipoLlamada, val duracion: Int)

enum class TipoLlamada(val costoPorMinuto: Int) {
    LOCAL(50),
    LARGA_DISTANCIA(350),
    CELULAR(150)
}

class Cabina {
    private val llamadas = mutableListOf<Llamada>()
    var numeroLlamadas: Int = 0
        private set
    var duracionTotal: Int = 0
        private set
    var costoTotal: Int = 0
        private set

    fun registrarLlamada(tipo: TipoLlamada, duracion: Int) {
        val llamada = Llamada(tipo, duracion)
        llamadas.add(llamada)
        numeroLlamadas++
        duracionTotal += duracion
        costoTotal += tipo.costoPorMinuto * duracion
    }

    fun mostrarInformacionCabina() {
        println("Número de llamadas realizadas: $numeroLlamadas")
        println("Duración total de las llamadas: $duracionTotal minutos")
        println("Costo total de las llamadas: $costoTotal pesos")
    }

    fun reiniciarCabina() {
        llamadas.clear()
        numeroLlamadas = 0
        duracionTotal = 0
        costoTotal = 0
    }
}

class Empresa(private val cabinas: List<Cabina>) {
    fun mostrarConsolidadoTotal() {
        val totalLlamadas = cabinas.sumOf { it.numeroLlamadas }
        val totalDuracion = cabinas.sumOf { it.duracionTotal }
        val totalCosto = cabinas.sumOf { it.costoTotal }
        val costoPromedioPorMinuto = if (totalDuracion > 0) totalCosto / totalDuracion else 0

        println("Número total de llamadas realizadas: $totalLlamadas")
        println("Duración total de las llamadas: $totalDuracion minutos")
        println("Costo total de las llamadas: $totalCosto pesos")
        println("Costo promedio por minuto: $costoPromedioPorMinuto pesos")
    }
}
