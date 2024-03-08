import Foundation

func solution(_ maps:[String]) -> Int {
    
    func append(x: Int, y: Int) {
        if visitArray[x][y] == false {
            visitArray[x][y] = true
            if mapArray[x][y] == "S" || mapArray[x][y] == "E" || mapArray[x][y] == "O" {
                queue.append((x: x, y: y))
            }
        }
    }
    
    func path(_ char: String) {
        var num = 0
        var x = leverIndex.x
        var y = leverIndex.y
        queue = [(x: x, y: y)]
        visitArray = Array(repeating: Array(repeating: false, count: colCount), count: rowCount)
        while queue.count != 0 {
            let point = queue.removeFirst()
            x = point.x
            y = point.y
            visitArray[x][y] = true
            
            if x != 0 {
                append(x: x-1, y: y)
            }
            if y != 0 {
                append(x: x, y: y-1)
            }
            if x != rowCount - 1 {
                append(x: x+1, y: y)
            }
            if y != colCount - 1 {
                append(x: x, y: y+1)
            }
            
            if mapArray[x][y] == char {
                result += 1
                if char == "S" {
                    start = true
                } else if char == "E" {
                    end = true
                }
                break
            }
            
            if num == 0 {
                num = queue.count
            } else if num <= 1 {
                num = queue.count
                result += 1
            } else {
                num -= 1
            }
        }
    }
    
    var queue: [(x: Int, y: Int)] = []
    var mapArray: [[String]] = []
    var leverIndex = (x: 0, y: 0)
    var result = 0
    var start = false
    var end = false
    
    for (i, row) in maps.enumerated() {
        let row = row.map { String($0) }
        mapArray.append(row)
        for (j, char) in row.enumerated() {
            if char == "L" {
                leverIndex = (x: i, y: j)
            }
        }
    }
    
    let rowCount = mapArray.count
    let colCount = mapArray[0].count
    var visitArray = Array(repeating: Array(repeating: false, count: colCount), count: rowCount)
    
    path("S")
    path("E")
    
    if start && end {
        return result
    } else {
        return -1
    }
}