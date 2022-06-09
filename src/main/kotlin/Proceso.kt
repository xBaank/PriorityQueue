data class Proceso(val id: Int, val name: String, val prioridad: Int) : Comparable<Proceso> {
    override fun compareTo(other: Proceso): Int {
        if (id == other.id) return 0

        if (prioridad > other.prioridad) return 1

        return -1
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Proceso

        if (id != other.id) return false
        if (name != other.name) return false
        if (prioridad != other.prioridad) return false

        return true
    }

    override fun hashCode(): Int {
        return prioridad
    }


}
