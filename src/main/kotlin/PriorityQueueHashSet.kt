import java.util.*

class PriorityQueueHashSet<T>(collection: Collection<T> = emptyList()) : Queue<T> {
    private val queue: AbstractSet<T>

    init {
        queue = HashSet(collection)
    }

    override fun add(element: T): Boolean = queue.add(element)

    override fun addAll(elements: Collection<T>): Boolean = queue.addAll(elements)

    override fun clear() = queue.clear()

    override fun iterator(): MutableIterator<T> = queue.iterator()

    override fun remove(): T {
        val item = queue.firstOrNull() ?: throw Exception("Queue is empty")
        queue.remove(item)
        return item
    }

    override fun retainAll(elements: Collection<T>): Boolean = queue.retainAll(elements.toSet())

    override fun removeAll(elements: Collection<T>): Boolean = queue.removeAll(elements.toSet())

    override fun remove(element: T): Boolean = queue.remove(element)

    override fun isEmpty(): Boolean = queue.isEmpty()

    override fun poll(): T? {
        val item = queue.firstOrNull()
        queue.remove(item)
        return item

    }

    override fun element(): T = queue.firstOrNull() ?: throw Exception("Queue is empty")

    override fun peek(): T? = queue.firstOrNull()

    override fun offer(e: T): Boolean = queue.add(e)

    override fun containsAll(elements: Collection<T>): Boolean = queue.containsAll(elements.toSet())

    override fun contains(element: T): Boolean = queue.contains(element)

    override val size: Int
        get() = queue.size

}