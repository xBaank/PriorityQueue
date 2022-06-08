class ProcesoComparator : Comparator<Proceso> {
    override fun compare(o1: Proceso?, o2: Proceso?): Int {
        if (o1?.id == o2?.id) return 0

        if (o1 == null || o2 == null) return -1

        if (o1.prioridad > o2.prioridad) return 1

        return -1
    }
}