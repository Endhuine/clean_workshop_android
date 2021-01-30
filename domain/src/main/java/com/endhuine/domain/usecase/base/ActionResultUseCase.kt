package com.endhuine.domain.usecase.base

import kotlinx.coroutines.flow.Flow

interface ActionResultUseCase<Input, Output> {

    fun execute(params: Input): Flow<Output>
}