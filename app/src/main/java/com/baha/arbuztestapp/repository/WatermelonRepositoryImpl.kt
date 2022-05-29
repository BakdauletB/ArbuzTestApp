package com.baha.arbuztestapp.repository

import com.baha.arbuztestapp.model.Cell
import com.baha.arbuztestapp.model.Status
import com.baha.arbuztestapp.model.Watermelon
import kotlinx.coroutines.delay
import kotlin.random.Random

class WatermelonRepositoryImpl : WatermelonRepository {

    override suspend fun getGardenBedCells(): List<Cell> {
        delay(2000)
        val statuses = setOf(Status.Thwarted, Status.Ripe, Status.Unripe)

        val cells = arrayListOf<Cell>()
        for (i in 1..20) {
            val cell = Cell(id = i, name = "Место $i")
            val watermelons = arrayListOf<Watermelon>()
            for (j in 1..4) {
                val watermelon = Watermelon(
                    id = j,
                    status = statuses.random(),
                    weight = Random.nextInt(10, 20),
                )
                watermelons.add(watermelon)
            }
            cell.watermelons = watermelons
            cells.add(cell)
        }
        return cells
    }

    override suspend fun getListWaterMelon(): List<Watermelon> {
        delay(2000)
        val statuses = setOf(Status.Thwarted, Status.Ripe, Status.Unripe)

        return arrayListOf(
            Watermelon(
                id = 1,
                status = statuses.random(),
                weight = Random.nextInt(10, 20),
                amount = 0
            ),
            Watermelon(
                id = 1,
                status = statuses.random(),
                weight = Random.nextInt(10, 20),
                amount = 0
            ),
            Watermelon(
                id = 1,
                status = statuses.random(),
                weight = Random.nextInt(10, 20),
                amount = 0
            ),
            Watermelon(
                id = 1,
                status = statuses.random(),
                weight = Random.nextInt(10, 20),
                amount = 0
            ),
            Watermelon(
                id = 1,
                status = statuses.random(),
                weight = Random.nextInt(10, 20),
                amount = 0
            )
        )

    }
}