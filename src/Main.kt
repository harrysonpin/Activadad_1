/*
 Primer (1) Ejercicio
Se quiere crear una aplicación para controlar los gastos telefónicos de una empresa. La empresa cuenta con N cabinas telefónicas
 a través de las cuales se pueden realizar llamadas locales, de larga distancia y a celulares.
La empresa cuenta con planes telefónicos que establecen las siguientes tarifas:
Minuto Llamada Local: $50 pesos
Minuto Llamada Larga Distancia: $350 pesos
Minuto Llamada Celular: $150 pesos
La aplicación debe permitir:
1.Registrar una llamada de acuerdo con la cabina
2.Mostrar la información detallada de la cabina (número de llamadas realizadas, duración total de las llamadas en minutos
y el costo total de las llamadas en pesos)
3.Mostrar un consolidado total de la información de las cabinas (costo total en pesos de la línea, número total de
llamadas realizadas, duración total de llamadas en minutos y el cálculo del costo promedio por minuto según el costo total y el total de minutos).
Adicionalmente, la aplicación debe permitir reiniciar el uso de la cabina telefónica, dejando todos sus valores en cero.
*/
    fun main() {
        val cabina1 = Cabina()
        val cabina2 = Cabina()
        val empresa = Empresa(listOf(cabina1, cabina2))

        cabina1.registrarLlamada(TipoLlamada.LOCAL, 10)
        cabina1.registrarLlamada(TipoLlamada.CELULAR, 5)
        cabina2.registrarLlamada(TipoLlamada.LARGA_DISTANCIA, 2)

        cabina1.mostrarInformacionCabina()
        cabina2.mostrarInformacionCabina()
        empresa.mostrarConsolidadoTotal()

        cabina1.reiniciarCabina()
        cabina1.mostrarInformacionCabina()
    }
