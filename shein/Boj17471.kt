import java.io.*
import java.util.*
import kotlin.collections.*

class Boj17471 {

    lateinit var n = 0
    lateinit var m = 0

    lateinit var po: List<Int>
    lateinit var graph: Array<ArrayList<Int>>
    lateinit var set: MutableSetOf<Int>

    var result = Int.MAX_VALUE

    fun solution(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))

        n = br.readLine().toInt()

        set = mutableSetOf<Int>()
        for (i in 1..n) set.add(i)

        po = br.readLine().split(" ").map { it.toInt() }
        graph = Array(n + 1) { ArrayList() }

        for (i in 1..n) {
            val temp = br.readLine().split(" ").map { it.toInt() }
            for (t in 1..temp.lastIndex) graph[i].add(temp[t])
        }

        for (i in 1..n / 2) {
            combination(1, i, mutableListOf<Int>())
        }

        if (result == Int.MAX_VALUE) println(-1)
        else println(result)
    }

    fun combination(start: Int, target: Int, group: MutableList<Int>) {
        if (target == 0) {
            bfs(group) // bfs 시작
        }

        for (i in start..n) {
            group.add(i)
            combination(i + 1, target - 1, group)
            group.removeAt(group.lastIndex)
        }
    }

    fun bfs(group: MutableList<Int>) {
        val diff = set.minus(group.toMutableSet()).toMutableList()

        val visited = BooleanArray(n + 1)
        val queue: Queue<Int> = LinkedList()

        queue.add(group[0])
        visited[group[0]] = true

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            for (i in graph[node]) {
                if (!group.contains(i)) continue
                if (!visited[i]) queue.add(i)
            }
        }

        for (g in group) {
            if (!visited[g]) return // 방문해야하는 그룹의 노드를 방문하지 않은 경우 종료
            visited[g] = false // 방문 초기화
        }

        queue.add(diff[0])
        visited[diff[0]] = true

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            for (i in graph[node]) {
                if (!diff.contains(i)) continue
                if (!visited[i]) queue.add(i)
            }
        }

        for (d in diff) {
            if (!visited[d]) return // 방문해야하는 그룹의 노드를 방문하지 않은 경우 종료
            visited[d] = false // 방문 초기화
        }

        val groupPo = group.sumBy { po[it - 1] }
        val diffPo = diff.sumBy { po[it - 1] }

        result = min(result, abs(groupPo, diffPo))
    }
}