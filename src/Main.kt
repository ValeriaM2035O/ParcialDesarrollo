fun main() {
    val lstReservas = mutableListOf<Reserva>()
    val habitacionesReservadas = mutableSetOf<Int>()
    var idReservaCounter = 1

    do {
        println(
            """
              MENU DE OPCIONES
               1. Registrar reserva
               2. Cancelar reserva
               3. Reservas activas
               4. Salir
              Seleccione opcion:
          """.trimIndent()
        )

        val opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("Ingrese id del huesped:")
                val idHuesped = readln().toInt()
                println("Ingrese nombre del huesped:")
                val nombreHuesped = readln()
                println("Ingrese email del huesped:")
                val emailHuesped = readln()
                println("Ingrese numero de habitacion:")
                val numeroHabitacion = readln().toInt()
                if (habitacionesReservadas.contains(numeroHabitacion)) {
                    println("La habitación número $numeroHabitacion ya está reservada.")
                    continue
                }
                println("Ingrese tipo de habitacion:")
                val tipoHabitacion = readln()
                println("Ingrese precio por noche:")
                val precioNoche = readln().toDouble()
                println("Ingrese cantidad de noches reservadas:")
                val nochesReservadas = readln().toInt()


                val nuevaReserva = Reserva(
                    idReservaCounter++,
                    idHuesped,
                    nombreHuesped,
                    emailHuesped,
                    numeroHabitacion,
                    tipoHabitacion,
                    precioNoche,
                    nochesReservadas
                )
                lstReservas.add(nuevaReserva)
                habitacionesReservadas.add(numeroHabitacion)
                println("Reserva registrada con éxito. id: $idReservaCounter")
            }
            2 ->{
                println("Ingrese id de la reserva a cancelar.")
                val idRCancelada = readln().toInt()

                if (idRCancelada != null) {
                    val reservaAEliminar = lstReservas.find { reserva -> reserva.idReserva == idRCancelada }
                    if (reservaAEliminar != null) {
                        lstReservas.remove(reservaAEliminar)
                        habitacionesReservadas.remove(reservaAEliminar.numeroHabitacion)
                        println("Reserva cancelada exitosamente.")
                    } else {
                        println("No se encontró una reserva con el ID proporcionado.")
                    }
                } else {
                    println("ID inválido.")
                }
            }
            3 ->{
                println("Reservas activas:")
                if (lstReservas.isEmpty()) {
                    println("No hay reservas activas.")
                } else {
                    lstReservas.forEach { reserva ->
                        println(
                            "ID Reserva: ${reserva.idReserva}, " +
                                    "Nombre Huésped: ${reserva.nombreHuesped}, " +
                                    "Email: ${reserva.emailHuesped}, " +
                                    "Número Habitación: ${reserva.numeroHabitacion}, " +
                                    "Tipo Habitación: ${reserva.tipoHabitacion}, " +
                                    "Precio por Noche: ${reserva.precioNoche}, " +
                                    "Noches Reservadas: ${reserva.nochesReservadas}, " +
                                    "Monto Total a Pagar: ${reserva.montoTotal()}"
                        )
                    }
                }
            }
            4 -> println("Saliendo del programa")
            else -> println("Opción no válida, intente de nuevo")
        }

    } while (opcion != 4)
}