package com.example.core.data.model.local

sealed class ConnectionState {
    object Available : ConnectionState()
    object UnAvailable : ConnectionState()
}