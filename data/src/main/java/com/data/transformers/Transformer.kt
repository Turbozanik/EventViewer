package com.data.transformers


interface Transformer<InputType, OutputType> {
    fun transform(params: InputType): OutputType?
}