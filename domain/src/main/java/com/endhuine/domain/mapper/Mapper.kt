package com.endhuine.domain.mapper

/**
 * Class for mapping a input class [Input] in a output class [Output]
 */
interface Mapper<Input, Output> {

    /**
     * map the [input] to the desired [Output]
     *
     * @param input the object to map
     * @return the mapped class as [Output]
     */
    fun map(input: Input): Output

    /**
     * Map an [input] list of [Input] into a list of [Output]
     *
     * @param input as the list to map
     * @return a list of [Output]
     */
    fun map(input: List<Input>) = input.map { map(it) }
}
