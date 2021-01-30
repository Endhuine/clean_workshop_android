package com.endhuine.domain.usecase.base

import kotlinx.coroutines.flow.Flow

interface ResultUseCase<Output> {

    fun execute(): Flow<Output>
}