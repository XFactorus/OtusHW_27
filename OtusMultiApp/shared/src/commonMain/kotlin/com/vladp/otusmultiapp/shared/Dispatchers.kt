package com.vladp.otusmultiapp.shared

import kotlin.coroutines.CoroutineContext

expect val ioDispatcher: CoroutineContext
expect val uiDispatcher: CoroutineContext