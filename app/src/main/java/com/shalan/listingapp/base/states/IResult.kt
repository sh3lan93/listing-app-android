package com.shalan.listingapp.base.states

interface IResult<T> {

    fun fetchData(): T?

    fun fetchError(): Pair<Int, String?>?

    fun whichStatus(): ICommonStatus
}
