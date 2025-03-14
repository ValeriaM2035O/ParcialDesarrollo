class Reserva (
    val idReserva: Int,
    val idHuesped: Int,
    val nombreHuesped: String,
    val emailHuesped: String,
    val numeroHabitacion: Int,
    val tipoHabitacion: String,
    val precioNoche: Double,
    val nochesReservadas: Int,
){
    fun montoTotal(): Double{
        return precioNoche * nochesReservadas
    }
}