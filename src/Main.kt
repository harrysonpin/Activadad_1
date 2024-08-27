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
    val cabinas = mutableListOf<Cabina>()
    var opcion: Int

    do {
        println("\n1. Crear nueva cabina")
        println("2. Registrar llamada")
        println("3. Mostrar información de cabina")
        println("4. Mostrar consolidado total")
        println("5. Reiniciar cabina")
        println("0. Salir")
        print("Seleccione una opción: ")

        opcion = readLine()?.toIntOrNull() ?: -1

        when (opcion) {
            1 -> {
                cabinas.add(Cabina())
                println("Nueva cabina creada. Total de cabinas: ${cabinas.size}")
            }
            2 -> {
                if (cabinas.isEmpty()) {
                    println("No hay cabinas creadas.")
                } else {
                    var numCabina: Int
                    do {
                        print("Número de cabina (1-${cabinas.size}): ")
                        numCabina = readLine()?.toIntOrNull() ?: 0
                        if (numCabina !in 1..cabinas.size) {
                            println("Número de cabina inválido. Por favor, intente nuevamente.")
                        }
                    } while (numCabina !in 1..cabinas.size)

                    var tipoLlamada: TipoLlamada
                    do {
                        println("Tipo de llamada:")
                        println("1. LOCAL")
                        println("2. CELULAR")
                        println("3. LARGA_DISTANCIA")
                        print("Ingrese el número o el nombre del tipo de llamada: ")
                        val input = readLine()?.toUpperCase() ?: ""
                        tipoLlamada = when (input) {
                            "1", "LOCAL" -> TipoLlamada.LOCAL
                            "2", "CELULAR" -> TipoLlamada.CELULAR
                            "3", "LARGA_DISTANCIA" -> TipoLlamada.LARGA_DISTANCIA
                            else -> {
                                println("Tipo de llamada inválido. Por favor, intente nuevamente.")
                                continue
                            }
                        }
                        break
                    } while (true)

                    print("Duración en minutos: ")
                    val minutos = readLine()?.toIntOrNull() ?: 0
                    cabinas[numCabina - 1].registrarLlamada(tipoLlamada, minutos)
                    println("Llamada registrada.")
                }
            }
            3 -> {
                if (cabinas.isEmpty()) {
                    println("No hay cabinas creadas.")
                } else {
                    print("Número de cabina (1-${cabinas.size}): ")
                    val numCabina = readLine()?.toIntOrNull() ?: 0
                    if (numCabina in 1..cabinas.size) {
                        cabinas[numCabina - 1].mostrarInformacionCabina()
                    } else {
                        println("Número de cabina inválido.")
                    }
                }
            }
            4 -> {
                val empresa = Empresa(cabinas)
                empresa.mostrarConsolidadoTotal()
            }
            5 -> {
                if (cabinas.isEmpty()) {
                    println("No hay cabinas creadas.")
                } else {
                    print("Número de cabina (1-${cabinas.size}): ")
                    val numCabina = readLine()?.toIntOrNull() ?: 0
                    if (numCabina in 1..cabinas.size) {
                        cabinas[numCabina - 1].reiniciarCabina()
                        println("Cabina reiniciada.")
                    } else {
                        println("Número de cabina inválido.")
                    }
                }
            }
            0 -> println("Saliendo del programa.")
            else -> println("Opción inválida.")
        }
    } while (opcion != 0)
}