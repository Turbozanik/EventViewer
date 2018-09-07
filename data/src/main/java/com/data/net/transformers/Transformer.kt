package com.data.net.transformers


interface Transformer<InputType, OutputType> {
    fun transform(params: InputType?): OutputType?
}