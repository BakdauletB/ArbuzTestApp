package com.baha.arbuztestapp.repository

import com.baha.arbuztestapp.model.Cell
import com.baha.arbuztestapp.model.Watermelon

interface WatermelonRepository {
    suspend fun getGardenBedCells(): List<Cell>
    suspend fun getListWaterMelon(): List<Watermelon>
}