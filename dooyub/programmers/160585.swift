import Foundation

func solution(_ board:[String]) -> Int {
    
    func check(_ char: String) {
        if char == "O" {
            bingoO += 1
        } else if char == "X" {
            bingoX += 1
        }
    }
    
    var arr = [[String]](repeating: [], count: 3)
    var numO = 0
    var numX = 0
    var bingoO = 0
    var bingoX = 0
    
    for i in 0..<3 {
        let row = board[i].map { String($0) }
        arr[i] = row
        for i in row {
            if i == "O" {
                numO += 1
            } else if i == "X" {
                numX += 1
            }
        }
    }
    
    for i in 0..<3 {
        if arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2] {
            check(arr[i][0])
        }
        
        if arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i] {
            check(arr[0][i])
        }
    }
    
    if arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] || arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0] {
        check(arr[1][1])
    }
    
    if numO - numX == 1 || numO - numX == 0 {
        if bingoO + bingoX == 0 {
            return 1
        } else if bingoO >= 1 && bingoX == 0 && numO == numX + 1 {
            return 1
        } else if bingoO == 0 && bingoX == 1 && numO == numX {
            return 1
        } else {
            return 0
        }
    } else {
        return 0
    }
}