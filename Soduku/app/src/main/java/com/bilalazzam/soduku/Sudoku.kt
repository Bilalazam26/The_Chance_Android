package com.bilalazzam.soduku

import kotlin.math.sqrt

object Sudoku {
    fun isValidSudoku(grid: List<List<Char>>): Boolean {
        val size = grid.size
        val subgridSize = sqrt(size.toDouble()).toInt()

        return (grid.all(::isValidSet) &&
                (0 until size).all { col -> isValidSet(grid.map { it[col] }) } &&
                (0 until size step subgridSize).all { row ->
                    (0 until size step subgridSize).all { col ->
                        /*
                        (0,0) (0,3) (0,6)
                        (3,0) (3,3) (3,6)
                        (6,0) (6,3) (6,6)
                        */
                        isValidSet(collectSubgrid(grid, row, col, subgridSize))
                    }
                })
    }

    // Helper function to check for duplicates
    private fun isValidSet(elements: List<Char>) =
        elements.filter { it != '-' }.let { it.size == it.toSet().size }

    // Extracts values from a subgrid
    private fun collectSubgrid(grid: List<List<Char>>, row: Int, col: Int, subgridSize: Int) =
        List(subgridSize * subgridSize) { i -> grid[row + i / subgridSize][col + i % subgridSize] }



    fun isSolved(board: List<List<Char>>): Boolean {
        return isValidSudoku(board) && board.all { row -> row.all { it in '1'..'9' } }
    }
}

fun Int.asCodeToChar(): Char = when {
    this < 10 -> this.digitToChar()
    this in 10..16 -> (this+55).toChar()
    else -> '-'
}

fun List<List<Char>>.update(row: Int, col: Int, value: Char): List<List<Char>> {
    return this.mapIndexed { rowIndex, rowList ->
        rowList.mapIndexed { colIndex, item ->
            if (row == rowIndex && col == colIndex) {
                value
            } else {
                item
            }
        }
    }
}