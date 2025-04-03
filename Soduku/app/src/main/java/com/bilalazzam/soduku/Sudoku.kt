package com.bilalazzam.soduku

interface Sudoku {

    fun isValidSudoku(grid: List<List<Char>>): Boolean
    fun isSolved(grid: List<List<Char>>): Boolean
}