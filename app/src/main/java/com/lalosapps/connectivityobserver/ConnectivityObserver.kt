package com.lalosapps.connectivityobserver

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observeStatus(): Flow<Status>
}