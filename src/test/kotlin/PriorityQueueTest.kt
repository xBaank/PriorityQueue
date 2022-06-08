import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class PriorityQueueTest {

    private lateinit var queue: PriorityQueue<Proceso>

    @BeforeEach
    fun setUp() {
        queue = PriorityQueue(listOf(proceso2, proceso, proceso3))
    }


    var proceso = Proceso(1, "a", 1)
    var proceso2 = Proceso(2, "b", 2)
    var proceso3 = Proceso(3, "c", 3)

    @Test
    fun add() {
        Assertions.assertFalse(queue.add(proceso))
        Assertions.assertTrue(queue.add(proceso.copy(id = 12)))
    }

    @Test
    fun shouldAddAndRetrieve() {
        val result = proceso.copy(id = 14, prioridad = 0)

        queue.add(proceso.copy(id = 12, prioridad = 5))
        queue.add(proceso.copy(id = 13, prioridad = 7))
        queue.add(result)

        Assertions.assertEquals(queue.poll(), result)
    }

    @Test
    fun addAll() {
        val proceso4 = Proceso(4, "a", 4)
        val proceso5 = Proceso(5, "a", 4)
        Assertions.assertTrue(queue.addAll(listOf(proceso4, proceso5)))
        Assertions.assertFalse(queue.addAll(listOf(proceso, proceso2)))
    }

    @Test
    fun clear() {
        queue.clear()
        Assertions.assertTrue(queue.isEmpty())
    }

    @Test
    fun remove() {
        Assertions.assertTrue(queue.remove(proceso))
        Assertions.assertFalse(queue.remove(proceso))
    }

    @Test
    fun removePoll() {
        Assertions.assertSame(queue.remove(), proceso)
        queue.clear()
        Assertions.assertThrows(Exception::class.java) {
            queue.remove()
        }
    }

    @Test
    fun poll() {
        val procesoTrue = queue.poll()
        val procesoNotSame = queue.poll()
        Assertions.assertEquals(proceso, procesoTrue)
        Assertions.assertNotEquals(procesoTrue, procesoNotSame)
    }

    @Test
    fun peek() {
        val procesoTrue = queue.peek()
        val procesoTrueAgain = queue.peek()
        Assertions.assertEquals(proceso, procesoTrue)
        Assertions.assertEquals(procesoTrue, procesoTrueAgain)
    }
}