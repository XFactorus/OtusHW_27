package com.vladp.otusmultiapp.shared.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class PresenterCoroutineScope (private val context: CoroutineContext) : CoroutineScope {
    private  var onViewDetachJob = Job()
    override val coroutineContext: CoroutineContext
        get() = context + onViewDetachJob

    fun viewDetached() {
        onViewDetachJob.cancel()
    }
}