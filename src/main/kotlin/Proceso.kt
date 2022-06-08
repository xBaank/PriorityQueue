data class Proceso(val id: Int, val name: String, val prioridad: Int) : Comparable<Proceso> {
    override fun compareTo(other: Proceso): Int {
        if (id == other.id) return 0

        if (prioridad > other.prioridad) return 1

        return -1
    }

}
