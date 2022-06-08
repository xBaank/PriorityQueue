import java.util.*

class PriorityQueue<T>(collection: Collection<T>, comparator: Comparator<T>? = null) : Queue<T> {
    private val queue: SortedSet<T>

    constructor() : this(TreeSet())


    init {
        if (comparator != null) {
            queue = TreeSet(comparator)
            queue.addAll(collection)
        } else
            queue = TreeSet(collection)
    }

    override fun add(element: T): Boolean {
        return queue.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            if (!add(element)) return false
        }
        return true
    }

    override fun clear() {
        queue.clear()
    }

    override fun iterator(): MutableIterator<T> {
        return queue.iterator()
    }

    override fun remove(): T {
        val item = queue.firstOrNull() ?: throw Exception("Queue is empty")
        queue.remove(item)
        return item
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        return queue.retainAll(elements.toSet())
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        return queue.removeAll(elements.toSet())
    }

    override fun remove(element: T): Boolean {
        return queue.remove(element)
    }

    override fun isEmpty(): Boolean = size == 0

    override fun poll(): T? {
        val item = queue.firstOrNull()
        queue.remove(item)
        return item

    }

    override fun element(): T {
        return queue.firstOrNull() ?: throw Exception("Queue is empty")
    }

    override fun peek(): T? {
        return queue.firstOrNull()
    }

    override fun offer(e: T): Boolean {
        return queue.add(e)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return queue.containsAll(elements.toSet())
    }

    override fun contains(element: T): Boolean {
        return queue.contains(element)
    }

    override val size: Int
        get() = queue.size

}