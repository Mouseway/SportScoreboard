package com.example.sportscoreboard.domain.filters

enum class EntityFilter(val id: Int, val title: String) {
    ALL(0, title = "All"), CONTEST(1, title = "Contest"), TEAM(2, title = "Team"), SINGLE_PLAYER(3, title = "Player");

    companion object {
        fun getById(id: Int): EntityFilter {
            return values().find { it.id == id } ?: ALL
        }
    }
}